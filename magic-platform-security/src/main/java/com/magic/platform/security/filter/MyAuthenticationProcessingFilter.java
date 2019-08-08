package com.magic.platform.security.filter;

import com.magic.platform.core.exception.CustomException;
import com.magic.platform.core.jwt.Token;
import com.magic.platform.core.model.ResponseModel;
import com.magic.platform.security.core.userdetails.CustomUserDetailsService;
import com.magic.platform.util.ResponseUtil;
import io.jsonwebtoken.Claims;
import java.io.IOException;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-08-31 13:13
 * @Modified By:
 */
//s@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class MyAuthenticationProcessingFilter extends OncePerRequestFilter {
  @Value("${framework.security.white-list: ''}")
  private String whiteList;

  @Autowired
  private CustomUserDetailsService userDetailsService;

  /**
   * 过滤器拦截：主要验证 jwt token 是否有效
   */
/*  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

//    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//    String username = (String) requestAttributes.getAttribute("username", RequestAttributes.SCOPE_REQUEST);

    ServletRequestWrapper requestWrapper = new ServletRequestWrapper(request);

    String param = requestWrapper.getRequestParam();

    RequestModel requestModel = JSON.parseObject(param, RequestModel.class);

    try {
      if (requestModel != null && !StringUtils.isEmpty(requestModel.getAccessToken())) {

        String accessToken = requestModel.getAccessToken();

        Claims claims = Token.parseAccessToken2Claims(accessToken);

        String username = null;
        if (claims != null) {
          username = claims.getSubject();
        }

        // jwt 解析用户名成功，并且没有授权信息说明，刚刚登录获取到了 accessToken，并未构造 Authentication 对象
        if (!StringUtils.isEmpty(username)) {

          if (SecurityContextHolder.getContext().getAuthentication() == null) {
            // 用户信息
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // 凭证-即使设置也会被擦除
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());

            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
          }
        }
      }
    } catch (CustomException e) {

      this.exceptionHandler(request, response, e);
      return;
    }
    filterChain.doFilter(requestWrapper, response);
  }*/


  /**
   * 本 filter 中的异常处理，直接跳过不执行后面的过滤器
   */
  private void exceptionHandler(HttpServletRequest request, HttpServletResponse response, CustomException exception) throws IOException {
    ResponseModel model = ResponseModel.builder()
        .code(exception.getCode())
        .message(exception.getMessage())
        .path(request.getRequestURI())
        .timestamp(new Date()).build();

    ResponseUtil.write(response, model);
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    AntPathMatcher antPathMatcher = new AntPathMatcher();
    String path = request.getRequestURI();

    // 1. 是否匹配 /auth/**
    boolean authFlag = antPathMatcher.match("/auth/**", path);

    // 2. 是否匹配白名单
    boolean flag = false;
    if (!StringUtils.isEmpty(whiteList) && !authFlag) {
      String[] list = whiteList.split(",");
      for (String whiteUrl : list) {
        if (antPathMatcher.match(whiteUrl, path)) {
          // 说明路径在白名单中
          flag = true;
          break;
        }
      }
    }

    String authorization = request.getHeader("authorization");

    if (!StringUtils.isEmpty(authorization) && !(flag || authFlag)) {

      String accessToken = authorization.replaceAll("Bearer ", "");

      if (!StringUtils.isEmpty(accessToken)) {

        try {
          Claims claims = Token.parseAccessToken2Claims(accessToken);

          String username = null;
          if (claims != null) {
            username = claims.getSubject();
          }

          // jwt 解析用户名成功，并且没有授权信息说明，刚刚登录获取到了 accessToken，并未构造 Authentication 对象
          if (!StringUtils.isEmpty(username)) {

            if (SecurityContextHolder.getContext().getAuthentication() == null) {
              // 用户信息
              UserDetails userDetails = userDetailsService.loadUserByUsername(username);

              // 凭证-即使设置也会被擦除
              UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                  userDetails.getAuthorities());

              authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
              SecurityContextHolder.getContext().setAuthentication(authentication);
            }
          }
        } catch (CustomException e) {

          this.exceptionHandler(request, response, e);
          return;
        }
      }
    }

    filterChain.doFilter(request, response);
  }
}

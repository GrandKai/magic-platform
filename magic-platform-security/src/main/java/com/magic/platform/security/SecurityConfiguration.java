package com.magic.platform.security;

import com.magic.platform.security.access.MyAccessDecisionManager;
import com.magic.platform.security.access.MySecurityMetadataSource;
import com.magic.platform.security.entrypoint.MyAuthenticationEntryPoint;
import com.magic.platform.security.filter.MyAuthenticationProcessingFilter;
import com.magic.platform.security.hanlder.CustomAccessDeniedHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.util.StringUtils;

/**
 * @Author: zhangyn
 * @Description:
 * @Date: Created in 2018-05-21 17:17
 * @Modified By:
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Value("${framework.security.switch: false}")
  private boolean securitySwitch;
  @Value("${framework.security.white-list: ''}")
  private String whiteList;

  @Autowired
  private CustomAccessDeniedHandler customAccessDeniedHandler;

  @Autowired
  private MySecurityMetadataSource mySecurityMetadataSource;

  @Autowired
  private MyAccessDecisionManager myAccessDecisionManager;

  @Autowired
  private MyAuthenticationEntryPoint myAuthenticationEntryPoint;

  @Autowired
  private MyAuthenticationProcessingFilter myAuthenticationProcessingFilter;

  @Autowired
  private LogoutSuccessHandler myLogoutSuccessHandler;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

//    可以配置登出方法
//    http.logout().logoutUrl("/my/logout").logoutSuccessHandler(myLogoutSuccessHandler).and()
    http.cors().and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().exceptionHandling().accessDeniedHandler(customAccessDeniedHandler)
        .authenticationEntryPoint(myAuthenticationEntryPoint)
        .and().authorizeRequests()
        .anyRequest().authenticated()
        .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {

          @Override
          public <O extends FilterSecurityInterceptor> O postProcess(O filterSecurityInterceptor) {
            filterSecurityInterceptor.setSecurityMetadataSource(mySecurityMetadataSource);

            filterSecurityInterceptor.setAccessDecisionManager(myAccessDecisionManager);

            return filterSecurityInterceptor;
          }
          // 在 Authentication Mechanism 过滤器收集用户凭证过滤器（AbstractAuthenticationProcessingFilter 的实现类）之前，添加自定义认证过滤器
        }).and().addFilterBefore(myAuthenticationProcessingFilter, UsernamePasswordAuthenticationFilter.class);

  }

  @Override
  public void configure(WebSecurity web) {
    List<String> ignoringList = new ArrayList<>();

    if (securitySwitch) {

      if (!StringUtils.isEmpty(whiteList)) {
        String[] list = whiteList.split(",");

        if (0 < list.length) {
          ignoringList.addAll(Arrays.asList(list));
        }
      }

      List<String> staticUrls = Arrays.asList("/favicon.ico");
      List<String> authUrls = Arrays.asList("/auth/**");
      List<String> swaggerUrls = Arrays.asList("/v2/api-docs", "/csrf", "/**/*swagger*/**", "/error", "/", "/images/**");

      ignoringList.addAll(staticUrls);
      ignoringList.addAll(authUrls);
      ignoringList.addAll(swaggerUrls);
    } else {
      ignoringList.add("/**");
    }

    web.ignoring().antMatchers(ignoringList.toArray(new String[0]));
  }
}

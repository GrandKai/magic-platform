package com.magic.platform.security.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.magic.platform.core.anotation.OpsLog;
import com.magic.platform.core.anotation.OpsLogType;
import com.magic.platform.core.exception.ExceptionCode;
import com.magic.platform.core.model.RequestModel;
import com.magic.platform.core.model.ResponseModel;
import com.magic.platform.core.util.Objects;
import com.magic.platform.dubbo.dto.AuthenticationDto;
import com.magic.platform.dubbo.dto.MenuDto;
import com.magic.platform.dubbo.dto.PlatDto;
import com.magic.platform.dubbo.dto.TokenDto;
import com.magic.platform.dubbo.service.IAuthenticationService;
import com.magic.platform.dubbo.service.IMenuService;
import com.magic.platform.dubbo.service.IPlatService;
import com.magic.platform.security.auth.model.LoginModel;
import com.magic.platform.security.auth.model.ModifyPasswordModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @author: GrandKai
 * @create: 2018-08-29 9:30 PM
 */
@Api(tags = "认证接口类")
@RestController
@RequestMapping("auth")
public class AuthenticationController {

  @Reference
  private IAuthenticationService dubboAuthenticationService;

  @Reference
  private IPlatService platService;

  @Reference
  private IMenuService IMenuService;

  /**
   * 登录生成 jwt token
   */
  @PostMapping("login")
  @ApiOperation(value = "账号密码登录，获取jwt", notes = "@param username 用户名称</br>@param password 用户密码")
  @OpsLog(value = "登录", type = OpsLogType.LOGIN)
  public ResponseModel get(@RequestBody RequestModel<LoginModel> requestModel) {

    LoginModel model = requestModel.getContent();

    Objects.requireNonNull(model, "入参不能为空");
    Objects.requireNonNull(model.getUsername(), "用户名不能为空");
    Objects.requireNonNull(model.getPassword(), "密码不能为空");

    AuthenticationDto authenticationDTO = dubboAuthenticationService.getAuthenticationToken(model.getUsername(), model.getPassword());

    //1. 用户名存在 RequestContextHolder 中，当 SecurityContextHolder 中的 Authentication 不存在时构建认证对象
    RequestContextHolder.getRequestAttributes().setAttribute("username", model.getUsername(), RequestAttributes.SCOPE_REQUEST);

    // 拦截器获取 request 相关的 token 并进行 token 验证
    return new ResponseModel<>("登录成功！", authenticationDTO);
  }

  @PostMapping("modify/password")
  @ApiOperation(value = "修改密码")
  @OpsLog(value = "修改密码", type = OpsLogType.UPDATE)
  public ResponseModel modifyPassword(@RequestBody RequestModel<ModifyPasswordModel> requestModel) {

    Objects.requireNonNull(requestModel, "入参不能为空");

    String accessToken = requestModel.getAccessToken();
    Objects.requireNonNull(accessToken, ExceptionCode.ACCESS_TOKEN_IS_NULL.getKey(), ExceptionCode.ACCESS_TOKEN_IS_NULL.getValue());

    ModifyPasswordModel model = requestModel.getContent();
    Objects.requireNonNull(model, "请求对象不能为空");

    dubboAuthenticationService.modifyPassword(accessToken, model.getOldPassword(), model.getNewPassword());

    return new ResponseModel("修改密码成功！");
  }

  /**
   * 根据 refreshToken 刷新 AccessToken
   * @param requestModel
   * @return
   */
  @PostMapping("refresh/token")
  @ApiOperation(value = "刷新 accessToken", notes = "@param refreshToken")
  @OpsLog(value = "刷新 accessToken", type = OpsLogType.LOGIN)
  public ResponseModel refreshToken(@RequestBody RequestModel<Void> requestModel) {

    Objects.requireNonNull(requestModel, "入参不能为空");

    TokenDto tokenDTO = dubboAuthenticationService.refreshAccessToken(requestModel.getRefreshToken());

    return new ResponseModel<>("刷新 AccessToken 成功！", tokenDTO);
  }

  @PostMapping("menu/list")
  @ApiOperation(value = "查询授权菜单列表")
  @OpsLog(value = "查询授权菜单列表", type = OpsLogType.SELECT)
  public ResponseModel selectGrantedMenuList(@RequestBody RequestModel<String> requestModel) {

    Objects.requireNonNull(requestModel, "入参不能为空");

    String accessToken = requestModel.getAccessToken();
    Objects.requireNonNull(accessToken, ExceptionCode.ACCESS_TOKEN_IS_NULL.getKey(), ExceptionCode.ACCESS_TOKEN_IS_NULL.getValue());

    String platId = requestModel.getContent();
    Objects.requireNonNull(platId, "系统id不能为空");

    List<MenuDto> list = IMenuService.selectAllGrantedMenus(platId, accessToken);
    return new ResponseModel<>("查询授权菜单列表成功！", list);
  }

  @PostMapping("plat/list")
  @ApiOperation(value = "查询授权平台列表")
  @OpsLog(value = "查询授权平台列表", type = OpsLogType.SELECT)
  public ResponseModel selectGrantedPlatList(@RequestBody RequestModel<Void> requestModel) {

    Objects.requireNonNull(requestModel, "入参不能为空");

    String accessToken = requestModel.getAccessToken();
    Objects.requireNonNull(accessToken, ExceptionCode.ACCESS_TOKEN_IS_NULL.getKey(), ExceptionCode.ACCESS_TOKEN_IS_NULL.getValue());

    List<PlatDto> list = platService.selectAllGrantedPlats(requestModel.getAccessToken());

    return new ResponseModel<>("查询授权平台列表成功！", list);
  }
}

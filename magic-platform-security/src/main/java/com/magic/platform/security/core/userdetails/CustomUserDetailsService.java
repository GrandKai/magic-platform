package com.magic.platform.security.core.userdetails;

import com.alibaba.dubbo.config.annotation.Reference;
import com.magic.platform.dubbo.service.IPermissionService;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Author: zhangyn
 * @Description:
 * @Date: Created in 2018-05-22 10:10
 * @Modified By:
 */
@Component
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

  // FIXME 使用 rmi 从远程获取，注入直接依赖其他jar包
  @Reference
  private IPermissionService permissionService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Collection<GrantedAuthority> authorities = loadGrantedAuthorities(username);

    CustomUser customUser = new CustomUser(username, "", authorities);
    return customUser;
  }

  /**
   * 获取用户授予的权限信息
   * @param userName
   * @return
   */
  private Collection<GrantedAuthority> loadGrantedAuthorities(String userName) {
    Collection<GrantedAuthority> authorities = new HashSet<>();

    List<String> permissions = permissionService.selectAllGrantedPermissions(userName);

    for (String permission : permissions) {
      GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission);
      authorities.add(grantedAuthority);
    }

    return authorities;
  }

}

package com.magic.platform.security.core.userdetails;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @Author: zhangyn
 * @Description:
 * @Date: Created in 2018-05-22 11:11
 * @Modified By:
 */

public class CustomUser extends User {

  // TODO: 该用户所属那个平台
  // FIXME: private String platId;

  public CustomUser(String username, String password,
      Collection<? extends GrantedAuthority> authorities) {
    super(username, password, authorities);
  }

  public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
      boolean credentialsNonExpired, boolean accountNonLocked,
      Collection<? extends GrantedAuthority> authorities) {
    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
        authorities);
  }
}

package vbm.common.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vbm.common.model.UserBO;

import java.util.Collection;
import java.util.List;

@Getter
public class UserDetailsAdapter implements UserDetails {

    private final UserBO userBO;

    public UserDetailsAdapter(UserBO userBO) {
        this.userBO = userBO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + userBO.getRole().name()));
    }

    @Override
    public String getPassword() {
        return userBO.getPassword();
    }

    @Override
    public String getUsername() {
        return userBO.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


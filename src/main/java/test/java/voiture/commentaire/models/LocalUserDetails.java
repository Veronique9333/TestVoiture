package test.java.voiture.commentaire.models;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Jean Aimé Ravomanana
 * */
@Slf4j
public class LocalUserDetails implements UserDetails {

    private final Utilisateur localUser;

    public LocalUserDetails(Utilisateur localUser) {
        this.localUser = localUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority (localUser.getRole ().getRoleName ()));

        return authorities;
    }

    @Override
    public String getPassword() {
        return localUser.getPassword();
    }

    @Override
    public String getUsername() {
        return localUser.getUsername();
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
        return false;
    }


}

package com.github.Luythen.Login.Model;

import java.util.Collection;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserModelDto implements UserDetails {

    private final UserModel user;

    public UserModelDto (UserModel user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getEmail () {
        return user.getEmail();
    }

    public UUID getUserID () {
        return user.getUserID();
    }

}

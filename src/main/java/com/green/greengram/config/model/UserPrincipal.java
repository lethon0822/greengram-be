package com.green.greengram.config.model;

import com.green.greengram.config.enumcode.EnumUserRole;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public class UserPrincipal implements UserDetails {
    private final long memberId;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(long memberId, List<EnumUserRole> roles) {
        this.memberId = memberId;
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(EnumUserRole role : roles){
            String roleName = String.format("ROLE_%s", role.name());
            list.add(new SimpleGrantedAuthority(roleName));
        }
        this.authorities = list;

        //this.authorities = roles.stream().map(role -> new SimpleGrantedAuthority(String.format("ROLE_%s", role.name()))).toList();
    }

    @Override
    public String getPassword() { return null; }

    @Override
    public String getUsername() { return null; }
}

package com.fiberhome.pwd.security.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SysUser implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private List<SysRole> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SysRole> roles = this.getRoles();
        List<GrantedAuthority> list = new ArrayList(){{
            if (roles != null) {
                for (SysRole role : roles) {
                    add(new SimpleGrantedAuthority(role.getName()));
                }
            }
        }};
        return list;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public List<SysRole> getRoles() {
        return this.roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return this.username;
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

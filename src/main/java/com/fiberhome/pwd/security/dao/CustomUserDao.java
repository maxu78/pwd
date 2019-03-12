package com.fiberhome.pwd.security.dao;

import com.fiberhome.pwd.security.pojo.SysUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class CustomUserDao {

    public static Set<SysUser> userSet = new HashSet(){{
        SysUser user = new SysUser(){{
            setId(1L);
            setUsername("admin");
            setPassword(new BCryptPasswordEncoder().encode("admin"));
        }};
        add(user);
    }};

    public SysUser getUser(String username) {
        SysUser sysUser = null;
        for (SysUser user : userSet) {
            if (user.getUsername().equals(username)) {
                sysUser = user;
                break;
            }
        }
        return sysUser;
    }
}

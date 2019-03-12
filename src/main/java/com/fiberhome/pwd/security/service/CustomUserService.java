package com.fiberhome.pwd.security.service;

import com.fiberhome.pwd.security.dao.CustomUserDao;
import com.fiberhome.pwd.security.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private CustomUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        SysUser sysUser = userDao.getUser(s);

        if(sysUser == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        System.out.println("s = " + s);
        System.out.println("username = " + sysUser.getUsername());
        System.out.println("password = " + sysUser.getPassword());
//        System.out.println("size = " + sysUser.getRoles().size());
//        System.out.println("roles = " + s);

        return sysUser;
    }
}

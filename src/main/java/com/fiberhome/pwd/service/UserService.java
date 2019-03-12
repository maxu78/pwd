package com.fiberhome.pwd.service;

import com.fiberhome.pwd.dao.UserDao;
import com.fiberhome.pwd.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService{

    @Autowired
    private UserDao userDao;

    public List<User> queryByIdNew(String id) {
        return this.queryById(id);
    }

    public List<User> queryById(String id) {
        if("all".equals(id)){
            return userDao.getAllUser();
        }
        User user = userDao.getUserById(id);
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        return userList;
    }

    public List<User> query(User user) {
        PageHelper.startPage(1, 5);
        List<User> list = userDao.queryUser(user);
        PageInfo pageInfo = new PageInfo(list, 5);
        return list;
    }

    public List<User> query(Map map) {
        PageHelper.startPage(1, 5);
        List<User> list = userDao.queryUserByMap(map);
        PageInfo pageInfo = new PageInfo(list, 5);
        return list;
    }

    public void add(User user) {
        userDao.addUser(user);
    }

    public void delete(String id) {
        userDao.deleteUser(id);
    }

    public void update(User user) {
        userDao.updateUser(user);
    }

    public void batchDelete(String[] list) {
        userDao.batchDelete(list);
    }

    public void batchInsert() throws InterruptedException {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(System.currentTimeMillis() + "");
            user.setName("name_" + i);
            user.setPassword("password_" + i);
            list.add(user);
            Thread.sleep(10);
        }
        userDao.batchInsert(list);
    }
}

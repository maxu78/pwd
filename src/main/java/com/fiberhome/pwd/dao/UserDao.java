package com.fiberhome.pwd.dao;

import com.fiberhome.pwd.annotation.Log;
import com.fiberhome.pwd.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {

    @Log
    public List<User> getAllUser();

    @Log
    public User getUserById(@Param("id") String id);

    @Log
    public List<User> getUserById(@Param("id") String id, @Param("name") String name);

    @Log
    public List<User> queryUser(User user);

    @Log
    public List<User> queryUserByMap(Map map);

    @Log
    public void addUser(User user);

    @Log
    public void updateUser(User user);

    @Log
    public void deleteUser(@Param("id") String id);

    @Log
    public void batchDelete(String[] list);

    @Log
    public void batchInsert(List<User> user);
}

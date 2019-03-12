package com.fiberhome.pwd.controller;

import com.fiberhome.pwd.pojo.User;
import com.fiberhome.pwd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({"/query-id", "/query-id/"})
    public Object queryByIdNew(String id){
        return userService.queryByIdNew(id);
    }

    @GetMapping(value = {"/query/{id}", "/query/{id}/"})
    public Object queryById(@PathVariable("id") String id){
        return userService.queryById(id);
    }

    @GetMapping(value = {"/query", "/query/"})
    public Object query(User user){
        return userService.query(user);
    }

    @GetMapping(value = {"/query1", "/query1/"})
    public Object query(String id, String name){
        Map map = new HashMap();
        map.put("id", id);
        map.put("name", name);
        return userService.query(map);
    }

    @PostMapping({"/addUser", "/addUser/"})
    public Object add(User user){
        userService.add(user);
        return user;
    }

    @PostMapping({"/addUser1", "/addUser1/"})
    public Object add() throws InterruptedException {
        userService.batchInsert();
        return null;
    }

    @PostMapping({"/updateUser", "/updateUser/"})
    public Object update(User user){
        userService.update(user);
        return user;
    }

    @GetMapping({"/delete/{id}", "/delete/{id}/"})
    public Object delete(@PathVariable("id") String id){
        if (id.contains(",")){
            userService.batchDelete(id.split(","));
        } else {
            userService.delete(id);
        }
        return id;
    }

    @PostMapping({"/addJson", "/addJson/"})
    public Object addJson(@RequestBody Map map) {
        System.out.println(map.toString());
        return map;
    }

    @GetMapping({"/hello", "/hello/"})
    public Object hello() {
        return "hello";
    }

}

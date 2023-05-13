package com.evol.controller;

import com.evol.entity.User;
import com.evol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author evol
 * @since 2023-05-13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("list")
    public List<User> list(){
        List<User> users = userService.list();
        return users;
    }

    @GetMapping("getByOpenId")
    public User getByOpenId(String openId){
        User user = userService.findByOpenId(openId);
        return user;
    }

    @GetMapping("queryByBalance")
    public List<User> queryByBalance(Integer minBalance){
        List<User> users = userService.queryByBalance(minBalance);
        return users;
    }

}

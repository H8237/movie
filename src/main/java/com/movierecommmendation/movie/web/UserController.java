package com.movierecommmendation.movie.web;

import com.movierecommmendation.movie.entity.User;
import com.movierecommmendation.movie.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Title: UserRestController
 * Description:
 * 用户控制层
 * Version:1.0.0

 */
@RestController("/user")
@CrossOrigin //允许跨域

public class UserController {
    @Autowired
    private UserService userService;
    User user = new User();
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/register")
    public Map<String, Object> register(@RequestBody User user){
        logger.info("用户信息：[{}]",user.toString());
        Map<String, Object> map = new HashMap<>();
        try {
            userService.register(user);
            map.put("state",true);
            map.put("msg","注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }

    @RequestMapping("/login")
    public Map<String, Object> login(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        try {
            User UserDb = userService.login(user);
            map.put("state",true);
            map.put("msg","登录成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }

    @RequestMapping("/loginsuc")
    @ResponseBody
    public String loginsuc(String name,String password){
        System.out.println(name);
        user.setUsername(name);
        user.setPassword(password);
        System.out.println(userService.findByPrimaryKey(1));
        System.out.println("login controller");

        return "success";
    }
//
//
//    @RequestMapping("/regist")
//    public String regist(){
//        return "regist.html";
//    }
//
//    @RequestMapping("/registsuc")
//    @ResponseBody
//    public String registsuc(String name,String password) {
//        System.out.println(name);
//        user.setUsername(name);
//        user.setPassword(password);
//        System.out.println(userService.insert(user));
//        System.out.println("regist controller");
//
//        return "success";
//    }
}

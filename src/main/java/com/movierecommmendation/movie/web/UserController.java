package com.movierecommmendation.movie.web;

import com.movierecommmendation.movie.entity.Rating;
import com.movierecommmendation.movie.entity.User;
import com.movierecommmendation.movie.service.RatingService;
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
    @Autowired
    private RatingService ratingService;
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
        logger.info("用户信息：[{}]",user.toString());
        Map<String, Object> map = new HashMap<>();
        try {
            User userDb = userService.login(user);
            logger.info("用户信息：[{}]",userDb.toString());
            map.put("state",true);
            map.put("msg","登录成功");
            map.put("user",userDb);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }

    @RequestMapping("/modify")
    public Map<String, Object> modify(@RequestBody User user){
        logger.info("用户信息：[{}]",user.toString());
        Map<String, Object> map = new HashMap<>();
        try {
            userService.modify(user);
            logger.info("用户信息：[{}]",user.toString());
            map.put("state",true);
            map.put("msg","修改成功");
            map.put("user",user);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }

    @RequestMapping("/ratingtest")
    public Map<String, Object> ratingtest(){
        Map<String, Object> map = new HashMap<>();
        try {
//            System.out.println(ratingService.findAll());
            Rating rating = new Rating();
            rating.setUserId(1);
            rating.setMovieId(661);
            rating = ratingService.findByPrimary(rating);
            map.put("rating",rating);
            //ratingService.execPythonTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}

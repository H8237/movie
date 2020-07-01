package com.movierecommmendation.movie.service;

import com.movierecommmendation.movie.entity.User;

public interface UserService extends BaseService<User> {
    /**
     * 根据用户名查找用户
     * @param username
     * @throws Exception
     * @return User
     */
    User findByUsername(String username);
    /**
     * 注册
     * @param user
     * @throws Exception
     */
    void register(User user);
    /**
     * 登录
     * @param user
     * @throws Exception
     * @return User
     */
    User login(User user);
}

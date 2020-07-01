package com.movierecommmendation.movie.service.implement;

import com.movierecommmendation.movie.dao.BaseDao;
import com.movierecommmendation.movie.dao.UserDao;
import com.movierecommmendation.movie.entity.User;
import com.movierecommmendation.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

/**
 *
 * Title: UserServiceImpl
 * Description:
 * 用户操作实现类
 * Version:1.0.0

 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserDao userDao;

    private static final Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    protected UserDao getMapper() { return this.userDao; }

    @Override
    public User findByUsername(String username){
        User user = null;
        try {
            user = getMapper().findByUsername(username);
        } catch (Exception e) {
            logger.error("id:"+username+"查询失败!原因是:",e);
        }
        return user;
    }

    @Override
    public void register(User user){
        User userDB = getMapper().findByUsername(user.getUsername());
        if(userDB == null)
        {
            insert(user);
        }else{
            throw new RuntimeException("用户名已存在");
        }
    }

    @Override
    public User login(User user){
        User userDB = getMapper().findByUsername(user.getUsername());
        if(!ObjectUtils.isEmpty(userDB))
        {
            if(userDB.getPassword().equals(user.getPassword())){
                return userDB;
            }else{
                throw new RuntimeException("密码错误");
            }
        }else{
            throw new RuntimeException("用户不存在");
        }
    }
}

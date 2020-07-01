package com.movierecommmendation.movie.dao;

import com.movierecommmendation.movie.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * Title: UserDao
 * Description:
 * 用户数据接口
 * Version:1.0.0

 */
@Mapper
public interface UserDao extends BaseDao<User> {
    User findByUsername(String username);
}

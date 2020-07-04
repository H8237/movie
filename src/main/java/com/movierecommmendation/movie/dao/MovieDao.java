package com.movierecommmendation.movie.dao;

import com.movierecommmendation.movie.entity.Movie;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieDao extends BaseDao<Movie> {
}

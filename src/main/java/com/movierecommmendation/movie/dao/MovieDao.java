package com.movierecommmendation.movie.dao;

import com.movierecommmendation.movie.entity.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieDao extends BaseDao<Movie> {
    List<Movie> findByTitle(String title);
    List<Movie> findByAvgRating();
    List<Movie> findByRatingMore();
}

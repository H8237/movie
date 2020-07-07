package com.movierecommmendation.movie.dao;

import com.movierecommmendation.movie.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovieDao extends BaseDao<Movie> {
    List<Movie> findByTitle(String title);
    List<Movie> findByAvgRating();
    List<Movie> findByRatingMore();
    boolean insertUserLike(@Param("MovieID") Integer MovieID, @Param("UserID") Integer UserID);
    List<Movie> findUserLikeByUser(@Param("UserID") Integer UserID);
    List<Movie> findTopMoviesByType(@Param("type") String type);
    List<Movie> findMovieByMovie(@Param("BaseMovieID") Integer BaseMovieID);
    List<Movie> findMovieByOnUser(@Param("UserID") Integer UserID);
    List<Movie> findMovieByOffUser(@Param("UserID") Integer UserID);
    List<Movie> findByType(@Param("type") String type);
}

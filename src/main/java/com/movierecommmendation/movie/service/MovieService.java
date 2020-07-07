package com.movierecommmendation.movie.service;

import com.movierecommmendation.movie.entity.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieService extends BaseService<Movie> {
    List<Movie> findByTitle(String title, Integer curPage);
    List<Movie> findByAvgRating();
    List<Movie> findByRatingMore(Integer curPage);
    List<Movie> findUserLikeByUser(Integer UserID);
    boolean insertUserLike(Integer MovieID, Integer UserID);
    List<Movie> findTopMoviesByType(String type, Integer curPage);
    List<Movie> findMovieByMovie(Integer BaseMovieI, Integer curPage);
}

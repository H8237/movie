package com.movierecommmendation.movie.service;

import com.movierecommmendation.movie.entity.Movie;

import java.util.List;

public interface MovieService extends BaseService<Movie> {
    List<Movie> findByTitle(String title, Integer curPage);
    List<Movie> findByAvgRating();
    List<Movie> findByRatingMore(Integer curPage);
}

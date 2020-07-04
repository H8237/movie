package com.movierecommmendation.movie.service;

import com.movierecommmendation.movie.entity.Rating;

public interface RatingService extends BaseService<Rating>{
    Rating findByPrimary(Rating rating);

    void execPythonTest();
}

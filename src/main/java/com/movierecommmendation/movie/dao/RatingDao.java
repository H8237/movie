package com.movierecommmendation.movie.dao;

import com.movierecommmendation.movie.entity.Rating;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RatingDao extends BaseDao<Rating>{
    Rating findByPrimary(Rating rating);
}

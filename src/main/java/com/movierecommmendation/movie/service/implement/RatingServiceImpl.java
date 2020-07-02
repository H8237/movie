package com.movierecommmendation.movie.service.implement;

import com.movierecommmendation.movie.dao.RatingDao;
import com.movierecommmendation.movie.dao.UserDao;
import com.movierecommmendation.movie.entity.Rating;
import com.movierecommmendation.movie.service.RatingService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl extends BaseServiceImpl<Rating> implements RatingService {
    @Autowired
    private RatingDao ratingDao;

    private static final Logger logger= LoggerFactory.getLogger(RatingServiceImpl.class);

    protected RatingDao getMapper() { return this.ratingDao; }

    @Override
    public Rating findByPrimary(Rating rating){
        Rating ratingDb = null;
        try {
            ratingDb = getMapper().findByPrimary(rating);
        } catch (Exception e) {
            logger.error("查询"+rating+"失败!原因是:",e);
        }
        return ratingDb;
    }
}

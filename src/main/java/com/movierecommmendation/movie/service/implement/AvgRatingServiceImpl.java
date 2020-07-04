package com.movierecommmendation.movie.service.implement;

import com.movierecommmendation.movie.dao.AvgRatingDao;
import com.movierecommmendation.movie.entity.AvgRating;
import com.movierecommmendation.movie.service.AvgRatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvgRatingServiceImpl extends BaseServiceImpl<AvgRating> implements AvgRatingService {
    @Autowired
    private AvgRatingDao avgRatingDao;

    private static final Logger logger= LoggerFactory.getLogger(AvgRatingServiceImpl.class);

    protected AvgRatingDao getMapper() { return this.avgRatingDao; }
}

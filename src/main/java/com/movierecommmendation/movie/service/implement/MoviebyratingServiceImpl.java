package com.movierecommmendation.movie.service.implement;

import com.movierecommmendation.movie.dao.MoviebyratingDao;
import com.movierecommmendation.movie.entity.Moviebyrating;
import com.movierecommmendation.movie.service.MoviebyratingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviebyratingServiceImpl extends BaseServiceImpl<Moviebyrating> implements MoviebyratingService {
    @Autowired
    private MoviebyratingDao moviebyratingDao;

    private static final Logger logger= LoggerFactory.getLogger(MoviebyratingServiceImpl.class);

    protected MoviebyratingDao getMapper() { return this.moviebyratingDao; }
}

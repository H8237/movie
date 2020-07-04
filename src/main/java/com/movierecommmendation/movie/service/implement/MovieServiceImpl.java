package com.movierecommmendation.movie.service.implement;

import com.movierecommmendation.movie.dao.MovieDao;
import com.movierecommmendation.movie.dao.RatingDao;
import com.movierecommmendation.movie.entity.Movie;
import com.movierecommmendation.movie.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService {
    @Autowired
    private MovieDao movieDao;

    private static final Logger logger= LoggerFactory.getLogger(MovieServiceImpl.class);

    protected MovieDao getMapper() { return this.movieDao; }

}

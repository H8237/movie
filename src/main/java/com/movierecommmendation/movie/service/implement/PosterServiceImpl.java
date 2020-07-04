package com.movierecommmendation.movie.service.implement;

import com.movierecommmendation.movie.dao.MovieDao;
import com.movierecommmendation.movie.dao.PosterDao;
import com.movierecommmendation.movie.entity.Poster;
import com.movierecommmendation.movie.service.PosterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PosterServiceImpl extends BaseServiceImpl<Poster> implements PosterService {
    @Autowired
    private PosterDao posterDao;

    private static final Logger logger= LoggerFactory.getLogger(PosterServiceImpl.class);

    protected PosterDao getMapper() { return this.posterDao; }
}

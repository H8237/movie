package com.movierecommmendation.movie.service.implement;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.movierecommmendation.movie.dao.MovieDao;
import com.movierecommmendation.movie.dao.RatingDao;
import com.movierecommmendation.movie.entity.Movie;
import com.movierecommmendation.movie.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService {
    @Autowired
    private MovieDao movieDao;

    private static final Logger logger= LoggerFactory.getLogger(MovieServiceImpl.class);

    protected MovieDao getMapper() { return this.movieDao; }

    @Override
    public List<Movie> findByTitle(String title, Integer curPage) {
        List<Movie> list = null;
        try {
            list = getMapper().findByTitle(title);
        } catch (Exception e) {
            logger.error("查询 title 失败!原因是:", e);
        }
        return list;
    }
    @Override
    public List<Movie> findByAvgRating(){
        List<Movie> list = null;
        try {
            list = getMapper().findByAvgRating();
        } catch (Exception e) {
            logger.error("查询评分排序失败!原因是:", e);
        }
        return list;
    }

    @Override
    public List<Movie> findByRatingMore(Integer curPage){
        List<Movie> list = null;
        try {
            list = getMapper().findByRatingMore();
        } catch (Exception e) {
            logger.error("查询热门电影失败!原因是:", e);
        }
        return list;
    }
}

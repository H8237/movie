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
            logger.error("标题搜索失败!原因是:", e);
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

    @Override
    public boolean insertUserLike(Integer MovieID, Integer UserID){
        boolean falg=false;
        try {
            getMapper().insertUserLike(MovieID,UserID);
            falg=true;
        } catch (Exception e) {
            throw new RuntimeException("已经喜欢过");
        }
        return falg;
    }

    @Override
    public List<Movie> findUserLikeByUser(Integer UserID){
        List<Movie> list = null;
        try{
            list = getMapper().findUserLikeByUser(UserID);
        } catch (Exception e){
            logger.error("查询用户喜欢的电影失败!原因是:", e);
        }
        return list;
    }

    @Override
    public List<Movie> findTopMoviesByType(String type, Integer curPage){
        List<Movie> list = null;
        try{
            list = getMapper().findTopMoviesByType(type);
        } catch (Exception e){
            logger.error("查询分标签最热门失败!原因是:", e);
        }
        return list;
    }
    @Override
    public List<Movie> findMovieByMovie(Integer BaseMovieID, Integer curPage){
        List<Movie> list = null;
        try{
            list = getMapper().findMovieByMovie(BaseMovieID);
        } catch (Exception e){
            logger.error("查询相似电影失败!原因是:", e);
        }
        return list;
    }
}

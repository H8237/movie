package com.movierecommmendation.movie.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.movierecommmendation.movie.entity.Movie;
import com.movierecommmendation.movie.service.AvgRatingService;
import com.movierecommmendation.movie.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("/movie")
@CrossOrigin
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private AvgRatingService avgRatingService;
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @RequestMapping("/search")
    public Map<String, Object> search(String movieName, Integer curPage) {
        Map<String, Object> map = new HashMap<>();
        try {
            Page<?> page = PageHelper.startPage(curPage, 10);
            List<Movie> movies = movieService.findByTitle(movieName, curPage);
            Long total = page.getTotal();
            map.put("state",true);
            map.put("msg","搜索成功");
            map.put("data",movies);
            map.put("total",total);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }

    @RequestMapping("/movieDetails")
    public Map<String, Object> movieDetails(Integer movieId) {
        Map<String, Object> map = new HashMap<>();
        try {
            Movie movie = movieService.findByPrimaryKey(movieId);
            map.put("state",true);
            map.put("msg","获取电影详情成功");
            map.put("movies",movie);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }

    @RequestMapping("/reputation")
    public Map<String, Object> reputation(){
        Map<String, Object> map = new HashMap<>();
        try {
            List<Movie> movies = movieService.findByAvgRating();
            map.put("state",true);
            map.put("msg","获取电影口碑前十榜成功");
            map.put("movies",movies);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }

    @GetMapping("/popularMovie")
    public Map<String, Object> popularMovie(Integer curPage){
        Map<String, Object> map = new HashMap<>();
        try {
            Page<?> page = PageHelper.startPage(curPage, 12);
            List<Movie> movies = movieService.findByRatingMore(curPage);
            Long total = page.getTotal();
            map.put("state",true);
            map.put("msg","获取热门电影榜成功");
            map.put("total",total);
            map.put("movies",movies);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }

    @GetMapping("/addUserLike")
    public Map<String,Object> addUserLike(Integer movieId, Integer userId){
        Map<String, Object> map = new HashMap<>();
        try {
            movieService.insertUserLike(movieId, userId);
            map.put("state",true);
            map.put("msg","标记喜欢成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }

    @GetMapping("/moviesUserLike")
    public Map<String, Object> moviesUserLike(Integer UserId){
        Map<String, Object> map = new HashMap<>();
        try {
            List<Movie> movies = movieService.findUserLikeByUser(UserId);
            map.put("state",true);
            map.put("msg","查询喜欢成功");
            map.put("movies",movies);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }

    @GetMapping("/topMoviesByType")
    public Map<String, Object> topMoviesByType(String type, Integer curPage){
        Map<String, Object> map = new HashMap<>();
        try {
            Page<?> page = PageHelper.startPage(curPage, 6);
            List<Movie> movies = movieService.findTopMoviesByType(type,curPage);
            Long total = page.getTotal();
            map.put("state",true);
            map.put("msg","分标签查询热门电影成功");
            map.put("movies",movies);
            map.put("total",total);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }

    @GetMapping("/moviesByMovie")
    public Map<String, Object> MoviesByMovie(Integer movieid, Integer curPage){
        Map<String, Object> map = new HashMap<>();
        try {
            Page<?> page = PageHelper.startPage(curPage, 5);
            List<Movie> movies = movieService.findMovieByMovie(movieid,curPage);
            Long total = page.getTotal();
            map.put("state",true);
            map.put("msg","查询相似电影成功");
            map.put("movies",movies);
            map.put("total",total);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }

    @GetMapping("/moviesByOnUser")
    public Map<String, Object> MoviesByOnUser(Integer userid, Integer curPage){
        Map<String, Object> map = new HashMap<>();
        try {
            Page<?> page = PageHelper.startPage(curPage, 12);
            List<Movie> movies = movieService.findMovieByOnUser(userid,curPage);
            Long total = page.getTotal();
            map.put("state",true);
            map.put("msg","查询在线猜你喜欢电影成功");
            map.put("movies",movies);
            map.put("total",total);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }

    @GetMapping("/moviesByOffUser")
    public Map<String, Object> MoviesByOffUser(Integer userid, Integer curPage){
        Map<String, Object> map = new HashMap<>();
        try {
            Page<?> page = PageHelper.startPage(curPage, 12);
            List<Movie> movies = movieService.findMovieByOffUser(userid,curPage);
            Long total = page.getTotal();
            map.put("state",true);
            map.put("msg","查询离线猜你喜欢电影成功");
            map.put("movies",movies);
            map.put("total",total);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }
    @GetMapping("/genres")
    public Map<String, Object> MoviesByType(String genres, Integer curPage){
        Map<String, Object> map = new HashMap<>();
        logger.info(genres);
        try {
            Page<?> page = PageHelper.startPage(curPage, 24);
            List<Movie> movies = movieService.findByType(genres,curPage);
            Long total = page.getTotal();
            map.put("state",true);
            map.put("msg","分类查询电影成功");
            map.put("movies",movies);
            map.put("total",total);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }
}

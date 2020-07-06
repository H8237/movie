package com.movierecommmendation.movie.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.movierecommmendation.movie.entity.AvgRating;
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

import javax.xml.ws.Service;
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
            Page<?> page = PageHelper.startPage(curPage, 10);
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
}

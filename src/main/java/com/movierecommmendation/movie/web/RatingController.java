package com.movierecommmendation.movie.web;

import com.movierecommmendation.movie.entity.Movie;
import com.movierecommmendation.movie.entity.Rating;
import com.movierecommmendation.movie.service.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("/rating")
@CrossOrigin //允许跨域
public class RatingController {
    @Autowired
    private RatingService ratingService;

    private static final Logger logger = LoggerFactory.getLogger(RatingController.class);

    @RequestMapping("/AddUserRating")
    public Map<String, Object> search(@RequestBody Rating rating) {
        Map<String, Object> map = new HashMap<>();
        try {
            ratingService.insert(rating);
            map.put("state",true);
            map.put("msg","评分成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }
}

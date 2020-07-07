package com.movierecommmendation.movie.web;

import com.movierecommmendation.movie.entity.Movie;
import com.movierecommmendation.movie.entity.Rating;
import com.movierecommmendation.movie.service.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
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

    @RequestMapping("/isUserRating")
    public Map<String, Object> isUserRating(@RequestBody Rating rating) {
        logger.info("评分信息：[{}]",rating.toString());
        Map<String, Object> map = new HashMap<>();
        Rating ratingDb = ratingService.findByPrimary(rating);
        if(!ObjectUtils.isEmpty(ratingDb)){
            map.put("state",true);
            map.put("msg","获取评分成功");
            map.put("rating",ratingDb);
        } else {
            map.put("state",false);
            map.put("msg","提示：无评分数据");
        }
        return map;
    }

    @RequestMapping("/AddUserRating")
    public Map<String, Object> addUserRating(@RequestBody Rating rating) {
        Map<String, Object> map = new HashMap<>();
        Rating ratingDb = ratingService.findByPrimary(rating);
        if(ObjectUtils.isEmpty(ratingDb)){
            ratingService.insert(rating);
            map.put("state",true);
            map.put("msg","评分成功");
        } else {
            map.put("state",false);
            map.put("msg","提示：已经评分过了");
        }
        return map;
    }
}

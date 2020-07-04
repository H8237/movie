package com.movierecommmendation.movie.web;

import com.movierecommmendation.movie.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Service;
import java.util.HashMap;
import java.util.Map;

@RestController("/movie")
@CrossOrigin
public class MovieController {
    @Autowired
    private MovieService movieService;
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @RequestMapping("/search")
    public Map<String, Object> search() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }
}

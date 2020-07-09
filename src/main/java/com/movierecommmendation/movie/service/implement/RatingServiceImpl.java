package com.movierecommmendation.movie.service.implement;

import com.movierecommmendation.movie.dao.RatingDao;
import com.movierecommmendation.movie.dao.UserDao;
import com.movierecommmendation.movie.entity.Rating;
import com.movierecommmendation.movie.service.RatingService;

import com.movierecommmendation.movie.util.OffLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class RatingServiceImpl extends BaseServiceImpl<Rating> implements RatingService {
    @Autowired
    private RatingDao ratingDao;

    private static final Logger logger= LoggerFactory.getLogger(RatingServiceImpl.class);

    protected RatingDao getMapper() { return this.ratingDao; }

    @Override
    public Rating findByPrimary(Rating rating){
        Rating ratingDb = null;
        try {
            ratingDb = getMapper().findByPrimary(rating);
        } catch (Exception e) {
            logger.error("查询"+rating+"失败!原因是:",e);
        }
        return ratingDb;
    }

    @Override
    public void execPythonTest(){
        findAll();
        OffLine offLine = new OffLine();
        //offLine.DataPre("s");

        String[] arguments = new String[] {"python","D:\\springbootproject\\test.py", "huzhiwei", "25"};
        try {
            // 执行python代码
            Process process = Runtime.getRuntime().exec(arguments);
            // 将python打印在控制台的结果作为java的输入
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            // 打印python执行结果
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            // 返回执行是否成功，0 代表成功，1 代表失败
            int re = process.waitFor();
            // 输出执行结果
            System.out.println(re);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

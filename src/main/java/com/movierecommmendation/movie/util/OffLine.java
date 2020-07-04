package com.movierecommmendation.movie.util;
import com.movierecommmendation.movie.entity.*;
import com.movierecommmendation.movie.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffLine {
    @Autowired
    private RatingDao ratingDao;

    private static final Logger logger= LoggerFactory.getLogger(OffLine.class);

    protected RatingDao getMapper() { return this.ratingDao; }

    public void DataPre(String s){
        Rating r=new Rating();
        r.setMovieId(919);
        r.setUserId(1);

        Rating rd=getMapper().findByPrimary(r);
        //for(Rating r :rd){
        System.out.println(r);
        // }
    }
//    public static void main(String[] args){
//        new OffLine().DataPre();
//    }
}

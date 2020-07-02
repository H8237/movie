package com.movierecommmendation.movie.entity;

public class Rating {
    private Integer UserId;
    private Integer MovieId;
    private Integer Rating;
    private String Timestamp;

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public Integer getMovieId() {
        return MovieId;
    }

    public void setMovieId(Integer movieId) {
        MovieId = movieId;
    }

    public Integer getRating() {
        return Rating;
    }

    public void setRating(Integer rating) {
        Rating = rating;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.Timestamp = timestamp;
    }

    public String toString() {
        return ("["+UserId+","+MovieId+","+Rating+","+Timestamp+"]");
    }
}

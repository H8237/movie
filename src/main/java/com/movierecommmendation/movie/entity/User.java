package com.movierecommmendation.movie.entity;

/**
 * Title: User
 * Description:用户pojo类
 * Version:1.0.0

 */
public class User {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 职业
     */
    private Integer occupation;
    /**
     * 年龄
     */
    private Integer age;

    public Integer getId() { return id; }
    public void setId(Integer id){ this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username){ this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password;}
    public Integer getSex() { return sex; }
    public void setSex(Integer sex) { this.sex = sex; }
    public Integer getOccupation() { return occupation; }
    public void setOccupation() { this.occupation = occupation; }
    public Integer getAge() { return age; }
    public void setAge() {this.age = age; }
    public String toString() {
        return ("["+id+","+username+","+password+","+sex+","+occupation+","+age+"]");
    }

}

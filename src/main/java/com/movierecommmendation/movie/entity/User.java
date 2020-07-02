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
    private String gender;
    /**
     * 职业
     */
    private String occupation;
    /**
     * 年龄
     */
    private Integer age;
    private String zipcode;

    public Integer getId() { return id; }
    public void setId(Integer id){ this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username){ this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password;}
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) {this.age = age; }
    public String getZipcode(){ return zipcode; }
    public void setZipcode(String zipcode){ this.zipcode = zipcode; }
    public String toString() {
        return ("["+id+","+username+","+password+","+gender+","+occupation+","+age+","+zipcode+"]");
    }

}

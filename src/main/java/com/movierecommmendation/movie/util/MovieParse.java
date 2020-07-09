package com.movierecommmendation.movie.util;

public class MovieParse {
    String[] occupation = {"“其他”或未指定", "学术/教育者", "艺术家", "文书/管理员", "大专/研究生", "客户服务",
            "医生/医疗保健", "行政/管理人员", "农民", "家庭主妇", "K-12学生", "律师", "程序员", "退休", "销售/营销", "科学家",
            "个体经营", "技术员/工程师", "商人/工匠", "待业", "作家"};
    public String UserPrase(String ocid){
        Integer occupationId = null;
        if(ocid!=null){
            occupationId = Integer.valueOf(ocid);
        }
        String UserOccupation = occupation[occupationId];
        return UserOccupation;
    }
    public Integer OccupationPrase(){
        return 1;
    }
}

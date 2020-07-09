package com.movierecommmendation.movie.util;
import com.movierecommmendation.movie.entity.*;
import com.movierecommmendation.movie.dao.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class OffLine {
    @Autowired
    private RatingDao ratingDao;

    private static final Logger logger= LoggerFactory.getLogger(OffLine.class);

    protected RatingDao getMapper() { return this.ratingDao; }

    public void DataPre(int [][]DInput) throws IOException {
        System.out.println(DInput.length);
        System.out.println(DInput[0].length);

        File writename = new File("E:\\movie\\src\\main\\resources\\ratingT.txt");
        if(writename.exists()){
            writename.delete();
        }
        writename.createNewFile(); // 创建新文件
        FileWriter writer = new FileWriter(writename , true);//参数：一个第一步的参数file和一个true可读写属性值
        BufferedWriter out = new BufferedWriter(writer);
        for(int i=0;i<DInput.length;i++) {
            for (int j = 0; j < DInput[0].length; j++) {
                out.write(DInput[i][j]+" ");
            }
            out.write("\r\n");
        }
        out.flush(); // 把缓存区内容压入文件
        out.close(); // 最后记得关闭文件
        /*
        try {
            // 执行python代码
            Process process = Runtime.getRuntime().exec("python "+
                    "E:\\movie\\src\\main\\resources\\python\\OffLine.py "+
                            dinput);
            // 将python打印在控制台的结果作为java的输入
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            // 打印python执行结果
            String line = null;
            System.out.println(in.readLine() == null);
            while ((line = in.readLine()) != null) {
                System.out.println("a"+line);
            }
            in.close();
            // 返回执行是否成功，0 代表成功，1 代表失败
            int re = process.waitFor();
            // 输出执行结果
            System.out.println("b"+re);
        } catch (Exception e) {
            e.printStackTrace();
        }

         */

    }

}

package com.derellea;

import com.derellea.domain.Vedio;
import com.derellea.mapper.VedioMapper;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NormalTest {


    @Test
    public void vedioTest(){
        File files=new File("D:\\mavenProject\\LianXiJava\\src\\main\\webapp\\videos\\javaee");

        System.out.println(digui(files, 4));


    }
    public List<Vedio> digui(File files , int vcId){
        List<Vedio> list=new LinkedList<Vedio>();

        for (File file : files.listFiles()) {
                Vedio vedio=new Vedio();
                int count=0;
                String str=file.getName();
//                for (String s : file.getName().split(" ")) {
//                    if(count>=4) {
//                        str+=s;
//                    }
//                    count++;
//                }

                vedio.setVcId(vcId);
                vedio.setvName(str.replace(".mp4",""));
                vedio.setvAddress(file.getPath().replace("D:\\mavenProject\\LianXiJava\\src\\main\\webapp\\",""));
                list.add(vedio);
        }
        return list;
    }
}

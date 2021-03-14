package com.derellea;

import com.derellea.domain.User;
import com.derellea.domain.Vedio;
import com.derellea.mapper.UserMapper;
import com.derellea.service.CategoryService;
import com.derellea.service.MessageService;
import com.derellea.service.UserService;
import com.derellea.service.VedioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyBatisTest {
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    MessageService messageService;
    @Autowired
    VedioService vedioService;
    @Test
    public void userTest(){
        System.out.println(userService.findAll());
    }

    @Test
    public void userTest2(){
        User user=new User();
        user.setUsername("admin");
        user.setPassword("admin123");
        System.out.println(userService.findByUsernameAndPassword(user));
    }

    @Test
    public void categoryTest(){
        System.out.println(categoryService.findAll());
    }

    @Test
    public void messageTest(){
        System.out.println(messageService.countNoreadByAcceptId(1));
    }

    @Test
    public void vedioTest(){

        File files=new File("D:\\mavenProject\\LianXiJava\\src\\main\\webapp\\videos\\javascript");

        for (Vedio vedio : digui(files, 2)) {
            vedioService.insert(vedio);
        }


    }

    @Test
    public void messageTest2(){
        System.out.println(messageService.findAll());
    }

    @Test
    public void vedioTest2(){
        System.out.println(vedioService.findByvcId(4));
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

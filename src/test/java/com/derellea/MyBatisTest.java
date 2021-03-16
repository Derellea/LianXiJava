package com.derellea;

import com.derellea.domain.Message;
import com.derellea.domain.User;
import com.derellea.domain.Vedio;
import com.derellea.mapper.MessageMapper;
import com.derellea.mapper.UserMapper;
import com.derellea.service.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    @Autowired
    UserMapper userMapper;
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    questionService questionService;

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
    public void messageTest3(){
        System.out.println(messageService.findBySendIdAndAcceptId(1,2));
    }


    @Test
    public void messageTest4(){

        System.out.println(messageMapper.findBySendIdAndAcceptId(1, 2));
    }



    @Test
    public void messageTest5(){
        Message message=new Message();
        message.setIfread(true);
        message.setmDesc("试试");
        User send = new User();
        send.setId(11);
        User accept = new User();
        accept.setId(12);
        message.setAccept(accept);
        message.setSend(send);
        message.setmTime(new Date().getTime());

        //messageMapper.insertBySendIdAndAcceptId(message);


    }

    @Test
    public void vedioTest2(){
        System.out.println(vedioService.findByvcId(4));
    }


    @Test
    public void jacksonTest() throws IOException {
        String data="         {   \"sendId\" : \" 1\" ,\n" +
                "            \"acceptId\": \" 2\" ,\n" +
                "            \"ifRead\": \" 1\" ,\n" +
                "            \"mDesc\":\" 2\" ,\n" +
                "            \"mTime\": \" 1\"  }";
        Map<String,String> result = new ObjectMapper().readValue(data, new TypeReference<Map<String,String>>() { });
        System.out.println(result.get("sendId"));
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


    @Test
    public void questionTest(){
        long qDate = new Date("2021/2/12 15:12").getTime();
        Date date=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        date.setTime(qDate);
        System.out.println(dateFormat.format(date));

    }

    //用作插入
    @Test
    public void questionTest2(){
        long qDate = new Date("2021/2/12 15:12").getTime();
        String qTitle="为什么Java中Scanner无法使用，一直报错？";
        String qDesc="";
        questionService.qInsert(2,qDate,qTitle,qDesc);

    }


}

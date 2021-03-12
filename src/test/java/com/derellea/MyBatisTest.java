package com.derellea;

import com.derellea.domain.User;
import com.derellea.mapper.UserMapper;
import com.derellea.service.CategoryService;
import com.derellea.service.MessageService;
import com.derellea.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyBatisTest {
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    MessageService messageService;
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

}

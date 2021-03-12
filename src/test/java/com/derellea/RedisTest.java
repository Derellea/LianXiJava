package com.derellea;

import com.derellea.domain.Category;
import com.derellea.service.CategoryService;
import com.derellea.service.VedioCategoryService;
import com.derellea.utils.cache.RedisCacheConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-mvc.xml"})
public class RedisTest {
    @Autowired
    private VedioCategoryService vedioCategoryService;
    @Autowired
    private CategoryService categoryService;


    @Test
    public void test(){
        System.out.println(categoryService.findAll());
    }

    @Test
    public void test2(){
        System.out.println(vedioCategoryService.findAll());
    }
}

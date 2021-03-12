package com.derellea.service.impl;

import com.derellea.domain.Category;
import com.derellea.mapper.CategoryMapper;
import com.derellea.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private RedisTemplate redisTemplate;


    @Cacheable(value="cache",key="'category'")
    public List<Category> findAll() {
        return categoryMapper.selectAll();
    }
}

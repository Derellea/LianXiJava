package com.derellea.service.impl;

import com.derellea.domain.VedioCategory;
import com.derellea.mapper.VedioCategoryMapper;
import com.derellea.service.VedioCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VedioCategoryServiceImpl implements VedioCategoryService {
    @Autowired
    private VedioCategoryMapper vedioCategoryMapper;

    @Transactional
    @Cacheable(value = "cache",key = "'vedioCategory'")
    public List<VedioCategory> findAll() {
        return vedioCategoryMapper.selectAll();
    }
}

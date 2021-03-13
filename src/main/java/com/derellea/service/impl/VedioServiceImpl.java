package com.derellea.service.impl;

import com.derellea.domain.Vedio;
import com.derellea.mapper.VedioMapper;
import com.derellea.service.VedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VedioServiceImpl implements VedioService {

    @Autowired
    private VedioMapper vedioMapper;

    @Override
    public void insert(Vedio vedio) {
        vedioMapper.insert(vedio);
    }

    @Override
    public List<Vedio> findAll() {
        return vedioMapper.selectAll();
    }

    @Override
    public List<Vedio> findByvcId(int vcId) {
        return vedioMapper.findByvcId(vcId);
    }
}

package com.derellea.service.impl;

import com.derellea.mapper.questionMapper;
import com.derellea.service.questionService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class questionServiceImple implements questionService {
    @Autowired
    private questionMapper questionMapper;
    @Override
    public void qInsert(int askId, long qDate, String qTitle, String qDesc) {
        questionMapper.qInsert(askId,qDate,qTitle,qDesc);
    }
}

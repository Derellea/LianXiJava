package com.derellea.service.impl;

import com.derellea.mapper.MessageMapper;
import com.derellea.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Override
    public int countNoreadByAcceptId(int acceptId) {
        return messageMapper.countNoreadByAcceptId(acceptId);
    }
}

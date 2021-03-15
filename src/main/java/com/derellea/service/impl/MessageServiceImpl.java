package com.derellea.service.impl;

import com.derellea.domain.Message;
import com.derellea.mapper.MessageMapper;
import com.derellea.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Override
    public int countNoreadByAcceptId(int acceptId) {
        return messageMapper.countNoreadByAcceptId(acceptId);
    }

    @Override
    public List<Message> findAll() {
        return messageMapper.selectAll();
    }

    @Override
    public List<Message> findBySendIdAndAcceptId(int sendId, int acceptId) {
        return messageMapper.findBySendIdAndAcceptId(sendId,acceptId);
    }

    @Override
    public void insert(int sendId, int acceptId, boolean ifRead, String mDesc, long mTime) {
        messageMapper.insert(sendId,acceptId,ifRead,mDesc,mTime);
    }


}

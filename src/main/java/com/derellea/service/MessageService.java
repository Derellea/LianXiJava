package com.derellea.service;

import com.derellea.domain.Message;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface MessageService {
    public int countNoreadByAcceptId(int acceptId);

    public List<Message> findAll();

    public List<Message> findBySendIdAndAcceptId(int sendId,int acceptId);

    public void insert(int sendId,int acceptId,boolean ifRead, String mDesc,long mTime);

}

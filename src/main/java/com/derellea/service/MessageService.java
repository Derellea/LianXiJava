package com.derellea.service;

import org.apache.ibatis.annotations.Select;


public interface MessageService {
    public int countNoreadByAcceptId(int acceptId);
}

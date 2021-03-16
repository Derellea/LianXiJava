package com.derellea.service;

import org.apache.ibatis.annotations.Param;

public interface questionService {

    public void qInsert(int askId, long qDate, String qTitle,String qDesc);
}

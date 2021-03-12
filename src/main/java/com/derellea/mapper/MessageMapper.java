package com.derellea.mapper;

import com.derellea.domain.Message;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import javax.persistence.Table;

@Repository
@Table(name = "Message")
public interface MessageMapper extends Mapper<Message> {


        @Select("select count(sendId) from message where acceptId = #{acceptId} and ifread = false")
        public int countNoreadByAcceptId(int acceptId);


}

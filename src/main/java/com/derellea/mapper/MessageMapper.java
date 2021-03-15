package com.derellea.mapper;

import com.derellea.domain.Message;

import com.derellea.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import javax.persistence.Table;
import java.util.List;

@Repository
public interface MessageMapper {


        @Select("select count(sendId) from message where acceptId = #{acceptId} and ifread = false")
        public int countNoreadByAcceptId(int acceptId);


        //根据sendId和acceptId直接找到对应的user
        @Select("SELECT * FROM message WHERE (sendId = #{sendId} AND acceptId = #{acceptId}) OR ( sendId = #{acceptId} AND acceptId = #{sendId}) order by mTime")
        @Results({
                @Result(id = true, property = "mId", column = "mId"),
                @Result(property = "ifread", column = "ifRead"),
                @Result(property = "mDesc", column = "mDesc"),
                @Result(property = "mTime", column = "mTime"),
                @Result(
                        property = "send",
                        column = "sendId",
                        javaType = User.class,
                        one=@One(select = "com.derellea.mapper.UserMapper.findById")
                ),
                @Result(
                        property = "accept",
                        column = "acceptId",
                        javaType = User.class,
                        one=@One(select = "com.derellea.mapper.UserMapper.findById")
                )

        }
        )
        public List<Message> findBySendIdAndAcceptId(@Param("sendId") int sendId, @Param("acceptId") int acceptId);


        @Select("select * from message")
        public List<Message> selectAll();


        @Insert(
                "insert into message(sendId,acceptId,ifRead,mDesc,mTime) " +
                        "values(#{sendId},#{acceptId},#{ifRead},#{mDesc},#{mTime})"
        )
        public void insert(@Param("sendId")int sendId,@Param("acceptId")int acceptId,@Param("ifRead")boolean ifRead,@Param("mDesc")String mDesc,@Param("mTime")long mTime);


}

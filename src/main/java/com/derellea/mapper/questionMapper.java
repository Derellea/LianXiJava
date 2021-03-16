package com.derellea.mapper;

import com.derellea.domain.question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@Repository
public interface questionMapper{

    @Insert(
            "insert into question(askId,qDate,qTitle,qDesc) values (#{askId},#{qDate},#{qTitle},#{qDesc})"
    )
    public void qInsert(@Param("askId") int askId, @Param("qDate") long qDate, @Param("qTitle") String qTitle, @Param("qDesc") String qDesc);
}

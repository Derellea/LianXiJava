package com.derellea.mapper;

import com.derellea.domain.Vedio;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name="vedio")
public interface VedioMapper extends Mapper<Vedio> {

    @Select("select * from vedio where vcId = #{vcId}")
    public List<Vedio> findByvcId(int vcId);
}

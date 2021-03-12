package com.derellea.mapper;

import com.derellea.domain.VedioCategory;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import javax.persistence.Table;

@Repository
@Table(name="vedio_category")
public interface VedioCategoryMapper extends Mapper<VedioCategory> {

}

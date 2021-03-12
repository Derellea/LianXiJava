package com.derellea.mapper;

import com.derellea.domain.Category;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import javax.persistence.Table;

@Repository
@Table(name = "Category")
public interface CategoryMapper extends Mapper<Category> {
}

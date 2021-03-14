package com.derellea.mapper;

import com.derellea.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import javax.persistence.Table;

@Repository
@Table(name = "user")
public interface UserMapper extends Mapper<User> {
    @Select("select * from user where username = #{user.username} and password = #{user.password}")
    public User findByUsernameAndPassword(@Param("user")User user);

    @Select("select * from user where id = #{id}")
    public User findById(int id);

}

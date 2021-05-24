package com.example.demo.Dao;

import com.example.demo.Pojo.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface UserDao extends Mapper <User> {


}


package com.example.demo.Service;

import com.example.demo.Pojo.User;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserService {
    public int addUser(User user);

    public User findOneUser(User user);

    public List <User> findUsers(User user);

    public int updateUser(User user);

    public int deleteUser(User user);

    public List <User> selectAll();
}

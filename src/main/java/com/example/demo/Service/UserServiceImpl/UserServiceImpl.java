package com.example.demo.Service.UserServiceImpl;

import com.example.demo.Dao.UserDao;
import com.example.demo.Pojo.User;
import com.example.demo.Service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Component
@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        return userDao.insertSelective(user);
    }


    @Override
    public User findOneUser(User user) {
        return userDao.selectOne(user);
    }

    @Override
    public List <User> findUsers(User user) {
        return userDao.select(user);
    }

    @Override
    public int updateUser(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        //根据主键Id进行更新
        criteria.andEqualTo("id", user.getId());
        return userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUser(User user) {
        return userDao.delete(user);
    }

    @Override
    public List <User> selectAll() {
        return userDao.selectAll();
    }


}



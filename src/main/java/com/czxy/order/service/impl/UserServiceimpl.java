package com.czxy.order.service.impl;

import com.czxy.order.domain.User;
import com.czxy.order.mapper.UserMapper;
import com.czxy.order.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceimpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseEntity<User> login(User user) {
        Example example = new Example(User.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("username",user.getUsername());
        User user1 = userMapper.selectOneByExample(example);
        return  ResponseEntity.ok(user1);
    }
}

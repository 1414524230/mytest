package com.dom.multiple.service.impl;

import com.dom.multiple.bean.User;
import com.dom.multiple.mapper.UserMapper;
import com.dom.multiple.service.OtherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OtherServiceImpl implements OtherService {

    @Resource
    UserMapper userMapper;

    @Override
//    @Transactional(propagation = Propagation.MANDATORY)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update() {
        User user = new User();
        user.setAge(18);
        user.setUsername("qyn");
        userMapper.update(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert(User user) {
        userMapper.insert(user);
    }
}

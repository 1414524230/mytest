package com.dom.multiple.service.impl;

import com.dom.multiple.bean.User;
import com.dom.multiple.mapper.UserMapper;
import com.dom.multiple.service.OtherService;
import com.dom.multiple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

//    注解的几种类型
//    @Transactional(propagation = Propagation.MANDATORY)
//    REQUIRED ：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
//    SUPPORTS ：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
//    MANDATORY ：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
//    REQUIRES_NEW ：创建一个新的事务，如果当前存在事务，则把当前事务挂起。
//    NOT_SUPPORTED ：以非事务方式运行，如果当前存在事务，则把当前事务挂起。
//    NEVER ：以非事务方式运行，如果当前存在事务，则抛出异常。
//    NESTED ：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于 REQUIRED 。

    @Resource
    private UserMapper userMapper;

    @Autowired
    private OtherService otherService;

    @Override
    @Transactional()
    public void insert() {
        User user = new User();
        user.setAge(18);
        user.setId(UUID.randomUUID().toString());
        user.setUsername("qyn");
        userMapper.insert(user);
        user.setId(UUID.randomUUID().toString());
        otherService.insert(user);
        throw new RuntimeException();
    }
}

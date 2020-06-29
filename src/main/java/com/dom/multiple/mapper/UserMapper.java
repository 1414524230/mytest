package com.dom.multiple.mapper;

import com.dom.multiple.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
//@Component(value = "userMapper")
public interface UserMapper {

    public void insert(User user);

    public void update(User user);

}

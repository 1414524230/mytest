package com.example.demo.service.serviceIml;

import com.example.demo.bean.MongdbBeanUser;
import com.example.demo.service.MongdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongdbServiceImpl implements MongdbService {

    @Autowired
    private MongoOperations mongoTemplate;

    @Override
    public void saveBean(MongdbBeanUser user) {
        mongoTemplate.save(user);
    }

    @Override
    public MongdbBeanUser findOne(String param) {
        Query name = new Query(Criteria.where("name").is(param));
        MongdbBeanUser one = mongoTemplate.findOne(name, MongdbBeanUser.class);
        return one;
    }

    @Override
    public List<MongdbBeanUser> findAll() {
        List<MongdbBeanUser> all = mongoTemplate.findAll(MongdbBeanUser.class);
        return all;
    }
}

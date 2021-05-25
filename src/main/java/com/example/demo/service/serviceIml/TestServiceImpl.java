package com.example.demo.service.serviceIml;

import com.example.demo.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public void sout(String name) {
        System.out.println("打印="+name);
    }
}

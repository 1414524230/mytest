package com.example.demo.test;

import com.example.demo.bean.User;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestDemo {




    @Test
    public void test1(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        ArrayList<User> userList = new ArrayList<>();
        try {
            User user1 = new User("zf",27,simpleDateFormat.parse("1994-11-14"),98,"DX");
            User user2 = new User("cj",29,simpleDateFormat.parse("1994-01-14"),100,"DX");
            User user3 = new User("lx",28,simpleDateFormat.parse("1994-08-14"),90,"南重楼");
            User user4 = new User("wy",26,simpleDateFormat.parse("1995-09-14"),95,"DX");
            userList.add(user1);
            userList.add(user2);
            userList.add(user3);
            userList.add(user4);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //分组
        Map<String, List<User>> nameAddress = userList.stream().collect(Collectors.groupingBy(user -> user.getName() + "_" + user.getAddress()));
        System.out.println(nameAddress);
        //转map
        Map<String, User> addressMap = userList.stream().collect(Collectors.toMap(User::getAddress, Function.identity(), (k1, k2) -> k2));
        System.out.println(addressMap);
        //(默认由小到大)
        List<User> birthdayList = userList.stream().sorted(Comparator.comparing(User::getBirthday)).collect(Collectors.toList());
        System.out.println("排序:"+birthdayList);
        //排序由大到小
        List<User> sorceList = userList.stream().sorted(Comparator.comparing(User::getSocre,Comparator.naturalOrder())).collect(Collectors.toList());
        System.out.println("排序:"+sorceList);

    }


    @Test
    public void test2(){
        String test = String.format("%s/ECB/PKCS5", "test");
        System.out.println(test);
    }

}

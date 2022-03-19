package com.atguigu.mpdemo1010;

import com.atguigu.mpdemo1010.entity.User;
import com.atguigu.mpdemo1010.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@SpringBootTest
public class Mpdemo1010ApplicationTests {

    @Autowired
    private UserMapper userMapper; //UserMapper加@Repository

    //查询user表中的所有数据
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null); //调usermapper的方法
        System.out.println(users);
    }

    //添加操作
    @Test
    public void addUser() {
        User user = new User();
        user.setName("janny");
        user.setAge(80);
        user.setEmail("Sunny@nb.com");

        //手动设置填充时间
        //user.setCreateTime(new Date());
        //user.setUpdateTime(new Date());
        //mp自动生成19位的id值
        int result = userMapper.insert(user);
        System.out.println("insert:" + result); //影响的行数
        System.out.println(user);//id自动回填
    }

    //修改操作
    @Test
    public void updateUser(){
        User user = new User();
        user.setId(2L);
        user.setAge(120);

        int row = userMapper.updateById(user);
        System.out.println(row);
    }

    @Test
    public void testOptimisticLocker(){
        //根据id查询数据
        User user = userMapper.selectById(1);

        //进行修改
        user.setAge(200);
        userMapper.updateById(user);
    }

    @Test
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1,2,3));
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("age",120);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

}

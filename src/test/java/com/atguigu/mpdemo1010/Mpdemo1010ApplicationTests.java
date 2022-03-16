package com.atguigu.mpdemo1010;

import com.atguigu.mpdemo1010.entity.User;
import com.atguigu.mpdemo1010.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        user.setName("Sunny");
        user.setAge(30);
        user.setEmail("Sunny@nb.com");
        //mp自动生成19位的id值
        int insert = userMapper.insert(user);
        System.out.println("insert:" + insert); //影响的行数
        System.out.println(user);//id自动回填
    }

}

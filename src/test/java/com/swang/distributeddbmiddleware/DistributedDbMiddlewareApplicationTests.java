package com.swang.distributeddbmiddleware;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.swang.ddbm.helo.entity.User;
import com.swang.ddbm.helo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DistributedDbMiddlewareApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testAddUser() {
        for (int i = 0; i < 10; i++) {
            System.out.println(("----- Add user ------"));
            User user = new User();
            user.setAge(i+ new Random(17).nextInt(90));
            user.setEmail("a"+i+"@email.com");
            user.setName("a"+i);
            System.out.println(user);
            userMapper.insert(user);
        }
    }

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(User::getAge,32);
        List<User> userList = userMapper.selectList(queryWrapper);
       // assertEquals(0, userList.size());
        userList.forEach(System.out::println);
    }

}

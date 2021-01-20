package com.swang.distributeddbmiddleware;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.swang.ddbm.helo.entity.User;
import com.swang.ddbm.helo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DistributedDbMiddlewareApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().gt(User::getAge,21);
		List<User> userList = userMapper.selectList(queryWrapper);
		assertEquals(2, userList.size());
		userList.forEach(System.out::println);
	}

}

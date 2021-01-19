package com.swang.distributeddbmiddleware;

import com.swang.distributeddbmiddleware.mapper.UserMapper;
import com.swang.distributeddbmiddleware.model.User;
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
		List<User> userList = userMapper.selectList(null);
		assertEquals(5, userList.size());
		userList.forEach(System.out::println);
	}

}
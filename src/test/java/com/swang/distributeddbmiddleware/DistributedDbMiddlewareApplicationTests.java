package com.swang.distributeddbmiddleware;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swang.ddbm.helo.entity.AvailableRec;
import com.swang.ddbm.helo.entity.RecRegistry;
import com.swang.ddbm.helo.entity.User;
import com.swang.ddbm.helo.mapper.AvailableRecMapper;
import com.swang.ddbm.helo.mapper.RecRegistryMapper;
import com.swang.ddbm.helo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DistributedDbMiddlewareApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RecRegistryMapper recRegistryMapper;

    @Autowired
    private AvailableRecMapper availableRecMapper;

    /**
     * 只分库，不分表
     */
    @Test
    public void testAddUser() {
        for (int i = 0; i < 10; i++) {
            System.out.println(("----- Add user ------"));
            User user = new User();
            user.setAge(i + new Random(17).nextInt(90));
            user.setEmail("a" + i + "@email.com");
            user.setName("a" + i);
            System.out.println(user);
            userMapper.insert(user);
        }
    }

    /**
     * 按分库键查询
     */
    @Test
    public void testGetUserById() {
        System.out.println(("----- get user by id ------"));
        User user = userMapper.selectById(560135782296190976L);
        assertNotNull(user);
        System.out.println(user);
    }

    /**
     * 查全部数据
     */
    @Test
    public void testSelectAllUser() {
        System.out.println(("----- select all user ------"));
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> userList = userMapper.selectList(queryWrapper);
        assertEquals(10, userList.size());
        userList.forEach(System.out::println);
    }

    /**
     * 按普通列查询
     */
    @Test
    public void testSelectByAge() {
        System.out.println(("----- select user by age ------"));
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().gt(User::getAge, 3);
        List<User> userList = userMapper.selectList(queryWrapper);
        assertTrue(userList.size() > 0);
        userList.forEach(System.out::println);
    }

    /**
     * 广播表插入
     */
    @Test
    public void testAddRecRegistry() {
        System.out.println(("----- Add rec registry ------"));
        RecRegistry recRegistry = new RecRegistry();
        recRegistry.setId("trecs");
        recRegistry.setName("TRECs.ai");
        System.out.println(recRegistry);
        recRegistryMapper.insert(recRegistry);
    }

    @Test
    public void testDelRecRegistry() {
        System.out.println(("----- Delete rec registry ------"));
        int count = recRegistryMapper.deleteById("trecs");
        assertEquals(1, count);
    }

    /**
     * 查询广播表
     */
    @Test
    public void testSelectRecRegistry() {
        System.out.println(("----- Select a registry ------"));
        for (int i = 0; i < 10; i++) {
            RecRegistry recRegistry = recRegistryMapper.selectById("trecs");
            assertNotNull(recRegistry);
            System.out.println(recRegistry);
        }
    }

    /**
     * 插入available_rec
     */
    @Test
    public void testAddREC() {
        System.out.println(("----- Add rec ------"));

        List<User> users = userMapper.selectList(new QueryWrapper<>());
        User user = users.stream().findFirst().orElse(null);
        if (user != null) {
            for (int i = 0; i < 10; i++) {
                AvailableRec availableRec = new AvailableRec();
                availableRec.setRecId("REC_" + i);
                availableRec.setAssetName("Asset_"+i);
                availableRec.setOwnerId(user.getId());
                availableRec.setRegistryId("trecs");
                System.out.println(availableRec);
                availableRecMapper.insert(availableRec);
            }
        }
    }

    /**
     * 按分库键 user id 查询 available rec
     */
    @Test
    public void testSelectRECByUserId() {
        System.out.println(("----- select rec by user id ------"));

        QueryWrapper<AvailableRec> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(AvailableRec::getOwnerId,560135781159534592L);
        List<AvailableRec> availableRecs = availableRecMapper.selectList(queryWrapper);
        assertEquals(10,availableRecs.size());
        availableRecs.forEach(System.out::println);
    }

    /**
     * 按分表键 查询 available rec
     */
    @Test
    public void testSelectRECById() {
        System.out.println(("----- select rec by id ------"));
        AvailableRec availableRec = availableRecMapper.selectById(1353276633368248321L);
        assertNotNull(availableRec);
        System.out.println(availableRec);
    }

    /**
     * 分页测试
     */
    @Test
    public void testSelectRECViaPagination() {
        System.out.println(("----- select paginated rec ------"));
        Page<AvailableRec> page = new Page<>(4,1);
        Page<AvailableRec> availableRecPage = availableRecMapper.selectPage(page, new QueryWrapper<>());

        long total = availableRecPage.getTotal();
        List<AvailableRec> records = availableRecPage.getRecords();

        System.out.println("total: " + total);
        records.forEach(System.out::println);
    }

    /**
     * 查某个用户的rec
     */
    @Test
    public void testSelectRECByUserName() {
        System.out.println(("----- select rec and join user ------"));
        User user = new User();
        user.setName("a0");
        List<AvailableRec> availableRecs = availableRecMapper.selectByUserName(user);
        availableRecs.forEach(System.out::println);
    }

    /**
     * 读写分离
     */
    @Test
    public void testReadAndWrite() {
        for(int i=100;i<110;i++){
            System.out.println(("----- Add user ------"));
            User user = new User();
            user.setAge(i + new Random(17).nextInt(90));
            user.setEmail("a" + i + "@email.com");
            user.setName("a" + i);
            System.out.println(user);
            userMapper.insert(user);
        }

        for(int i=0;i<10;i++){
            System.out.println(("----- select all user ------"));
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            List<User> userList = userMapper.selectList(queryWrapper);
            userList.forEach(System.out::println);
        }
    }
}

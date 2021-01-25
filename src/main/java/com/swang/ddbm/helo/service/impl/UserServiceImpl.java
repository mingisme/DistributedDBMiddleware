package com.swang.ddbm.helo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.swang.ddbm.helo.entity.AvailableRec;
import com.swang.ddbm.helo.entity.User;
import com.swang.ddbm.helo.mapper.AvailableRecMapper;
import com.swang.ddbm.helo.mapper.UserMapper;
import com.swang.ddbm.helo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-01-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AvailableRecMapper availableRecMapper;

    @Override
    public void addTwoUsersWithoutTx() {
        User user1 = new User();
        user1.setId(1L);
        user1.setEmail("x1@email.com");
        user1.setName("x1");
        user1.setAge(10);
        userMapper.insert(user1);

        User user0 = new User();
        user0.setId(0L);
        user0.setEmail("a0@email.com");
        user0.setName("a0");
        user0.setAge(10);
        userMapper.insert(user0);
    }

    @Transactional
    @Override
    public void addTwoUsersWithTx() {
        User user1 = new User();
        user1.setId(1L);
        user1.setEmail("x1@email.com");
        user1.setName("x1");
        user1.setAge(10);
        userMapper.insert(user1);

        User user0 = new User();
        user0.setId(0L);
        user0.setEmail("a0@email.com");
        user0.setName("a0");
        user0.setAge(10);
        userMapper.insert(user0);
    }

    @Transactional
    @Override
    public void addOneUserAndOneRecWithTx() {
        List<User> users = userMapper.selectList(new QueryWrapper<>());
        User user = users.stream().filter(u -> u.getId() % 2 == 1).findFirst().orElse(null);

        AvailableRec availableRec = new AvailableRec();
        availableRec.setId(1L);
        availableRec.setRecId("REC_x1");
        availableRec.setRegistryId("trecs");
        availableRec.setAssetName("asset_x1");
        availableRec.setOwnerId(user.getId());
        availableRecMapper.insert(availableRec);

        User user0 = new User();
        user0.setId(0L);
        user0.setEmail("a0@email.com");
        user0.setName("a0");
        user0.setAge(10);
        userMapper.insert(user0);

    }


}

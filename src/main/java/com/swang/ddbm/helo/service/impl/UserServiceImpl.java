package com.swang.ddbm.helo.service.impl;

import com.swang.ddbm.helo.entity.User;
import com.swang.ddbm.helo.mapper.UserMapper;
import com.swang.ddbm.helo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}

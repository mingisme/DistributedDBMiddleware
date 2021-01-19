package com.baomidou.ant.hello.service.impl;

import com.baomidou.ant.hello.entity.User;
import com.baomidou.ant.hello.mapper.UserMapper;
import com.baomidou.ant.hello.service.IUserService;
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

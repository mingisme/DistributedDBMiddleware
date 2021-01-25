package com.swang.ddbm.helo.service;

import com.swang.ddbm.helo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2021-01-20
 */
public interface IUserService extends IService<User> {

    void addTwoUsersWithoutTx();

    void addTwoUsersWithTx();

    void addOneUserAndOneRecWithTx();

}

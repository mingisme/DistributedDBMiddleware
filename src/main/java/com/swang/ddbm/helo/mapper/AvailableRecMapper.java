package com.swang.ddbm.helo.mapper;

import com.swang.ddbm.helo.entity.AvailableRec;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swang.ddbm.helo.entity.User;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-01-20
 */
public interface AvailableRecMapper extends BaseMapper<AvailableRec> {

    List<AvailableRec> selectByUserName(User user);

}

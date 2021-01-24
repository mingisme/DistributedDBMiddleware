package com.swang.ddbm.helo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-01-20
 */
@Data
public class RecRegistry  {

    private static final long serialVersionUID = 1L;

    @TableId(value="id",type= IdType.INPUT)
    private String id;
    private String name;


}

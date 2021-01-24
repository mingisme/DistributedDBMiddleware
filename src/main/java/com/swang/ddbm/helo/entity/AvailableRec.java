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
public class AvailableRec {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private String assetName;

    private long ownerId;

    private String recId;

    private String registryId;


}

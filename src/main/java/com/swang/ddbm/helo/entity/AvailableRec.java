package com.swang.ddbm.helo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

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

    private String assetName;

    private String ownerId;

    private String recId;

    private String registryId;


}

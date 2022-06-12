package com.esf.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 押金状态
 */
@AllArgsConstructor
@Getter
public enum DepositStatusEnum {

    ALREADY(0L, "已交"),
    RETURN(1L, "已退"),
    DEDUCT(2L, "扣除"),
    ;
    private Long status;
    private String name;

}

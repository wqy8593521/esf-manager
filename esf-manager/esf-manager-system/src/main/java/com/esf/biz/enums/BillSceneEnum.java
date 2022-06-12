package com.esf.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wangqiyan
 */

@AllArgsConstructor
@Getter
public enum BillSceneEnum {
    RECEIVE_RENT(0L, "收租"),

    RECEIVE_DEPOSIT(1L, "收押金"),

    RETURN_DEPOSIT(2L, "退押金"),

    RENEWAL_DEPOSIT(3L, "续租收租"),

    RETURN_RENT(4L, "退租退费"),

    PAY_COST(5L, "支付成本"),
    ;

    private Long scene;
    private String name;


}

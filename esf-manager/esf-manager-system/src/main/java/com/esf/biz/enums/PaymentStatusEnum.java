package com.esf.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 交租状态
 */
@AllArgsConstructor
@Getter
public enum PaymentStatusEnum {
    CURRENT_PAY(0L, "本期已交"),
    CURRENT_NOT_PAY(1L, "本期未交"),
    DELAY_NOT_PAY(2L, "逾期未交"),
    ;
    private Long status;
    private String name;

}

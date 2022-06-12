package com.esf.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HireStatusEnum {
    ON(0L, "在租"),
    OFF(1L, "归还"),
    STOP(2L, "合同强制终止"),
    ;
    private Long status;
    private String name;
}

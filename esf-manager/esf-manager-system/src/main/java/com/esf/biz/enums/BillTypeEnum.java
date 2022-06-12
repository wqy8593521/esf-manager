package com.esf.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BillTypeEnum {
    INCOME(0L, "收入"),
    OUTCOME(1L, "支出"),
    ;

    private Long type;
    private String name;

}

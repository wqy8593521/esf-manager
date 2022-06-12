package com.esf.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoomStatusEnum {
    FREE(0L, "空闲"),
    RENT(1L, "在租"),
    COMING(2L, "临期"),
    ;
    private Long status;
    private String name;
}

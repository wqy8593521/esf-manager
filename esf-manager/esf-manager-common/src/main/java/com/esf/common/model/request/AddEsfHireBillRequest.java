package com.esf.common.model.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel("新增出租账单请求")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddEsfHireBillRequest {

    /**
     * 租赁id
     */
    @ApiModelProperty(name = "租赁id")
    @NotNull
    private Long hireId;

    /**
     * {@link com.esf.biz.enums.BillSceneEnum}
     * 账单场景 0收租 1收押金 2退押金 3续租收租 4 退租退费 5支付成本
     */
    @ApiModelProperty(name = "账单场景 0收租 1收押金 2退押金 3续租收租 4 退租退费 5支付成本")
    @NotNull
    private Long billScene;

    /**
     * {@link com.esf.biz.enums.BillTypeEnum}
     * 账单类型 0支出 1收入（对于中介）
     */
    @ApiModelProperty(name = "账单类型 0支出 1收入")
    @NotNull
    private Long billType;


    /**
     * 影响金额
     */
    @ApiModelProperty(name = "影响金额")
    @NotNull
    private BigDecimal balance;


//    /**
//     * 租户id
//     */
//    @ApiModelProperty(name = "租户id")
//    @NotNull
//    private Long tenantId;
//
//    /**
//     * 房间id
//     */
//    @ApiModelProperty(name = "房间id")
//    @NotNull
//    private Long roomId;


    /**
     * 备注
     */
    @ApiModelProperty(name = "备注")
    private String remark;

}

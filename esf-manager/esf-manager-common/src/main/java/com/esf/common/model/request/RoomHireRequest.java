package com.esf.common.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@ApiModel("房屋租赁请求")
public class RoomHireRequest {

    @ApiModelProperty("房间ID")
    @NotNull(message = "房间ID不能为空")
    private Long roomId;

    @ApiModelProperty("租户ID")
    @NotNull(message = "租户ID不能为空")
    private Long tenantId;

    @ApiModelProperty("期限（月）")
    @NotNull(message = "期限不能为空")
    @Min(value = 1, message = "期限不能小于1月")
    private Long hireTerm;

    @ApiModelProperty("租赁价格")
    @NotNull(message = "租赁价格不能为空")
    @Min(value = 0, message = "租赁价格不能小于0")
    private BigDecimal hirePrice;

    @ApiModelProperty("押金")
    @NotNull(message = "押金不能为空")
    @Min(value = 0, message = "押金不能小于0")
    private BigDecimal deposit;

    @ApiModelProperty("押金状态")
    @NotNull(message = "押金状态不能为空")
    @Min(value = 0, message = "押金状态不能小于0")
    @Max(value = 2, message = "押金状态不能小于2")
    private Long depositStatus;

}

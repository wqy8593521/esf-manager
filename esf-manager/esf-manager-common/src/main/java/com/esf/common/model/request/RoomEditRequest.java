package com.esf.common.model.request;

import com.esf.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel("房源信息编辑请求")
public class RoomEditRequest {
    @ApiModelProperty("id")
    private Long id;

    /**
     * 区域id
     */
    @ApiModelProperty("区域id")
    private Long regionId;

    @ApiModelProperty("房东列表")
    private List<Long> hostList;

    /**
     * 房屋名字
     */
    @ApiModelProperty("房屋名字")
    private String roomName;

    /**
     * 房屋户型0单间 1二人间 2三人间
     */
    @ApiModelProperty("房屋户型")
    private Long roomType;

    /**
     * 房屋规格
     */
    @ApiModelProperty("房屋规格")
    private Long roomSpec;

    /**
     * 房屋容纳人数
     */
    @ApiModelProperty("房屋容纳人数")
    private Long roomCapacity;

    /**
     * 房屋图片
     */
    @ApiModelProperty("房屋图片")
    private String roomPic;

    /**
     * 出租状态
     */
    @ApiModelProperty("出租状态")
    private Long roomStatus;

    /**
     * 房屋成本（月）
     */
    @ApiModelProperty("房屋成本（月）")
    private BigDecimal roomCost;
}

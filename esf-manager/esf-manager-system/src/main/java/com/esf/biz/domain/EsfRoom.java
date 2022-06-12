package com.esf.biz.domain;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.esf.common.annotation.Excel;
import com.esf.common.core.domain.BaseEntity;

/**
 * 房源信息对象 esf_room
 * 
 * @author esf-manager
 * @date 2022-06-02
 */
public class EsfRoom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 房间id */
    @TableId(type = IdType.AUTO)

    private Long id;

    /** 区域id */
    @Excel(name = "区域id")
    private Long regionId;

    /** 房屋名字 */
    @Excel(name = "房屋名字")
    private String roomName;

    /** 房屋户型0单间 1二人间 2三人间 */
    @Excel(name = "房屋户型0单间 1二人间 2三人间")
    private Long roomType;

    /** 房屋规格 */
    @Excel(name = "房屋规格")
    private Long roomSpec;

    /** 房屋容纳人数 */
    @Excel(name = "房屋容纳人数")
    private Long roomCapacity;

    /** 房屋图片 */
    @Excel(name = "房屋图片")
    private String roomPic;

    /** 出租状态 */
    @Excel(name = "出租状态")
    private Long roomStatus;

    /** 房屋成本（月） */
    @Excel(name = "房屋成本", readConverterExp = "月=")
    private BigDecimal roomCost;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRegionId(Long regionId) 
    {
        this.regionId = regionId;
    }

    public Long getRegionId() 
    {
        return regionId;
    }
    public void setRoomName(String roomName) 
    {
        this.roomName = roomName;
    }

    public String getRoomName() 
    {
        return roomName;
    }
    public void setRoomType(Long roomType) 
    {
        this.roomType = roomType;
    }

    public Long getRoomType() 
    {
        return roomType;
    }
    public void setRoomSpec(Long roomSpec) 
    {
        this.roomSpec = roomSpec;
    }

    public Long getRoomSpec() 
    {
        return roomSpec;
    }
    public void setRoomCapacity(Long roomCapacity) 
    {
        this.roomCapacity = roomCapacity;
    }

    public Long getRoomCapacity() 
    {
        return roomCapacity;
    }
    public void setRoomPic(String roomPic) 
    {
        this.roomPic = roomPic;
    }

    public String getRoomPic() 
    {
        return roomPic;
    }
    public void setRoomStatus(Long roomStatus) 
    {
        this.roomStatus = roomStatus;
    }

    public Long getRoomStatus() 
    {
        return roomStatus;
    }
    public void setRoomCost(BigDecimal roomCost) 
    {
        this.roomCost = roomCost;
    }

    public BigDecimal getRoomCost() 
    {
        return roomCost;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("regionId", getRegionId())
            .append("roomName", getRoomName())
            .append("roomType", getRoomType())
            .append("roomSpec", getRoomSpec())
            .append("roomCapacity", getRoomCapacity())
            .append("roomPic", getRoomPic())
            .append("roomStatus", getRoomStatus())
            .append("roomCost", getRoomCost())
            .toString();
    }
}

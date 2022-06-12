package com.esf.biz.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.esf.common.annotation.Excel;
import com.esf.common.core.domain.BaseEntity;

/**
 * 房屋区域对象 esf_room_region
 * 
 * @author esf-manager
 * @date 2022-06-02
 */
public class EsfRoomRegion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(type = IdType.AUTO)

    private Long id;

    /** 全国地址编码 */
    @Excel(name = "全国地址编码")
    private String addressCode;

    /** 详细地址信息 */
    @Excel(name = "详细地址信息")
    private String addressInfo;

    /** 房屋区域名 */
    @Excel(name = "房屋区域名")
    private String regionName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAddressCode(String addressCode) 
    {
        this.addressCode = addressCode;
    }

    public String getAddressCode() 
    {
        return addressCode;
    }
    public void setAddressInfo(String addressInfo) 
    {
        this.addressInfo = addressInfo;
    }

    public String getAddressInfo() 
    {
        return addressInfo;
    }
    public void setRegionName(String regionName) 
    {
        this.regionName = regionName;
    }

    public String getRegionName() 
    {
        return regionName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("addressCode", getAddressCode())
            .append("addressInfo", getAddressInfo())
            .append("regionName", getRegionName())
            .toString();
    }
}

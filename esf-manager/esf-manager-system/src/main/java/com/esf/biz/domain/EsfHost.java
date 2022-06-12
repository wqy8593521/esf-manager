package com.esf.biz.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.esf.common.annotation.Excel;
import com.esf.common.core.domain.BaseEntity;

/**
 * 房东信息对象 esf_host
 * 
 * @author esf-manager
 * @date 2022-06-03
 */
public class EsfHost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 房东id */
    @TableId(type = IdType.AUTO)

    private Long id;

    /** 房东名字 */
    @Excel(name = "房东名字")
    private String hostName;

    /** 房东电话 */
    @Excel(name = "房东电话")
    private String hostMobile;

    /** 房东头像 */
    @Excel(name = "房东头像")
    private String hostAvatar;

    /** 房东性别 */
    @Excel(name = "房东性别")
    private Long hostSex;

    /** 房东年龄 */
    @Excel(name = "房东年龄")
    private Long hostAge;

    /** 房源数 */
    @Excel(name = "房源数")
    private Long houseNum;

    /** 全国地址编码 */
    @Excel(name = "全国地址编码")
    private String addressCode;

    /** 详细地址信息 */
    @Excel(name = "详细地址信息")
    private String addressInfo;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHostName(String hostName) 
    {
        this.hostName = hostName;
    }

    public String getHostName() 
    {
        return hostName;
    }
    public void setHostMobile(String hostMobile) 
    {
        this.hostMobile = hostMobile;
    }

    public String getHostMobile() 
    {
        return hostMobile;
    }
    public void setHostAvatar(String hostAvatar) 
    {
        this.hostAvatar = hostAvatar;
    }

    public String getHostAvatar() 
    {
        return hostAvatar;
    }
    public void setHostSex(Long hostSex) 
    {
        this.hostSex = hostSex;
    }

    public Long getHostSex() 
    {
        return hostSex;
    }
    public void setHostAge(Long hostAge) 
    {
        this.hostAge = hostAge;
    }

    public Long getHostAge() 
    {
        return hostAge;
    }
    public void setHouseNum(Long houseNum) 
    {
        this.houseNum = houseNum;
    }

    public Long getHouseNum() 
    {
        return houseNum;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("hostName", getHostName())
            .append("hostMobile", getHostMobile())
            .append("hostAvatar", getHostAvatar())
            .append("hostSex", getHostSex())
            .append("hostAge", getHostAge())
            .append("houseNum", getHouseNum())
            .append("addressCode", getAddressCode())
            .append("addressInfo", getAddressInfo())
            .toString();
    }
}

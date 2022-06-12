package com.esf.biz.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.esf.common.annotation.Excel;
import com.esf.common.core.domain.BaseEntity;

/**
 * 租客信息对象 esf_tenant
 *
 * @author esf-manager
 * @date 2022-06-03
 */
public class EsfTenant extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 租客id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 租客名字
     */
    @Excel(name = "租客名字")
    private String tenantName;

    /**
     * 租客电话
     */
    @Excel(name = "租客电话")
    private String tenantMobile;

    /**
     * 租客头像
     */
    @Excel(name = "租客头像")
    private String tenantAvatar;

    /**
     * 租客性别
     */
    @Excel(name = "租客性别")
    private Long tenantSex;

    /**
     * 租客年龄
     */
    @Excel(name = "租客年龄")
    private Long tenantAge;

    /**
     * 租客身份证号
     */
    @Excel(name = "租客身份证号")
    private String tenantIdCard;

    /**
     * 全国地址编码
     */
    @Excel(name = "全国地址编码")
    private String addressCode;

    /**
     * 详细地址信息
     */
    @Excel(name = "详细地址信息")
    private String addressInfo;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantMobile(String tenantMobile) {
        this.tenantMobile = tenantMobile;
    }

    public String getTenantMobile() {
        return tenantMobile;
    }

    public void setTenantAvatar(String tenantAvatar) {
        this.tenantAvatar = tenantAvatar;
    }

    public String getTenantAvatar() {
        return tenantAvatar;
    }

    public void setTenantSex(Long tenantSex) {
        this.tenantSex = tenantSex;
    }

    public Long getTenantSex() {
        return tenantSex;
    }

    public void setTenantAge(Long tenantAge) {
        this.tenantAge = tenantAge;
    }

    public Long getTenantAge() {
        return tenantAge;
    }

    public void setTenantIdCard(String tenantIdCard) {
        this.tenantIdCard = tenantIdCard;
    }

    public String getTenantIdCard() {
        return tenantIdCard;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("tenantName", getTenantName())
                .append("tenantMobile", getTenantMobile())
                .append("tenantAvatar", getTenantAvatar())
                .append("tenantSex", getTenantSex())
                .append("tenantAge", getTenantAge())
                .append("tenantIdCard", getTenantIdCard())
                .append("addressCode", getAddressCode())
                .append("addressInfo", getAddressInfo())
                .toString();
    }
}

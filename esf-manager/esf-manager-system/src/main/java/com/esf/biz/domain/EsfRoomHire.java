package com.esf.biz.domain;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.esf.common.annotation.Excel;
import com.esf.common.core.domain.BaseEntity;

/**
 * 房屋租赁对象 esf_room_hire
 *
 * @author esf-manager
 * @date 2022-06-03
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EsfRoomHire extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)

    private Long id;

    /**
     * 租户id
     */
    @Excel(name = "租户id")
    private Long tenantId;

    /**
     * 房间id
     */
    @Excel(name = "房间id")
    private Long roomId;

    /**
     * 租赁期限（月）
     */
    @Excel(name = "租赁期限", readConverterExp = "月=")
    private Long hireTerm;

    /**
     * 剩余期数（月）
     */
    @Excel(name = "剩余期数", readConverterExp = "月=")
    private Long remainTerm;

    /**
     * 租赁价格（月）
     */
    @Excel(name = "租赁价格", readConverterExp = "月=")
    private BigDecimal hirePrice;

    /**
     * 押金
     */
    @Excel(name = "押金")
    private BigDecimal deposit;

    /**
     * 押金状态 0已交 1已退 2扣押
     */
    @Excel(name = "押金状态 0已交 1已退 2扣押")
    private Long depositStatus;

    /**
     * 租赁状态 0在租 1归还 2合同强制终止
     */
    @Excel(name = "租赁状态 0在租 1归还 2合同强制终止")
    private Long hireStatus;

    /**
     * 交租状态 0本期已交 1本期未交 2逾期未交
     */
    @Excel(name = "交租状态 0本期已交 1本期未交 2逾期未交")
    private Long paymentStatus;




}

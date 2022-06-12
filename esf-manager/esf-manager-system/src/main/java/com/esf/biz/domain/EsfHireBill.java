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

import javax.validation.constraints.NotNull;

/**
 * 房屋租赁账单对象 esf_hire_bill
 *
 * @author esf-manager
 * @date 2022-06-03
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EsfHireBill extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 租赁id
     */
    @Excel(name = "租赁id")
    @NotNull(message = "租赁id不能为空")
    private Long hireId;

    /**
     * 账单场景 0收租 1收押金 2退押金 3续租收租 4 退租退费 5支付成本
     */
    @Excel(name = "账单场景")
    @NotNull(message = "账单场景不能为空")

    private Long billScene;

    /**
     * 账单类型 0支出 1收入（对于中介）
     */
    @Excel(name = "账单类型", readConverterExp = "对=于中介")
    @NotNull(message = "账单类型不能为空")

    private Long billType;

    /**
     * 之前金额
     */
    @Excel(name = "之前金额")
    private BigDecimal beforeNum;

    /**
     * 影响金额
     */
    @Excel(name = "影响金额")
    @NotNull(message = "影响金额不能为空")

    private BigDecimal balance;

    /**
     * 之后金额
     */
    @Excel(name = "之后金额")
    private BigDecimal afterNum;

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

    private String remark;


}

package com.esf.biz.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.esf.biz.domain.EsfRoomHire;
import com.esf.biz.enums.BillTypeEnum;
import com.esf.biz.service.IEsfRoomHireService;
import com.esf.common.exception.ServiceException;
import com.esf.common.model.request.AddEsfHireBillRequest;
import com.esf.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.esf.biz.mapper.EsfHireBillMapper;
import com.esf.biz.domain.EsfHireBill;
import com.esf.biz.service.IEsfHireBillService;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 房屋租赁账单Service业务层处理
 *
 * @author esf-manager
 * @date 2022-06-03
 */
@Service
@Validated
public class EsfHireBillServiceImpl implements IEsfHireBillService {
    @Autowired
    private EsfHireBillMapper esfHireBillMapper;

    @Resource
    @Lazy
    private IEsfRoomHireService esfRoomHireService;

    /**
     * 查询房屋租赁账单
     *
     * @param id 房屋租赁账单主键
     * @return 房屋租赁账单
     */
    @Override
    public EsfHireBill selectEsfHireBillById(Long id) {
        return esfHireBillMapper.selectEsfHireBillById(id);
    }

    /**
     * 查询房屋租赁账单列表
     *
     * @param esfHireBill 房屋租赁账单
     * @return 房屋租赁账单
     */
    @Override
    public List<EsfHireBill> selectEsfHireBillList(EsfHireBill esfHireBill) {
        return esfHireBillMapper.selectEsfHireBillList(esfHireBill);
    }

    /**
     * 新增房屋租赁账单
     *
     * @param esfHireBill 房屋租赁账单
     * @return 结果
     */
    @Override
    public int insertEsfHireBill(EsfHireBill esfHireBill) {

        EsfRoomHire roomHire = esfRoomHireService.selectEsfRoomHireById(esfHireBill.getHireId());
        if (roomHire == null) {
            throw new ServiceException("租赁id不存在");
        }
        esfHireBill.setHireId(roomHire.getId());
        esfHireBill.setRoomId(roomHire.getRoomId());
        esfHireBill.setTenantId(roomHire.getTenantId());

        return esfHireBillMapper.insertEsfHireBill(esfHireBill);
    }

    @Override
    public void addEsfHireBill(AddEsfHireBillRequest request) {
        EsfRoomHire roomHire = esfRoomHireService.selectEsfRoomHireById(request.getHireId());
        if (roomHire == null) {
            throw new ServiceException("租赁id不存在");
        }


        LambdaQueryWrapper<EsfHireBill> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EsfHireBill::getHireId, request.getHireId())
                .orderByDesc(EsfHireBill::getId)
                .last("limit 1");
        EsfHireBill esfHireBill = esfHireBillMapper.selectOne(wrapper);

        BigDecimal afterNum;

        EsfHireBill.EsfHireBillBuilder hireBillBuilder = EsfHireBill.builder();

        if (esfHireBill != null) {
            afterNum = esfHireBill.getAfterNum();
        } else {
            afterNum = BigDecimal.ZERO;
        }

        hireBillBuilder.beforeNum(afterNum);
        hireBillBuilder.balance(request.getBalance());


        if (request.getBillType().equals(BillTypeEnum.INCOME.getType())) {
            hireBillBuilder.afterNum(afterNum.add(request.getBalance()));

        } else if (request.getBillType().equals(BillTypeEnum.OUTCOME.getType())) {
            hireBillBuilder.afterNum(afterNum.subtract(request.getBalance()));
        }

        EsfHireBill hireBill = hireBillBuilder.billScene(request.getBillScene())
                .hireId(request.getHireId())
                .roomId(roomHire.getRoomId())
                .tenantId(roomHire.getTenantId())
                .billType(request.getBillType())
                .billScene(request.getBillScene())
                .remark(request.getRemark())

                .build();

        esfHireBillMapper.insert(hireBill);

    }


    /**
     * 修改房屋租赁账单
     *
     * @param esfHireBill 房屋租赁账单
     * @return 结果
     */
    @Override
    public int updateEsfHireBill(EsfHireBill esfHireBill) {
        esfHireBill.setUpdateTime(DateUtils.getNowDate());
        return esfHireBillMapper.updateById(esfHireBill);
    }

    /**
     * 批量删除房屋租赁账单
     *
     * @param ids 需要删除的房屋租赁账单主键
     * @return 结果
     */
    @Override
    public int deleteEsfHireBillByIds(Long[] ids) {
        return esfHireBillMapper.deleteEsfHireBillByIds(ids);
    }

    /**
     * 删除房屋租赁账单信息
     *
     * @param id 房屋租赁账单主键
     * @return 结果
     */
    @Override
    public int deleteEsfHireBillById(Long id) {
        return esfHireBillMapper.deleteEsfHireBillById(id);
    }
}

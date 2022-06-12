package com.esf.biz.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.esf.biz.domain.EsfRoom;
import com.esf.biz.domain.EsfTenant;
import com.esf.biz.enums.*;
import com.esf.biz.service.IEsfHireBillService;
import com.esf.biz.service.IEsfRoomService;
import com.esf.biz.service.IEsfTenantService;
import com.esf.common.exception.ServiceException;
import com.esf.common.model.request.AddEsfHireBillRequest;
import com.esf.common.model.request.RoomHireRequest;
import com.esf.common.model.response.RoomInfoResponse;
import com.esf.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esf.biz.mapper.EsfRoomHireMapper;
import com.esf.biz.domain.EsfRoomHire;
import com.esf.biz.service.IEsfRoomHireService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 房屋租赁Service业务层处理
 *
 * @author esf-manager
 * @date 2022-06-03
 */
@Service
public class EsfRoomHireServiceImpl implements IEsfRoomHireService {
    @Autowired
    private EsfRoomHireMapper esfRoomHireMapper;

    @Resource
    private IEsfRoomService esfRoomService;

    @Resource
    private IEsfTenantService esfTenantService;


    @Resource
    private IEsfHireBillService esfHireBillService;

    /**
     * 查询房屋租赁
     *
     * @param id 房屋租赁主键
     * @return 房屋租赁
     */
    @Override
    public EsfRoomHire selectEsfRoomHireById(Long id) {
        return esfRoomHireMapper.selectEsfRoomHireById(id);
    }

    /**
     * 查询房屋租赁列表
     *
     * @param esfRoomHire 房屋租赁
     * @return 房屋租赁
     */
    @Override
    public List<EsfRoomHire> selectEsfRoomHireList(EsfRoomHire esfRoomHire) {
        return esfRoomHireMapper.selectEsfRoomHireList(esfRoomHire);
    }

    /**
     * 新增房屋租赁
     *
     * @param esfRoomHire 房屋租赁
     * @return 结果
     */
    @Override
    public int insertEsfRoomHire(EsfRoomHire esfRoomHire) {
        esfRoomHire.setCreateTime(DateUtils.getNowDate());
        return esfRoomHireMapper.insert(esfRoomHire);
    }

    @Override
    @Transactional
    public void hireRoom(RoomHireRequest request) {
        RoomInfoResponse room = esfRoomService.selectEsfRoomById(request.getRoomId());
        if (room == null) throw new ServiceException("房间不存在");

        //判断房间是否出租
        if (!room.getRoomStatus().equals(RoomStatusEnum.FREE.getStatus())) {
            throw new ServiceException("房间已出租");
        }

        EsfTenant tenant = esfTenantService.selectEsfTenantById(request.getTenantId());
        if (tenant == null) throw new ServiceException("租户不存在");


        EsfRoomHire roomHire = EsfRoomHire.builder()
                .depositStatus(request.getDepositStatus())
                .deposit(request.getDeposit())
                .hirePrice(request.getHirePrice())
                .hireTerm(request.getHireTerm())
                .hireStatus(HireStatusEnum.ON.getStatus())
                .roomId(request.getRoomId())
                .tenantId(request.getTenantId())
                .remainTerm(request.getHireTerm())
                .paymentStatus(PaymentStatusEnum.CURRENT_PAY.getStatus())
                .build();

        //插入租房信息
        this.insertEsfRoomHire(roomHire);

        //更新房间状态
        EsfRoom esfRoom = new EsfRoom();
        esfRoom.setId(room.getId());
        esfRoom.setRoomStatus(RoomStatusEnum.RENT.getStatus());

        esfRoomService.updateEsfRoom(esfRoom);

        //构建 成本账单
        AddEsfHireBillRequest addEsfHireBillRequest1 = AddEsfHireBillRequest.builder()
                .hireId(roomHire.getId())
                .balance(room.getRoomCost())
                .billScene(BillSceneEnum.PAY_COST.getScene())
                .billType(BillTypeEnum.OUTCOME.getType())
                .build();

        //构建 收租账单
        AddEsfHireBillRequest addEsfHireBillRequest2 = AddEsfHireBillRequest.builder()
                .hireId(roomHire.getId())
                .balance(request.getHirePrice())
                .billScene(BillSceneEnum.RECEIVE_RENT.getScene())
                .billType(BillTypeEnum.INCOME.getType())
                .build();
        //构建 收押金账单
        AddEsfHireBillRequest addEsfHireBillRequest3 = AddEsfHireBillRequest.builder()
                .hireId(roomHire.getId())
                .balance(request.getDeposit())
                .billScene(BillSceneEnum.RECEIVE_DEPOSIT.getScene())
                .billType(BillTypeEnum.INCOME.getType())
                .build();
        //插入账单
        esfHireBillService.addEsfHireBill(addEsfHireBillRequest1);
        esfHireBillService.addEsfHireBill(addEsfHireBillRequest2);
        esfHireBillService.addEsfHireBill(addEsfHireBillRequest3);


    }

    /**
     * 修改房屋租赁
     *
     * @param esfRoomHire 房屋租赁
     * @return 结果
     */
    @Override
    public int updateEsfRoomHire(EsfRoomHire esfRoomHire) {
        esfRoomHire.setUpdateTime(DateUtils.getNowDate());
        return esfRoomHireMapper.updateById(esfRoomHire);
    }

    /**
     * 批量删除房屋租赁
     *
     * @param ids 需要删除的房屋租赁主键
     * @return 结果
     */
    @Override
    public int deleteEsfRoomHireByIds(Long[] ids) {
        return esfRoomHireMapper.deleteEsfRoomHireByIds(ids);
    }

    @Override
    @Transactional
    public int retEsfRoomHireByIds(Long[] ids) {
        List<EsfRoomHire> esfRoomHires = esfRoomHireMapper.selectBatchIds(Arrays.asList(ids));
        AtomicInteger cnt = new AtomicInteger();

        esfRoomHires.forEach(item -> {
            if (item.getHireStatus().equals(HireStatusEnum.ON.getStatus())) {//在租状态
                //更改雇佣状态
                EsfRoomHire roomHire = EsfRoomHire.builder()
                        .id(item.getId())
                        .hireStatus(HireStatusEnum.OFF.getStatus())
                        .build();
                esfRoomHireMapper.updateById(roomHire);
                //更新房子状态
                RoomInfoResponse roomInfoResponse = esfRoomService.selectEsfRoomById(item.getRoomId());
                if (roomInfoResponse != null) {
                    EsfRoom esfRoom = new EsfRoom();
                    esfRoom.setId(roomInfoResponse.getId());
                    esfRoom.setRoomStatus(RoomStatusEnum.FREE.getStatus());
                    esfRoomService.updateEsfRoom(esfRoom);
                }

                //构建 退租账单
                AddEsfHireBillRequest addEsfHireBillRequest1 = AddEsfHireBillRequest.builder()
                        .hireId(roomHire.getId())
                        .balance(roomHire.getHirePrice())
                        .billScene(BillSceneEnum.RETURN_RENT.getScene())
                        .billType(BillTypeEnum.OUTCOME.getType())
                        .build();
                //插入账单
                esfHireBillService.addEsfHireBill(addEsfHireBillRequest1);
                if (roomHire.getDepositStatus().equals(DepositStatusEnum.ALREADY.getStatus())) {
                    //构建 退押金账单
                    AddEsfHireBillRequest addEsfHireBillRequest2 = AddEsfHireBillRequest.builder()
                            .hireId(roomHire.getId())
                            .balance(roomHire.getDeposit())
                            .billScene(BillSceneEnum.RETURN_DEPOSIT.getScene())
                            .billType(BillTypeEnum.OUTCOME.getType())
                            .build();
                    //插入账单
                    esfHireBillService.addEsfHireBill(addEsfHireBillRequest2);
                }

                cnt.set(cnt.get() + 1);
            }
        });

        return cnt.get();
    }

    /**
     * 删除房屋租赁信息
     *
     * @param id 房屋租赁主键
     * @return 结果
     */
    @Override
    public int deleteEsfRoomHireById(Long id) {
        return esfRoomHireMapper.deleteEsfRoomHireById(id);
    }
}

package com.esf.biz.service;

import java.util.List;

import com.esf.biz.domain.EsfRoomHire;
import com.esf.common.model.request.RoomHireRequest;

/**
 * 房屋租赁Service接口
 *
 * @author esf-manager
 * @date 2022-06-03
 */
public interface IEsfRoomHireService {
    /**
     * 查询房屋租赁
     *
     * @param id 房屋租赁主键
     * @return 房屋租赁
     */
    public EsfRoomHire selectEsfRoomHireById(Long id);

    /**
     * 查询房屋租赁列表
     *
     * @param esfRoomHire 房屋租赁
     * @return 房屋租赁集合
     */
    public List<EsfRoomHire> selectEsfRoomHireList(EsfRoomHire esfRoomHire);

    /**
     * 新增房屋租赁
     *
     * @param esfRoomHire 房屋租赁
     * @return 结果
     */
    public int insertEsfRoomHire(EsfRoomHire esfRoomHire);


    void hireRoom(RoomHireRequest request);

    /**
     * 修改房屋租赁
     *
     * @param esfRoomHire 房屋租赁
     * @return 结果
     */
    public int updateEsfRoomHire(EsfRoomHire esfRoomHire);

    /**
     * 批量删除房屋租赁
     *
     * @param ids 需要删除的房屋租赁主键集合
     * @return 结果
     */
    public int deleteEsfRoomHireByIds(Long[] ids);

    /**
     * 批量退租
     *
     * @param ids 需要退租的房屋租赁主键集合
     * @return
     */
    int retEsfRoomHireByIds(Long[] ids);

    /**
     * 删除房屋租赁信息
     *
     * @param id 房屋租赁主键
     * @return 结果
     */
    public int deleteEsfRoomHireById(Long id);
}

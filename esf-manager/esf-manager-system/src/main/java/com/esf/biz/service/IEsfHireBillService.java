package com.esf.biz.service;

import java.util.List;

import com.esf.biz.domain.EsfHireBill;
import com.esf.common.model.request.AddEsfHireBillRequest;

/**
 * 房屋租赁账单Service接口
 *
 * @author esf-manager
 * @date 2022-06-03
 */
public interface IEsfHireBillService {
    /**
     * 查询房屋租赁账单
     *
     * @param id 房屋租赁账单主键
     * @return 房屋租赁账单
     */
    public EsfHireBill selectEsfHireBillById(Long id);

    /**
     * 查询房屋租赁账单列表
     *
     * @param esfHireBill 房屋租赁账单
     * @return 房屋租赁账单集合
     */
    public List<EsfHireBill> selectEsfHireBillList(EsfHireBill esfHireBill);

    /**
     * 新增房屋租赁账单
     *
     * @param esfHireBill 房屋租赁账单
     * @return 结果
     */
    public int insertEsfHireBill(EsfHireBill esfHireBill);


    void addEsfHireBill(AddEsfHireBillRequest request);


    /**
     * 修改房屋租赁账单
     *
     * @param esfHireBill 房屋租赁账单
     * @return 结果
     */
    public int updateEsfHireBill(EsfHireBill esfHireBill);

    /**
     * 批量删除房屋租赁账单
     *
     * @param ids 需要删除的房屋租赁账单主键集合
     * @return 结果
     */
    public int deleteEsfHireBillByIds(Long[] ids);

    /**
     * 删除房屋租赁账单信息
     *
     * @param id 房屋租赁账单主键
     * @return 结果
     */
    public int deleteEsfHireBillById(Long id);


}

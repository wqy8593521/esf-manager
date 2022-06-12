package com.esf.biz.service;

import java.util.List;
import com.esf.biz.domain.EsfRoomRegion;

/**
 * 房屋区域Service接口
 * 
 * @author esf-manager
 * @date 2022-06-02
 */
public interface IEsfRoomRegionService 
{
    /**
     * 查询房屋区域
     * 
     * @param id 房屋区域主键
     * @return 房屋区域
     */
    public EsfRoomRegion selectEsfRoomRegionById(Long id);

    /**
     * 查询房屋区域列表
     * 
     * @param esfRoomRegion 房屋区域
     * @return 房屋区域集合
     */
    public List<EsfRoomRegion> selectEsfRoomRegionList(EsfRoomRegion esfRoomRegion);

    /**
     * 新增房屋区域
     * 
     * @param esfRoomRegion 房屋区域
     * @return 结果
     */
    public int insertEsfRoomRegion(EsfRoomRegion esfRoomRegion);

    /**
     * 修改房屋区域
     * 
     * @param esfRoomRegion 房屋区域
     * @return 结果
     */
    public int updateEsfRoomRegion(EsfRoomRegion esfRoomRegion);

    /**
     * 批量删除房屋区域
     * 
     * @param ids 需要删除的房屋区域主键集合
     * @return 结果
     */
    public int deleteEsfRoomRegionByIds(Long[] ids);

    /**
     * 删除房屋区域信息
     * 
     * @param id 房屋区域主键
     * @return 结果
     */
    public int deleteEsfRoomRegionById(Long id);
}

package com.esf.biz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esf.biz.mapper.EsfRoomRegionMapper;
import com.esf.biz.domain.EsfRoomRegion;
import com.esf.biz.service.IEsfRoomRegionService;

/**
 * 房屋区域Service业务层处理
 * 
 * @author esf-manager
 * @date 2022-06-02
 */
@Service
public class EsfRoomRegionServiceImpl implements IEsfRoomRegionService 
{
    @Autowired
    private EsfRoomRegionMapper esfRoomRegionMapper;

    /**
     * 查询房屋区域
     * 
     * @param id 房屋区域主键
     * @return 房屋区域
     */
    @Override
    public EsfRoomRegion selectEsfRoomRegionById(Long id)
    {
        return esfRoomRegionMapper.selectEsfRoomRegionById(id);
    }

    /**
     * 查询房屋区域列表
     * 
     * @param esfRoomRegion 房屋区域
     * @return 房屋区域
     */
    @Override
    public List<EsfRoomRegion> selectEsfRoomRegionList(EsfRoomRegion esfRoomRegion)
    {
        return esfRoomRegionMapper.selectEsfRoomRegionList(esfRoomRegion);
    }

    /**
     * 新增房屋区域
     * 
     * @param esfRoomRegion 房屋区域
     * @return 结果
     */
    @Override
    public int insertEsfRoomRegion(EsfRoomRegion esfRoomRegion)
    {
        return esfRoomRegionMapper.insert(esfRoomRegion);
    }

    /**
     * 修改房屋区域
     * 
     * @param esfRoomRegion 房屋区域
     * @return 结果
     */
    @Override
    public int updateEsfRoomRegion(EsfRoomRegion esfRoomRegion)
    {
        return esfRoomRegionMapper.updateById(esfRoomRegion);
    }

    /**
     * 批量删除房屋区域
     * 
     * @param ids 需要删除的房屋区域主键
     * @return 结果
     */
    @Override
    public int deleteEsfRoomRegionByIds(Long[] ids)
    {
        return esfRoomRegionMapper.deleteEsfRoomRegionByIds(ids);
    }

    /**
     * 删除房屋区域信息
     * 
     * @param id 房屋区域主键
     * @return 结果
     */
    @Override
    public int deleteEsfRoomRegionById(Long id)
    {
        return esfRoomRegionMapper.deleteEsfRoomRegionById(id);
    }
}

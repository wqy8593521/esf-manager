package com.esf.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esf.biz.mapper.EsfRoomHostMapper;
import com.esf.biz.domain.EsfRoomHost;
import com.esf.biz.service.IEsfRoomHostService;

/**
 * 房屋-房东关联Service业务层处理
 *
 * @author esf-manager
 * @date 2022-06-03
 */
@Service
public class EsfRoomHostServiceImpl implements IEsfRoomHostService {
    @Autowired
    private EsfRoomHostMapper esfRoomHostMapper;

    /**
     * 查询房屋-房东关联
     *
     * @param roomId 房屋-房东关联主键
     * @return 房屋-房东关联
     */
    @Override
    public List<EsfRoomHost> selectEsfRoomHostByRoomId(Long roomId) {
        return esfRoomHostMapper.selectEsfRoomHostByRoomId(roomId);
    }

    /**
     * 查询房屋-房东关联列表
     *
     * @param esfRoomHost 房屋-房东关联
     * @return 房屋-房东关联
     */
    @Override
    public List<EsfRoomHost> selectEsfRoomHostList(EsfRoomHost esfRoomHost) {
        return esfRoomHostMapper.selectEsfRoomHostList(esfRoomHost);
    }

    /**
     * 新增房屋-房东关联
     *
     * @param esfRoomHost 房屋-房东关联
     * @return 结果
     */
    @Override
    public int insertEsfRoomHost(EsfRoomHost esfRoomHost) {
        return esfRoomHostMapper.insert(esfRoomHost);
    }

    /**
     * 修改房屋-房东关联
     *
     * @param esfRoomHost 房屋-房东关联
     * @return 结果
     */
    @Override
    public int updateEsfRoomHost(EsfRoomHost esfRoomHost) {
        return esfRoomHostMapper.updateById(esfRoomHost);
    }

    /**
     * 批量删除房屋-房东关联
     *
     * @param roomIds 需要删除的房屋-房东关联主键
     * @return 结果
     */
    @Override
    public int deleteEsfRoomHostByRoomIds(Long[] roomIds) {
        return esfRoomHostMapper.deleteEsfRoomHostByRoomIds(roomIds);
    }

    /**
     * 删除房屋-房东关联信息
     *
     * @param roomId 房屋-房东关联主键
     * @return 结果
     */
    @Override
    public int deleteEsfRoomHostByRoomId(Long roomId) {
        return esfRoomHostMapper.deleteEsfRoomHostByRoomId(roomId);
    }
}

package com.esf.biz.service;

import java.util.List;

import com.esf.biz.domain.EsfRoomHost;

/**
 * 房屋-房东关联Service接口
 *
 * @author esf-manager
 * @date 2022-06-03
 */
public interface IEsfRoomHostService {
    /**
     * 查询房屋-房东关联
     *
     * @param roomId 房屋-房东关联主键
     * @return 房屋-房东关联
     */
    public List<EsfRoomHost> selectEsfRoomHostByRoomId(Long roomId);

    /**
     * 查询房屋-房东关联列表
     *
     * @param esfRoomHost 房屋-房东关联
     * @return 房屋-房东关联集合
     */
    public List<EsfRoomHost> selectEsfRoomHostList(EsfRoomHost esfRoomHost);

    /**
     * 新增房屋-房东关联
     *
     * @param esfRoomHost 房屋-房东关联
     * @return 结果
     */
    public int insertEsfRoomHost(EsfRoomHost esfRoomHost);

    /**
     * 修改房屋-房东关联
     *
     * @param esfRoomHost 房屋-房东关联
     * @return 结果
     */
    public int updateEsfRoomHost(EsfRoomHost esfRoomHost);

    /**
     * 批量删除房屋-房东关联
     *
     * @param roomIds 需要删除的房屋-房东关联主键集合
     * @return 结果
     */
    public int deleteEsfRoomHostByRoomIds(Long[] roomIds);

    /**
     * 删除房屋-房东关联信息
     *
     * @param roomId 房屋-房东关联主键
     * @return 结果
     */
    public int deleteEsfRoomHostByRoomId(Long roomId);
}

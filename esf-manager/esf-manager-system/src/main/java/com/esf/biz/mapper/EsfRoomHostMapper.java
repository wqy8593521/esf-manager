package com.esf.biz.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esf.biz.domain.EsfRoomHost;

/**
 * 房屋-房东关联Mapper接口
 *
 * @author esf-manager
 * @date 2022-06-03
 */
public interface EsfRoomHostMapper extends BaseMapper<EsfRoomHost> {
    /**
     * 查询房屋-房东关联
     *
     * @param roomId 房屋-房东关联主键
     * @return 房屋-房东关联
     */
    public List<EsfRoomHost> selectEsfRoomHostByRoomId(Long roomId);


    public List<EsfRoomHost> selectEsfRoomHostByHostId(Long hostId);

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
     * 删除房屋-房东关联
     *
     * @param roomId 房屋-房东关联主键
     * @return 结果
     */
    public int deleteEsfRoomHostByRoomId(Long roomId);

    /**
     * 批量删除房屋-房东关联
     *
     * @param roomIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEsfRoomHostByRoomIds(Long[] roomIds);
}

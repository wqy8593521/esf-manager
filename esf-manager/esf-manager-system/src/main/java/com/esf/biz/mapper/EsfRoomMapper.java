package com.esf.biz.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esf.biz.domain.EsfRoom;
import com.esf.common.model.request.RoomEditRequest;
import com.esf.common.model.response.RoomInfoResponse;

/**
 * 房源信息Mapper接口
 * 
 * @author esf-manager
 * @date 2022-06-02
 */
public interface EsfRoomMapper extends BaseMapper<EsfRoom>
{
    /**
     * 查询房源信息
     * 
     * @param id 房源信息主键
     * @return 房源信息
     */
    public EsfRoom selectEsfRoomById(Long id);

    /**
     * 查询房源信息列表
     * 
     * @param esfRoom 房源信息
     * @return 房源信息集合
     */
    public List<EsfRoom> selectEsfRoomList(EsfRoom esfRoom);

    /**
     * 新增房源信息
     * 
     * @param esfRoom 房源信息
     * @return 结果
     */
    public int insertEsfRoom(RoomEditRequest esfRoom);

    /**
     * 修改房源信息
     * 
     * @param esfRoom 房源信息
     * @return 结果
     */
    public int updateEsfRoom(RoomEditRequest esfRoom);

    /**
     * 删除房源信息
     * 
     * @param id 房源信息主键
     * @return 结果
     */
    public int deleteEsfRoomById(Long id);

    /**
     * 批量删除房源信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEsfRoomByIds(Long[] ids);
}

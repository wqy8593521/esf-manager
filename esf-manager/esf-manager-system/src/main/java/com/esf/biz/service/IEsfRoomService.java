package com.esf.biz.service;

import java.util.List;

import com.esf.biz.domain.EsfRoom;
import com.esf.common.model.request.RoomEditRequest;
import com.esf.common.model.response.RoomInfoResponse;

/**
 * 房源信息Service接口
 *
 * @author esf-manager
 * @date 2022-06-02
 */
public interface IEsfRoomService {
    /**
     * 查询房源信息
     *
     * @param id 房源信息主键
     * @return 房源信息
     */
    public RoomInfoResponse selectEsfRoomById(Long id);

    /**
     * 查询房源信息列表
     *
     * @param esfRoom 房源信息
     * @return 房源信息集合
     */
    public List<RoomInfoResponse> selectEsfRoomList(EsfRoom esfRoom);

    /**
     * 新增房源信息
     *
     * @param request@return 结果
     */
    public int insertEsfRoom(RoomEditRequest request);

    /**
     * 修改房源信息
     *
     * @param request 房源信息
     * @return 结果
     */
    public int updateEsfRoom(RoomEditRequest request);

    public void updateEsfRoom(EsfRoom room);


    /**
     * 批量删除房源信息
     *
     * @param ids 需要删除的房源信息主键集合
     * @return 结果
     */
    public int deleteEsfRoomByIds(Long[] ids);

    /**
     * 删除房源信息信息
     *
     * @param id 房源信息主键
     * @return 结果
     */
    public int deleteEsfRoomById(Long id);
}

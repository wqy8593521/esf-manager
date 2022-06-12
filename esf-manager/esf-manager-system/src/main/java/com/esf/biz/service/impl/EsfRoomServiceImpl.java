package com.esf.biz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.esf.biz.domain.EsfRoomHost;
import com.esf.biz.service.IEsfRoomHostService;
import com.esf.common.model.request.RoomEditRequest;
import com.esf.common.model.response.RoomInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import com.esf.biz.mapper.EsfRoomMapper;
import com.esf.biz.domain.EsfRoom;
import com.esf.biz.service.IEsfRoomService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 房源信息Service业务层处理
 *
 * @author esf-manager
 * @date 2022-06-02
 */
@Service
public class EsfRoomServiceImpl implements IEsfRoomService {
    @Autowired
    private EsfRoomMapper esfRoomMapper;

    @Resource
    private IEsfRoomHostService esfRoomHostService;

    /**
     * 查询房源信息
     *
     * @param id 房源信息主键
     * @return 房源信息
     */
    @Override
    public RoomInfoResponse selectEsfRoomById(Long id) {

        EsfRoom esfRoom = esfRoomMapper.selectEsfRoomById(id);
        List<EsfRoomHost> esfRoomHosts = esfRoomHostService.selectEsfRoomHostByRoomId(id);
        List<Long> collect = esfRoomHosts.stream().map(EsfRoomHost::getHostId).collect(Collectors.toList());

        return RoomInfoResponse.builder()
                .hostList(collect)
                .id(esfRoom.getId())
                .roomCapacity(esfRoom.getRoomCapacity())
                .roomCost(esfRoom.getRoomCost())
                .roomName(esfRoom.getRoomName())
                .roomPic(esfRoom.getRoomPic())
                .roomSpec(esfRoom.getRoomSpec())
                .roomStatus(esfRoom.getRoomStatus())
                .roomType(esfRoom.getRoomType())
                .regionId(esfRoom.getRegionId())
                .build();
    }

    /**
     * 查询房源信息列表
     *
     * @param esfRoom 房源信息
     * @return 房源信息
     */
    @Override
    public List<RoomInfoResponse> selectEsfRoomList(EsfRoom esfRoom) {

        List<EsfRoom> esfRooms = esfRoomMapper.selectEsfRoomList(esfRoom);
        List<RoomInfoResponse> list = new ArrayList<>();
        esfRooms.forEach(item -> {
            List<EsfRoomHost> hostList = esfRoomHostService.selectEsfRoomHostByRoomId(item.getId());
            List<Long> collect = new ArrayList<>();
            if (hostList != null) {
                collect = hostList.stream().map(EsfRoomHost::getHostId).collect(Collectors.toList());
            }
            RoomInfoResponse build = RoomInfoResponse.builder()
                    .id(item.getId())
                    .regionId(item.getRegionId())
                    .roomType(item.getRoomType())
                    .roomStatus(item.getRoomStatus())
                    .roomSpec(item.getRoomSpec())
                    .roomPic(item.getRoomPic())
                    .roomName(item.getRoomName())
                    .roomCost(item.getRoomCost())
                    .roomCapacity(item.getRoomCapacity())
                    .hostList(collect)
                    .build();
            list.add(build);
        });
        return list;
    }

    /**
     * 新增房源信息
     *
     * @return 结果
     */
    @Override
    @Transactional
    public int insertEsfRoom(RoomEditRequest request) {

        int esfRoom = esfRoomMapper.insertEsfRoom(request);
        List<Long> hostList = request.getHostList();
        for (Long item : hostList) {
            EsfRoomHost esfRoomHost = new EsfRoomHost();
            esfRoomHost.setRoomId(request.getId());
            esfRoomHost.setHostId(item);
            esfRoomHostService.insertEsfRoomHost(esfRoomHost);
        }
        return esfRoom;
    }

    /**
     * 修改房源信息
     *
     * @param request 房源信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateEsfRoom(RoomEditRequest request) {

        esfRoomHostService.deleteEsfRoomHostByRoomId(request.getId());
        List<Long> hostList = request.getHostList();
        for (Long item : hostList) {
            EsfRoomHost esfRoomHost = new EsfRoomHost();
            esfRoomHost.setRoomId(request.getId());
            esfRoomHost.setHostId(item);
            esfRoomHostService.insertEsfRoomHost(esfRoomHost);
        }
        return esfRoomMapper.updateEsfRoom(request);
    }

    @Override
    public void updateEsfRoom(EsfRoom room) {

        esfRoomMapper.updateById(room);
    }

    /**
     * 批量删除房源信息
     *
     * @param ids 需要删除的房源信息主键
     * @return 结果
     */
    @Override
    public int deleteEsfRoomByIds(Long[] ids) {
        return esfRoomMapper.deleteEsfRoomByIds(ids);
    }

    /**
     * 删除房源信息信息
     *
     * @param id 房源信息主键
     * @return 结果
     */
    @Override
    public int deleteEsfRoomById(Long id) {
        return esfRoomMapper.deleteEsfRoomById(id);
    }
}

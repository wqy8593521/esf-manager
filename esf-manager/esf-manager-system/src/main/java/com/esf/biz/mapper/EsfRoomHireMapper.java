package com.esf.biz.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esf.biz.domain.EsfRoomHire;

/**
 * 房屋租赁Mapper接口
 *
 * @author esf-manager
 * @date 2022-06-03
 */
public interface EsfRoomHireMapper extends BaseMapper<EsfRoomHire> {
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

    /**
     * 修改房屋租赁
     *
     * @param esfRoomHire 房屋租赁
     * @return 结果
     */
    public int updateEsfRoomHire(EsfRoomHire esfRoomHire);

    /**
     * 删除房屋租赁
     *
     * @param id 房屋租赁主键
     * @return 结果
     */
    public int deleteEsfRoomHireById(Long id);

    /**
     * 批量删除房屋租赁
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEsfRoomHireByIds(Long[] ids);
}

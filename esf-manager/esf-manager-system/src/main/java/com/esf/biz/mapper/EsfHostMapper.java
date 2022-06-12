package com.esf.biz.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esf.biz.domain.EsfHost;

/**
 * 房东信息Mapper接口
 * 
 * @author esf-manager
 * @date 2022-06-03
 */
public interface EsfHostMapper  extends BaseMapper<EsfHost>
{
    /**
     * 查询房东信息
     * 
     * @param id 房东信息主键
     * @return 房东信息
     */
    public EsfHost selectEsfHostById(Long id);

    /**
     * 查询房东信息列表
     * 
     * @param esfHost 房东信息
     * @return 房东信息集合
     */
    public List<EsfHost> selectEsfHostList(EsfHost esfHost);

    /**
     * 新增房东信息
     * 
     * @param esfHost 房东信息
     * @return 结果
     */
    public int insertEsfHost(EsfHost esfHost);

    /**
     * 修改房东信息
     * 
     * @param esfHost 房东信息
     * @return 结果
     */
    public int updateEsfHost(EsfHost esfHost);

    /**
     * 删除房东信息
     * 
     * @param id 房东信息主键
     * @return 结果
     */
    public int deleteEsfHostById(Long id);

    /**
     * 批量删除房东信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEsfHostByIds(Long[] ids);
}

package com.esf.biz.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esf.biz.domain.EsfTenant;

/**
 * 租客信息Mapper接口
 * 
 * @author esf-manager
 * @date 2022-06-03
 */
public interface EsfTenantMapper  extends BaseMapper<EsfTenant>
{
    /**
     * 查询租客信息
     * 
     * @param id 租客信息主键
     * @return 租客信息
     */
    public EsfTenant selectEsfTenantById(Long id);

    /**
     * 查询租客信息列表
     * 
     * @param esfTenant 租客信息
     * @return 租客信息集合
     */
    public List<EsfTenant> selectEsfTenantList(EsfTenant esfTenant);

    /**
     * 新增租客信息
     * 
     * @param esfTenant 租客信息
     * @return 结果
     */
    public int insertEsfTenant(EsfTenant esfTenant);

    /**
     * 修改租客信息
     * 
     * @param esfTenant 租客信息
     * @return 结果
     */
    public int updateEsfTenant(EsfTenant esfTenant);

    /**
     * 删除租客信息
     * 
     * @param id 租客信息主键
     * @return 结果
     */
    public int deleteEsfTenantById(Long id);

    /**
     * 批量删除租客信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEsfTenantByIds(Long[] ids);
}

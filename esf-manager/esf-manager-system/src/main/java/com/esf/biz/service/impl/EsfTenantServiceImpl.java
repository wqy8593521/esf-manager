package com.esf.biz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esf.biz.mapper.EsfTenantMapper;
import com.esf.biz.domain.EsfTenant;
import com.esf.biz.service.IEsfTenantService;

/**
 * 租客信息Service业务层处理
 * 
 * @author esf-manager
 * @date 2022-06-03
 */
@Service
public class EsfTenantServiceImpl implements IEsfTenantService 
{
    @Autowired
    private EsfTenantMapper esfTenantMapper;

    /**
     * 查询租客信息
     * 
     * @param id 租客信息主键
     * @return 租客信息
     */
    @Override
    public EsfTenant selectEsfTenantById(Long id)
    {
        return esfTenantMapper.selectEsfTenantById(id);
    }

    /**
     * 查询租客信息列表
     * 
     * @param esfTenant 租客信息
     * @return 租客信息
     */
    @Override
    public List<EsfTenant> selectEsfTenantList(EsfTenant esfTenant)
    {
        return esfTenantMapper.selectEsfTenantList(esfTenant);
    }

    /**
     * 新增租客信息
     * 
     * @param esfTenant 租客信息
     * @return 结果
     */
    @Override
    public int insertEsfTenant(EsfTenant esfTenant)
    {
        return esfTenantMapper.insert(esfTenant);
    }

    /**
     * 修改租客信息
     * 
     * @param esfTenant 租客信息
     * @return 结果
     */
    @Override
    public int updateEsfTenant(EsfTenant esfTenant)
    {
        return esfTenantMapper.updateById(esfTenant);
    }

    /**
     * 批量删除租客信息
     * 
     * @param ids 需要删除的租客信息主键
     * @return 结果
     */
    @Override
    public int deleteEsfTenantByIds(Long[] ids)
    {
        return esfTenantMapper.deleteEsfTenantByIds(ids);
    }

    /**
     * 删除租客信息信息
     * 
     * @param id 租客信息主键
     * @return 结果
     */
    @Override
    public int deleteEsfTenantById(Long id)
    {
        return esfTenantMapper.deleteEsfTenantById(id);
    }
}

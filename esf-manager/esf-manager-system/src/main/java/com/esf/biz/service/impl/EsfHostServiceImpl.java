package com.esf.biz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esf.biz.mapper.EsfHostMapper;
import com.esf.biz.domain.EsfHost;
import com.esf.biz.service.IEsfHostService;

/**
 * 房东信息Service业务层处理
 * 
 * @author esf-manager
 * @date 2022-06-03
 */
@Service
public class EsfHostServiceImpl implements IEsfHostService 
{
    @Autowired
    private EsfHostMapper esfHostMapper;

    /**
     * 查询房东信息
     * 
     * @param id 房东信息主键
     * @return 房东信息
     */
    @Override
    public EsfHost selectEsfHostById(Long id)
    {
        return esfHostMapper.selectEsfHostById(id);
    }

    /**
     * 查询房东信息列表
     * 
     * @param esfHost 房东信息
     * @return 房东信息
     */
    @Override
    public List<EsfHost> selectEsfHostList(EsfHost esfHost)
    {
        return esfHostMapper.selectEsfHostList(esfHost);
    }

    @Override
    public List<EsfHost> selectEsfHostList(List<Long> ids) {
        return  esfHostMapper.selectBatchIds(ids);
    }

    /**
     * 新增房东信息
     * 
     * @param esfHost 房东信息
     * @return 结果
     */
    @Override
    public int insertEsfHost(EsfHost esfHost)
    {
        return esfHostMapper.insert(esfHost);
    }

    /**
     * 修改房东信息
     * 
     * @param esfHost 房东信息
     * @return 结果
     */
    @Override
    public int updateEsfHost(EsfHost esfHost)
    {
        return esfHostMapper.updateById(esfHost);
    }

    /**
     * 批量删除房东信息
     * 
     * @param ids 需要删除的房东信息主键
     * @return 结果
     */
    @Override
    public int deleteEsfHostByIds(Long[] ids)
    {
        return esfHostMapper.deleteEsfHostByIds(ids);
    }

    /**
     * 删除房东信息信息
     * 
     * @param id 房东信息主键
     * @return 结果
     */
    @Override
    public int deleteEsfHostById(Long id)
    {
        return esfHostMapper.deleteEsfHostById(id);
    }
}

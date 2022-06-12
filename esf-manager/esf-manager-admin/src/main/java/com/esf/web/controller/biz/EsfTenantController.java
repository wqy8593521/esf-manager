package com.esf.web.controller.biz;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.esf.common.annotation.Log;
import com.esf.common.core.controller.BaseController;
import com.esf.common.core.domain.AjaxResult;
import com.esf.common.enums.BusinessType;
import com.esf.biz.domain.EsfTenant;
import com.esf.biz.service.IEsfTenantService;
import com.esf.common.utils.poi.ExcelUtil;
import com.esf.common.core.page.TableDataInfo;

/**
 * 租客信息Controller
 * 
 * @author esf-manager
 * @date 2022-06-03
 */
@RestController
@RequestMapping("/biz/tenant")
public class EsfTenantController extends BaseController
{
    @Autowired
    private IEsfTenantService esfTenantService;

    /**
     * 查询租客信息列表
     */
    @PreAuthorize("@ss.hasPermi('biz:tenant:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsfTenant esfTenant)
    {
        startPage();
        List<EsfTenant> list = esfTenantService.selectEsfTenantList(esfTenant);
        return getDataTable(list);
    }

    /**
     * 导出租客信息列表
     */
    @PreAuthorize("@ss.hasPermi('biz:tenant:export')")
    @Log(title = "租客信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsfTenant esfTenant)
    {
        List<EsfTenant> list = esfTenantService.selectEsfTenantList(esfTenant);
        ExcelUtil<EsfTenant> util = new ExcelUtil<EsfTenant>(EsfTenant.class);
        util.exportExcel(response, list, "租客信息数据");
    }

    /**
     * 获取租客信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:tenant:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(esfTenantService.selectEsfTenantById(id));
    }

    /**
     * 新增租客信息
     */
    @PreAuthorize("@ss.hasPermi('biz:tenant:add')")
    @Log(title = "租客信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsfTenant esfTenant)
    {
        return toAjax(esfTenantService.insertEsfTenant(esfTenant));
    }

    /**
     * 修改租客信息
     */
    @PreAuthorize("@ss.hasPermi('biz:tenant:edit')")
    @Log(title = "租客信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsfTenant esfTenant)
    {
        return toAjax(esfTenantService.updateEsfTenant(esfTenant));
    }

    /**
     * 删除租客信息
     */
    @PreAuthorize("@ss.hasPermi('biz:tenant:remove')")
    @Log(title = "租客信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(esfTenantService.deleteEsfTenantByIds(ids));
    }
}

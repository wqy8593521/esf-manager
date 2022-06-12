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
import com.esf.biz.domain.EsfHost;
import com.esf.biz.service.IEsfHostService;
import com.esf.common.utils.poi.ExcelUtil;
import com.esf.common.core.page.TableDataInfo;

/**
 * 房东信息Controller
 *
 * @author esf-manager
 * @date 2022-06-03
 */
@RestController
@RequestMapping("/biz/host")
public class EsfHostController extends BaseController {
    @Autowired
    private IEsfHostService esfHostService;

    /**
     * 查询房东信息列表
     */
    @PreAuthorize("@ss.hasPermi('biz:host:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsfHost esfHost) {
        startPage();
        List<EsfHost> list = esfHostService.selectEsfHostList(esfHost);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('biz:host:list:ids')")
    @GetMapping("/list/{ids}")
    public TableDataInfo list(@PathVariable List<Long> ids) {
        startPage();
        List<EsfHost> list = esfHostService.selectEsfHostList(ids);
        return getDataTable(list);
    }


    /**
     * 导出房东信息列表
     */
    @PreAuthorize("@ss.hasPermi('biz:host:export')")
    @Log(title = "房东信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsfHost esfHost) {
        List<EsfHost> list = esfHostService.selectEsfHostList(esfHost);
        ExcelUtil<EsfHost> util = new ExcelUtil<EsfHost>(EsfHost.class);
        util.exportExcel(response, list, "房东信息数据");
    }

    /**
     * 获取房东信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:host:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(esfHostService.selectEsfHostById(id));
    }

    /**
     * 新增房东信息
     */
    @PreAuthorize("@ss.hasPermi('biz:host:add')")
    @Log(title = "房东信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsfHost esfHost) {
        return toAjax(esfHostService.insertEsfHost(esfHost));
    }

    /**
     * 修改房东信息
     */
    @PreAuthorize("@ss.hasPermi('biz:host:edit')")
    @Log(title = "房东信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsfHost esfHost) {
        return toAjax(esfHostService.updateEsfHost(esfHost));
    }

    /**
     * 删除房东信息
     */
    @PreAuthorize("@ss.hasPermi('biz:host:remove')")
    @Log(title = "房东信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(esfHostService.deleteEsfHostByIds(ids));
    }
}

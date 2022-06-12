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
import com.esf.biz.domain.EsfRoomRegion;
import com.esf.biz.service.IEsfRoomRegionService;
import com.esf.common.utils.poi.ExcelUtil;
import com.esf.common.core.page.TableDataInfo;

/**
 * 房屋区域Controller
 * 
 * @author esf-manager
 * @date 2022-06-02
 */
@RestController
@RequestMapping("/biz/region")
public class EsfRoomRegionController extends BaseController
{
    @Autowired
    private IEsfRoomRegionService esfRoomRegionService;

    /**
     * 查询房屋区域列表
     */
    @PreAuthorize("@ss.hasPermi('biz:region:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsfRoomRegion esfRoomRegion)
    {
        startPage();
        List<EsfRoomRegion> list = esfRoomRegionService.selectEsfRoomRegionList(esfRoomRegion);
        return getDataTable(list);
    }

    /**
     * 导出房屋区域列表
     */
    @PreAuthorize("@ss.hasPermi('biz:region:export')")
    @Log(title = "房屋区域", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsfRoomRegion esfRoomRegion)
    {
        List<EsfRoomRegion> list = esfRoomRegionService.selectEsfRoomRegionList(esfRoomRegion);
        ExcelUtil<EsfRoomRegion> util = new ExcelUtil<EsfRoomRegion>(EsfRoomRegion.class);
        util.exportExcel(response, list, "房屋区域数据");
    }

    /**
     * 获取房屋区域详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:region:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(esfRoomRegionService.selectEsfRoomRegionById(id));
    }

    /**
     * 新增房屋区域
     */
    @PreAuthorize("@ss.hasPermi('biz:region:add')")
    @Log(title = "房屋区域", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsfRoomRegion esfRoomRegion)
    {
        return toAjax(esfRoomRegionService.insertEsfRoomRegion(esfRoomRegion));
    }

    /**
     * 修改房屋区域
     */
    @PreAuthorize("@ss.hasPermi('biz:region:edit')")
    @Log(title = "房屋区域", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsfRoomRegion esfRoomRegion)
    {
        return toAjax(esfRoomRegionService.updateEsfRoomRegion(esfRoomRegion));
    }

    /**
     * 删除房屋区域
     */
    @PreAuthorize("@ss.hasPermi('biz:region:remove')")
    @Log(title = "房屋区域", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(esfRoomRegionService.deleteEsfRoomRegionByIds(ids));
    }
}

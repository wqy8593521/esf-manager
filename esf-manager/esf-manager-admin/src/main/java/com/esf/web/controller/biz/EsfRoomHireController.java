package com.esf.web.controller.biz;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.esf.common.model.request.RoomHireRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
import com.esf.biz.domain.EsfRoomHire;
import com.esf.biz.service.IEsfRoomHireService;
import com.esf.common.utils.poi.ExcelUtil;
import com.esf.common.core.page.TableDataInfo;

/**
 * 房屋租赁Controller
 *
 * @author esf-manager
 * @date 2022-06-03
 */
@RestController
@Validated
@RequestMapping("/biz/hire")
public class EsfRoomHireController extends BaseController {
    @Autowired
    private IEsfRoomHireService esfRoomHireService;

    /**
     * 查询房屋租赁列表
     */
    @PreAuthorize("@ss.hasPermi('biz:hire:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsfRoomHire esfRoomHire) {
        startPage();
        List<EsfRoomHire> list = esfRoomHireService.selectEsfRoomHireList(esfRoomHire);
        return getDataTable(list);
    }

    /**
     * 导出房屋租赁列表
     */
    @PreAuthorize("@ss.hasPermi('biz:hire:export')")
    @Log(title = "房屋租赁", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsfRoomHire esfRoomHire) {
        List<EsfRoomHire> list = esfRoomHireService.selectEsfRoomHireList(esfRoomHire);
        ExcelUtil<EsfRoomHire> util = new ExcelUtil<EsfRoomHire>(EsfRoomHire.class);
        util.exportExcel(response, list, "房屋租赁数据");
    }

    /**
     * 获取房屋租赁详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:hire:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(esfRoomHireService.selectEsfRoomHireById(id));
    }

    /**
     * 新增房屋租赁
     */
    @PreAuthorize("@ss.hasPermi('biz:hire:add')")
    @Log(title = "房屋租赁", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsfRoomHire esfRoomHire) {
        return toAjax(esfRoomHireService.insertEsfRoomHire(esfRoomHire));
    }

    @PreAuthorize("@ss.hasPermi('biz:hire:hire')")
    @Log(title = "房屋租赁", businessType = BusinessType.INSERT)
    @PostMapping("hire-room")
    public AjaxResult hireRoom(@Valid @RequestBody RoomHireRequest request) {
        esfRoomHireService.hireRoom(request);
        return AjaxResult.success();
    }

    /**
     * 修改房屋租赁
     */
    @PreAuthorize("@ss.hasPermi('biz:hire:edit')")
    @Log(title = "房屋租赁", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsfRoomHire esfRoomHire) {
        return toAjax(esfRoomHireService.updateEsfRoomHire(esfRoomHire));
    }

    /**
     * 删除房屋租赁
     */
    @PreAuthorize("@ss.hasPermi('biz:hire:remove')")
    @Log(title = "房屋租赁", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(esfRoomHireService.deleteEsfRoomHireByIds(ids));
    }

    /**
     * 退租房屋租赁
     */
    @PreAuthorize("@ss.hasPermi('biz:hire:ret')")
    @Log(title = "房屋租赁", businessType = BusinessType.DELETE)
    @DeleteMapping("/ret/{ids}")
    public AjaxResult ret(@PathVariable Long[] ids) {
        return toAjax(esfRoomHireService.retEsfRoomHireByIds(ids));
    }
}

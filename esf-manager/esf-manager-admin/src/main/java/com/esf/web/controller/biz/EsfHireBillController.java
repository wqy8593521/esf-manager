package com.esf.web.controller.biz;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.esf.common.model.request.AddEsfHireBillRequest;
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
import com.esf.biz.domain.EsfHireBill;
import com.esf.biz.service.IEsfHireBillService;
import com.esf.common.utils.poi.ExcelUtil;
import com.esf.common.core.page.TableDataInfo;

/**
 * 房屋租赁账单Controller
 *
 * @author esf-manager
 * @date 2022-06-03
 */
@RestController
@RequestMapping("/biz/bill")
@Validated
public class EsfHireBillController extends BaseController {
    @Autowired
    private IEsfHireBillService esfHireBillService;

    /**
     * 查询房屋租赁账单列表
     */
    @PreAuthorize("@ss.hasPermi('biz:bill:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsfHireBill esfHireBill) {
        startPage();
        List<EsfHireBill> list = esfHireBillService.selectEsfHireBillList(esfHireBill);
        return getDataTable(list);
    }

    /**
     * 导出房屋租赁账单列表
     */
    @PreAuthorize("@ss.hasPermi('biz:bill:export')")
    @Log(title = "房屋租赁账单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsfHireBill esfHireBill) {
        List<EsfHireBill> list = esfHireBillService.selectEsfHireBillList(esfHireBill);
        ExcelUtil<EsfHireBill> util = new ExcelUtil<EsfHireBill>(EsfHireBill.class);
        util.exportExcel(response, list, "房屋租赁账单数据");
    }

    /**
     * 获取房屋租赁账单详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:bill:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(esfHireBillService.selectEsfHireBillById(id));
    }

    /**
     * 新增房屋租赁账单
     */
    @PreAuthorize("@ss.hasPermi('biz:bill:add')")
    @Log(title = "房屋租赁账单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Valid @RequestBody AddEsfHireBillRequest request) {
        esfHireBillService.addEsfHireBill(request);
        return AjaxResult.success();
    }



    /**
     * 修改房屋租赁账单
     */
    @PreAuthorize("@ss.hasPermi('biz:bill:edit')")
    @Log(title = "房屋租赁账单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsfHireBill esfHireBill) {
        return toAjax(esfHireBillService.updateEsfHireBill(esfHireBill));
    }

    /**
     * 删除房屋租赁账单
     */
    @PreAuthorize("@ss.hasPermi('biz:bill:remove')")
    @Log(title = "房屋租赁账单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(esfHireBillService.deleteEsfHireBillByIds(ids));
    }
}

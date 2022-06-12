package com.esf.web.controller.biz;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.esf.biz.domain.EsfRoom;
import com.esf.biz.service.IEsfRoomService;
import com.esf.common.model.request.RoomEditRequest;
import com.esf.common.model.response.RoomInfoResponse;
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

import com.esf.common.utils.poi.ExcelUtil;
import com.esf.common.core.page.TableDataInfo;

/**
 * 房源信息Controller
 *
 * @author esf-manager
 * @date 2022-06-02
 */
@RestController
@RequestMapping("/biz/room")
public class EsfRoomController extends BaseController {
    @Autowired
    private IEsfRoomService esfRoomService;

    /**
     * 查询房源信息列表
     */
    @PreAuthorize("@ss.hasPermi('biz:room:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsfRoom esfRoom) {
        startPage();
        List<RoomInfoResponse> list = esfRoomService.selectEsfRoomList(esfRoom);
        return getDataTable(list);
    }

    /**
     * 导出房源信息列表
     */
    @PreAuthorize("@ss.hasPermi('biz:room:export')")
    @Log(title = "房源信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsfRoom esfRoom) {
        List<RoomInfoResponse> list = esfRoomService.selectEsfRoomList(esfRoom);
        ExcelUtil<RoomInfoResponse> util = new ExcelUtil<RoomInfoResponse>(RoomInfoResponse.class);
        util.exportExcel(response, list, "房源信息数据");
    }

    /**
     * 获取房源信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:room:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(esfRoomService.selectEsfRoomById(id));
    }

    /**
     * 新增房源信息
     */
    @PreAuthorize("@ss.hasPermi('biz:room:add')")
    @Log(title = "房源信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RoomEditRequest request) {
        return toAjax(esfRoomService.insertEsfRoom(request));
    }

    /**
     * 修改房源信息
     */
    @PreAuthorize("@ss.hasPermi('biz:room:edit')")
    @Log(title = "房源信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RoomEditRequest request) {
        return toAjax(esfRoomService.updateEsfRoom(request));
    }

    /**
     * 删除房源信息
     */
    @PreAuthorize("@ss.hasPermi('biz:room:remove')")
    @Log(title = "房源信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(esfRoomService.deleteEsfRoomByIds(ids));
    }
}

package cn.itcast.controller.cargo;

import cn.itcast.controller.BaseController;
import cn.itcast.domain.cargo.*;
import cn.itcast.service.cargo.ExportService;
import cn.itcast.service.cargo.PackingService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.UUID;

//装箱
@Controller
@RequestMapping("/cargo/packing")
public class PackingController extends BaseController {

    @Reference
    private PackingService packingService;
    @Reference
    private ExportService exportService;

    @RequestMapping(value = "/list", name = "装箱管理")
    public String list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageInfo pageInfo = packingService.findAll(page, size, getCompanyId());
        request.setAttribute("page",pageInfo);
        return "cargo/packing/packing-list";
    }

    @RequestMapping(value = "/toAdd",name = "进入新增装箱单页面")
    public String toAdd(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageInfo pageInfo = exportService.findByState(page, size, 2, getCompanyId());
        request.setAttribute("page",pageInfo);
        return "cargo/packing/packing-add";
    }

    @RequestMapping(value = "/toUpdate",name = "新增/更新装箱单")
    public String edit(String packingListId) {
        Packing packing = packingService.findById(packingListId);
        request.setAttribute("packing",packing);
        return "cargo/packing/packing-update";
    }

    @RequestMapping(value = "/edit",name = "新增/更新装箱单")
    public String edit(Packing packing,String exportId) {
        if (StringUtils.isEmpty(packing.getPackingListId())) {
            Export export = exportService.findById(exportId);
            packing.setPackingListId(UUID.randomUUID().toString());
            packing.setCreateTime(new Date());
            packing.setCompanyId(getCompanyId());
            packing.setCompanyName(getCompanyName());
            packing.setCreateBy(getUser().getId());
            packing.setCreateDept(getUser().getDeptId());
            packing.setExportId(exportId);//报运单ID
            packing.setMarks(export.getMarks());//唛头
            packing.setState(0);//草稿
            //修改
            packingService.save(packing);
        } else {
            packingService.update(packing);
        }
        return "redirect:/cargo/packing/list.do";
    }

    @RequestMapping(value = "/submit",name = "提交装箱单")
    public String submit(String id) {
        //修改装箱单的ID
        packingService.submit(id);
        return "redirect:/cargo/packing/list.do";
    }

    @RequestMapping(value = "/cancel",name = "取消装箱单")
    public String cancel(String id) {
        packingService.cancel(id);
        return "redirect:/cargo/packing/list.do";
    }

    @RequestMapping(value = "/delete",name = "删除装箱单")
    public String delete(String id) {
        packingService.delete(id);
        return "redirect:/cargo/packing/list.do";
    }
}

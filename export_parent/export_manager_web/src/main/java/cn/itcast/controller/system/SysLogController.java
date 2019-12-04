package cn.itcast.controller.system;

import cn.itcast.controller.BaseController;
import cn.itcast.service.system.SysLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/system/log")
public class SysLogController extends BaseController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping(value = "/list" ,name = "展示日志列表数据")
    public String findAll(@RequestParam(name="page" ,defaultValue = "1") int pageNum, @RequestParam(name="pageSize" ,defaultValue = "10")int pageSize){
        PageInfo page = sysLogService.findPage(getCompanyId(),pageNum,pageSize);
        request.setAttribute("page",page);
        return "system/log/log-list";
    }

}

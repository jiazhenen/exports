package cn.itcast.controller.stat;

import cn.itcast.controller.BaseController;
import cn.itcast.service.stat.StatService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stat")
public class StatController extends BaseController {

    @Reference
    private StatService statService;

    @RequestMapping(value = "/toCharts",name = "跳转到统计页面")
    public String toCharts(String chartsType){
//        sell factory online
        return "stat/stat-"+chartsType;
    }

    @RequestMapping(value = "/factoryCharts",name = "每个厂家的销售金额统计")
    @ResponseBody
    public List<Map> factoryCharts(){
//        [{name:AA,value:1},{name:BB,value:12}]
//        sell factory online
        return statService.factoryCharts(getCompanyId());

    }
    @RequestMapping(value = "/sellCharts",name = "每种产品（货物）销售量统计")
    @ResponseBody
    public List<Map> sellCharts(){
        return statService.sellCharts(getCompanyId());
    }
    @RequestMapping(value = "/onlineCharts",name = "统计24小时系统访问量")
    @ResponseBody
    public List<Map> onlineCharts(){
//        [{name:AA,value:1},{name:BB,value:12}]
//        sell factory online
        return statService.onlineCharts(getCompanyId());

    }
}

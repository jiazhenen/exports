package cn.itcast.controller.cargo;

import cn.itcast.controller.BaseController;

import cn.itcast.domain.cargo.ContractExample;
import cn.itcast.domain.cargo.Export;
import cn.itcast.domain.cargo.ExportExample;
import cn.itcast.domain.cargo.ExportProduct;
import cn.itcast.domain.system.User;
import cn.itcast.service.cargo.ContractService;
import cn.itcast.service.cargo.ExportProductService;
import cn.itcast.service.cargo.ExportService;
import cn.itcast.vo.ExportProductVo;
import cn.itcast.vo.ExportResult;
import cn.itcast.vo.ExportVo;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/cargo/export")
public class ExportController extends BaseController {

    @Reference
    private ContractService contractService;

    @Reference
    private ExportService exportService;

    @Reference
    private ExportProductService exportProductService;

    @RequestMapping(value = "/contractList", name = "合同管理页面")
    public String contractList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        //获取当前登录人
        User user = getUser();
        //当前登录人等级
        // 1-企业管理员
        // 2-管理所有下属部门和人员
        // 3-管理本部门
        // 4-普通员工
        Integer degree = user.getDegree();
        ContractExample example = new ContractExample();
        ContractExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(1);
        if (degree == 4) {
            criteria.andCreateByEqualTo(user.getId());
        } else if (degree == 3) {
            criteria.andCreateDeptEqualTo(user.getDeptId());
        } else if (degree == 2) {
            //管理所有下属部门和人员，可以设置 degree like (user.getDeptId%)
            criteria.andCreateDeptLike(user.getDeptId() + "%");
        }
        criteria.andCompanyIdEqualTo(getCompanyId());
        //设置排序
        example.setOrderByClause("create_time desc");
        PageInfo pageInfo = contractService.findAll(example, page, size);
        request.setAttribute("page", pageInfo);
        return "cargo/export/export-contractList";
    }

    @RequestMapping(value = "/list", name = "出口保运页面")
    public String list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        ExportExample exportExample = new ExportExample();
        ExportExample.Criteria criteria = exportExample.createCriteria();
        criteria.andCompanyIdEqualTo(getCompanyId());
        exportExample.setOrderByClause("create_time desc");
        PageInfo pageInfo = exportService.findAll(exportExample, page, size);
        request.setAttribute("page", pageInfo);
        return "cargo/export/export-list";
    }

    @RequestMapping(value = "/toExport", name = "进入填写报运单鞋面")
    public String toExport(String id) {
        request.setAttribute("id", id);
        return "cargo/export/export-toExport";
    }


    @RequestMapping(value = "/edit", name = "进入填写报运单鞋面")
    public String edit(Export export) {
        if (StringUtils.isEmpty(export.getId())) {
            export.setId(UUID.randomUUID().toString());
            export.setCreateTime(new Date());
            export.setCompanyId(getCompanyId());
            export.setCompanyName(getCompanyName());
            export.setCreateBy(getUser().getId());
            export.setCreateDept(getUser().getDeptId());
            export.setState(0);//草稿
            exportService.save(export);
        } else {
            export.setUpdateTime(new Date());
            export.setUpdateBy(getUser().getId());
            exportService.update(export);
        }
        return "redirect:/cargo/export/list.do";
    }

    @RequestMapping(value = "/toUpdate", name = "编辑报运单页面")
    public String toUpdate(String id) {
        //查询报运单
        Export export = exportService.findById(id);
        request.setAttribute("export", export);
        //查询报运单下的货物
        List<ExportProduct> exportProductList = exportProductService.findByExportId(id);
        request.setAttribute("eps", exportProductList);
        return "cargo/export/export-update";
    }

    @RequestMapping(value = "/exportE", name = "跳转到")
    public String exportE(String id) {
        //查询报运单
        Export export = exportService.findById(id);
        ExportVo exportVo = new ExportVo();
        BeanUtils.copyProperties(export,exportVo);
        exportVo.setExportId(id);
        //查询报运单下的货物
        List<ExportProduct> exportProductList = exportProductService.findByExportId(id);
        ExportProductVo exportProductVo = null;
        List<ExportProductVo> list = new ArrayList<>();
        for (ExportProduct exportProduct : exportProductList) {
            exportProductVo = new ExportProductVo();
            BeanUtils.copyProperties(exportProduct,exportProductVo);
            exportProductVo.setEid(exportVo.getId());
            exportProductVo.setExportProductId(exportProduct.getId());
            list.add(exportProductVo);
        }
        exportVo.setProducts(list);
        WebClient.create("http://localhost:9090/ws/export/ep").post(exportVo);
        ExportResult exportResult = WebClient.create("http://localhost:9090/ws/export/ep/" + id).get(ExportResult.class);
        exportService.updateE(exportResult);
        return "redirect:/cargo/export/list.do";
    }

//    private String shipmentPort;		//装船港
//    private String destinationPort;		//目的港

    @RequestMapping(value = "/map",name = "地图")
    public String Map(String id){
        Export byId = exportService.findById(id);
        //调用exportService,查询装船港,目的港
        String start = byId.getShipmentPort();
        String end = byId.getDestinationPort();
        System.out.println(start);
        System.out.println(end);
        request.setAttribute("start",start);
        request.setAttribute("end",end);
        return "forward:/map.jsp";
    }
    @RequestMapping(value = "/maps",name = "地图")
    @ResponseBody
    public Map Maps(String id){
        Export byId = exportService.findById(id);
        //调用exportService,查询装船港,目的港
        String start = byId.getShipmentPort();
        String end = byId.getDestinationPort();
        System.out.println(start);
        System.out.println(end);
        Map map = new HashMap();
        map.put("start",start);
        map.put("end",end);
        return map;
    }
}
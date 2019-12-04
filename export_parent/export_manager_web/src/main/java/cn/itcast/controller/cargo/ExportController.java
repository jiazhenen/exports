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
import cn.itcast.utils.BeanMapUtils;
import cn.itcast.utils.DownloadUtil;
import cn.itcast.vo.ExportProductVo;
import cn.itcast.vo.ExportResult;
import cn.itcast.vo.ExportVo;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.*;

@Controller
@RequestMapping("/cargo/export")
public class ExportController extends BaseController {

    @Reference
    private ContractService contractService;

    @RequestMapping(value = "/contractList",name = "展示已提交的购销合同")
    public String contractList(@RequestParam(name="page",defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10")  int size){
//        select * from co_contract where company_id=? and state=1;
        User user = getUser();
        Integer degree = user.getDegree();
//        1-企业管理员    select * from co_contract where company_id=? and state=1  order by  create_time desc
//        2-管理所有下属部门和人员   select * from co_contract where company_id=? and state=1  and create_dept like '当前登录人部门Id%' order by  create_time desc
//        3-管理本部门   select * from co_contract where company_id=?  and state=1 and create_dept=? order by  create_time desc
//        4-普通员工   select * from co_contract where company_id=? and state=1  and create_by=当前登录人id order by  create_time desc
        ContractExample example = new ContractExample();
        ContractExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyIdEqualTo(getCompanyId());
        criteria.andStateEqualTo(1);
        if(degree==4){
            criteria.andCreateByEqualTo(user.getId());
        }else if(degree==3){
            criteria.andCreateDeptEqualTo(user.getDeptId());
        }else if(degree==2){
            criteria.andCreateDeptLike(user.getDeptId()+"%");
        }
//        设置排序
        example.setOrderByClause("create_time desc");
        PageInfo page = contractService.findAll(example,pageNum,size);
        request.setAttribute("page",page);
        return "cargo/export/export-contractList";

    }


    @Reference
    private ExportService exportService;
    @Reference
    private ExportProductService exportProductService;

    @RequestMapping(value = "/list",name = "展示报运单列表数据")
    public String list(@RequestParam(name="page",defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10")  int size){
//        company_id  select * from co_export where company_id=?
        ExportExample example = new ExportExample();
        example.createCriteria().andCompanyIdEqualTo(getCompanyId());
        example.setOrderByClause("create_time desc");
        PageInfo pageInfo = exportService.findAll(example, pageNum, size);
        request.setAttribute("page",pageInfo);
        return "cargo/export/export-list";
    }

    @RequestMapping(value = "/toExport",name = "进入填写报运单页面")
//    此时可以使用：字符串id“1221,12312” 集合List<String> id  数组String[] id
    public String toExport(String id){//为了方便直接在页面上显示一个字符串，所以这里选择字符串来接收
        request.setAttribute("id",id);
        return "cargo/export/export-toExport";
    }
    @RequestMapping(value = "/edit",name = "保存报运方法")
    public String  edit(Export export){
        if(StringUtils.isEmpty(export.getId())){
            export.setId(UUID.randomUUID().toString());
            export.setCompanyId(getCompanyId());
            export.setCompanyName(getCompanyName());
            export.setCreateTime(new Date());
            export.setCreateBy(getUser().getId());
            export.setCreateDept(getUser().getDeptId());
            export.setState(0);//草稿
            exportService.save(export);
        }else{
            export.setUpdateTime(new Date());
            export.setUpdateBy(getUser().getId());
            exportService.update(export);
        }

        return "redirect:/cargo/export/list.do";
    }

    @RequestMapping(value = "/toUpdate",name = "进入修改报运单页面")
    public String toUpdate(String id){
//        报运单对象
        Export export = exportService.findById(id);
        request.setAttribute("export",export);
//      此报运单下的货物列表
        List<ExportProduct> exportProductList = exportProductService.findByExportId(id);
        request.setAttribute("eps",exportProductList);
        return "cargo/export/export-update";
    }

    @RequestMapping(value = "/exportE",name = "海关电子报运方法")
    public String exportE(String id){ //报运单的ID
//WebService远程调用了
        ExportVo exportVo = new ExportVo();
        Export export = exportService.findById(id);
        BeanUtils.copyProperties(export,exportVo);
//        ExportVo需要手动设置exportId来自于Export的id，List<ExportProductVo>
        exportVo.setExportId(id);

        List<ExportProductVo> exportProductVoList = new ArrayList<>(); //接收需要放入到exportVo的货物Vo集合
//        查询此报运单的下的货物
        List<ExportProduct> exportProductList = exportProductService.findByExportId(id);
        ExportProductVo exportProductVo = null;
        for (ExportProduct exportProduct : exportProductList) {
            exportProductVo = new ExportProductVo();
            BeanUtils.copyProperties(exportProduct,exportProductVo);
//            需要手动个Vo设置的是：eid 、exportProductId
            exportProductVo.setEid(exportVo.getId());
            exportProductVo.setExportProductId(exportProduct.getId());
            exportProductVoList.add(exportProductVo);
        }
        exportVo.setProducts(exportProductVoList);
//        向海关传输数据
        WebClient.create("http://localhost:9090/ws/export/ep").post(exportVo);
//        向海关获取结果数据

        ExportResult exportResult = WebClient.create("http://localhost:9090/ws/export/ep/" + id).get(ExportResult.class);
        exportService.updateE(exportResult); //把海关返回的数据更新到我们的表中
        return "redirect:/cargo/export/list.do";
    }

    @Autowired
    private DownloadUtil downloadUtil;

    @RequestMapping(value = "/exportPdf",name = "导出PDF")
    public void exportPdf(String id) throws Exception{ //报运单ID
//        导出的时候需要两部分数据：1、报运单对象  2、此报运单下的货物列表数据
        Export export = exportService.findById(id);
        List<ExportProduct> exportProductList = exportProductService.findByExportId(id);

//        1、读取到jasper模板文件
        String jasperPath = session.getServletContext().getRealPath("/make/pdf/export.jasper");
        FileInputStream inputStream = new FileInputStream(jasperPath);
//        2、准备数据
        Map<String, Object> parameters = BeanMapUtils.beanToMap(export); //使用工具类把bean转成map

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(exportProductList);
//        3、模板和数据整合
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, dataSource);
//4、把模板和数据结合后的内容转成字节数组
        byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
//        导出
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bytes);

        downloadUtil.download(byteArrayOutputStream,response,"报运单.pdf");

    }

}

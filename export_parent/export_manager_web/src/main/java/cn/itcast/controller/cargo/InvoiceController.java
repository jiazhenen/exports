package cn.itcast.controller.cargo;

import cn.itcast.controller.BaseController;
import cn.itcast.domain.cargo.Invoice;
import cn.itcast.domain.cargo.InvoiceExample;
import cn.itcast.service.cargo.InvoiceService;
import cn.itcast.service.cargo.ShippingService;
import cn.itcast.utils.BeanMapUtils;
import cn.itcast.utils.DownloadUtil;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/cargo/invoice")
public class InvoiceController extends BaseController {
    @Reference
    private InvoiceService invoiceService;
    @Autowired
    private DownloadUtil downloadUtil;
    @Reference
    private ShippingService shippingService;

    @RequestMapping(value = "/list", name = "进入发票列表")
    public String findPage(@RequestParam(name = "page", defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int size) {

        InvoiceExample example = new InvoiceExample();
        InvoiceExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyIdEqualTo(getCompanyId());
        example.setOrderByClause("create_time desc");
        PageInfo page = invoiceService.findAll(example, pageNum, size);
        request.setAttribute("page", page);
        return "cargo/invoice/invoice-list";
    }

    @RequestMapping(value = "/toAdd", name = "进入添加发票页面")
    public String toAdd(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
       PageInfo pageInfo = shippingService.findByState(page,pageSize,1,getCompanyId());
            request.setAttribute("page",pageInfo);
        //在这里应该将pack_list_id 弄过来
        //发票新建应该是装箱页面跳转
        return "cargo/invoice/invoice-add";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(String id) {
        Invoice invoice = invoiceService.findById(id);
        request.setAttribute("invoice", invoice);
        return "cargo/invoice/invoice-add";
    }

    @RequestMapping(value = "/edit", name = "保存合同的方法")
    public String edit(Invoice invoice) {
//        还是根据是否有id判断保存还是修改
        if (StringUtils.isEmpty(invoice.getCreateBy())) { //新增
            //invoice.setInvoiceId(UUID.randomUUID().toString());
            invoice.setCreateTime(new Date()); //创建时间
            invoice.setState(0); //草稿状态
            invoice.setCompanyId(getCompanyId());
            invoice.setCompanyName(getCompanyName());
            invoice.setCreateBy(getUser().getUserName()); //当前登陆人的id
            invoice.setCreateDept(getUser().getDeptId());//当前登陆人部门的id
            invoiceService.save(invoice);
        } else {
            Invoice byId = invoiceService.findById(invoice.getInvoiceId());
            byId.setScNo(invoice.getScNo());
            byId.setBlNo(invoice.getBlNo());
            byId.setTradeTerms(invoice.getTradeTerms());

            byId.setCreateTime(new Date());

            invoiceService.update(byId);
        }
        return "redirect:/cargo/invoice/list.do"; //重定向到列表页面
    }


    @RequestMapping(value = "/delete", name = "删除合同数据方法")
    public String delete(String id) {
        invoiceService.delete(id);

        return "redirect:/cargo/invoice/list.do"; //重定向到列表页面
    }


    @RequestMapping(value = "/submit", name = "提交发票")
    public String submit(String id) {
//        把合同的状态state改成1
        Invoice invoice = invoiceService.findById(id);
        invoice.setState(1);
        invoiceService.update(invoice);
//        Invoice invoice = new Invoice();
//        invoice.setInvoiceId(id);
//        invoice.setState(1);
//        invoiceService.update(invoice);

        return "redirect:/cargo/invoice/list.do";
    }

    @RequestMapping(value = "/toView", name = "查看详情")
    public String toView(String id) throws Exception { //inputDate "2015-01"  "2015-12"
        Invoice invoice = invoiceService.findById(id);
        request.setAttribute("invoice", invoice);
        return "cargo/invoice/invoice-view";

    }

//    @RequestMapping(value = "/invoicePdf", name = "导出发票方法")
//    public void invoicePdf(String id) throws Exception { //报运单ID
////        导出的时候需要两部分数据：1、发票对象  2、发票下委托单
//        Invoice invoice = invoiceService.findById(id);
//       List<ExportProduct> exportProductList = exportProductService.findByExportId(id);
//    这块是写的货物的那个  我有点懵 那个发票上都有啥  啥是需要从数据库查的 涉及到了几个表 没了
//
////        1、读取到jasper模板文件
//        String jasperPath = session.getServletContext().getRealPath("/make/pdf/export.jasper");
//        FileInputStream inputStream = new FileInputStream(jasperPath);
////        2、准备数据
//        Map<String, Object> parameters = BeanMapUtils.beanToMap(invoice); //使用工具类把bean转成map
//
//       JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(exportProductList);
////        3、模板和数据整合
//        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, dataSource);
////4、把模板和数据结合后的内容转成字节数组
//        byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
////        导出
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        byteArrayOutputStream.write(bytes);
//
//        downloadUtil.download(byteArrayOutputStream, response, "发票.pdf");

 //   }
}

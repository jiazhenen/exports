package cn.itcast.controller.cargo;

import cn.itcast.controller.BaseController;
import cn.itcast.domain.cargo.Invoice;
import cn.itcast.domain.cargo.InvoiceExample;
import cn.itcast.service.cargo.InvoiceService;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/cargo/invoice")
public class InvoiceController extends BaseController {
    @Reference
    private InvoiceService invoiceService;
    
    @RequestMapping(value = "/list",name = "进入发票列表")
    public String findPage( @RequestParam(name="page",defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10")  int size){

        InvoiceExample example = new InvoiceExample();
        InvoiceExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyIdEqualTo(getCompanyId());
        example.setOrderByClause("create_time desc");
        PageInfo page = invoiceService.findAll(example,pageNum,size);
        request.setAttribute("page",page);
        return "cargo/invoice/invoice-list";
    }
    @RequestMapping(value = "/toAdd",name = "进入添加发票页面")
    public String toAdd(){
        return "cargo/invoice/invoice-add";
    }
    @RequestMapping("/toUpdate")
    public String toUpdate(String id){
        Invoice invoice = invoiceService.findById(id);
        request.setAttribute("invoice",invoice);
        return "cargo/invoice/invoice-add";
    }
    @RequestMapping(value = "/edit",name = "保存合同的方法")
    public String edit(Invoice invoice){
//        还是根据是否有id判断保存还是修改
        if(StringUtils.isEmpty(invoice.getInvoiceId())){ //新增
            invoice.setInvoiceId(UUID.randomUUID().toString());
            invoice.setCreateTime(new Date()); //创建时间
            invoice.setState(0); //草稿状态
            invoice.setCompanyId(getCompanyId());
            invoice.setCompanyName(getCompanyName());
            invoice.setCreateBy(getUser().getId()); //当前登陆人的id
            invoice.setCreateDept(getUser().getDeptId());//当前登陆人部门的id
            invoiceService.save(invoice);
        }else{

            invoiceService.update(invoice);
        }
        return "redirect:/cargo/invoice/list.do"; //重定向到列表页面
    }


    @RequestMapping(value = "/delete",name = "删除合同数据方法")
    public String delete(String id){
        invoiceService.delete(id);
        return "redirect:/cargo/invoice/list.do"; //重定向到列表页面
    }
}

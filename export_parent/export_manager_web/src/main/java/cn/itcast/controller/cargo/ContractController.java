package cn.itcast.controller.cargo;

import cn.itcast.controller.BaseController;
import cn.itcast.domain.cargo.Contract;
import cn.itcast.domain.cargo.ContractExample;
import cn.itcast.domain.system.User;
import cn.itcast.service.cargo.ContractService;
import cn.itcast.utils.DownloadUtil;
import cn.itcast.vo.ContractProductVo;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/cargo/contract")
public class ContractController extends BaseController {

    @Reference
    private ContractService contractService;

    @RequestMapping(value = "/list",name = "展示合同数据")
    public String findPage(@RequestParam(name="page",defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10")  int size){
//        ContractExample example, int page, int size
//        select * from co_contract where company_id=?  order by  create_time desc
//                查询合同数据需要的参数是：companyId
        User user = getUser();
        Integer degree = user.getDegree();
//        1-企业管理员    select * from co_contract where company_id=?  order by  create_time desc
//        2-管理所有下属部门和人员   select * from co_contract where company_id=?  and create_dept like '当前登录人部门Id%' order by  create_time desc
//        3-管理本部门   select * from co_contract where company_id=?  and create_dept=? order by  create_time desc
//        4-普通员工   select * from co_contract where company_id=?  and create_by=当前登录人id order by  create_time desc

        ContractExample example = new ContractExample();
        ContractExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyIdEqualTo(getCompanyId());
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
        return "cargo/contract/contract-list";
    }

    @RequestMapping(value = "/toAdd",name = "进入添加合同页面")
    public String toAdd(){
        return "cargo/contract/contract-add";
    }
    @RequestMapping("/toUpdate")
    public String toUpdate(String id){
        Contract contract = contractService.findById(id);
        request.setAttribute("contract",contract);
        return "cargo/contract/contract-add";
    }

    @RequestMapping(value = "/edit",name = "保存合同的方法")
    public String edit(Contract contract){
//        还是根据是否有id判断保存还是修改
        if(StringUtils.isEmpty(contract.getId())){ //新增
            contract.setId(UUID.randomUUID().toString());
            contract.setCreateTime(new Date()); //创建时间
            contract.setState(0); //草稿状态
            contract.setCompanyId(getCompanyId());
            contract.setCompanyName(getCompanyName());
            contract.setCreateBy(getUser().getId()); //当前登陆人的id
            contract.setCreateDept(getUser().getDeptId());//当前登陆人部门的id
            contractService.save(contract);
        }else{
            contract.setUpdateTime(new Date());
            contractService.update(contract);
        }
        return "redirect:/cargo/contract/list.do"; //重定向到列表页面
    }


    @RequestMapping(value = "/delete",name = "删除合同数据方法")
    public String delete(String id){
        contractService.delete(id);
        return "redirect:/cargo/contract/list.do"; //重定向到列表页面
    }
    @RequestMapping(value = "/print",name = "进入导出出货表页面")
    public String print(){
        return "cargo/print/contract-print"; //重定向到列表页面
    }

    @Autowired
    private DownloadUtil downloadUtil;

    @RequestMapping(value = "/printExcel",name = "导出出货表方法")
    public void printExcel(String inputDate) throws Exception{ //inputDate "2015-01"  "2015-12"
//        根据船期查询数据
        List<ContractProductVo>  contractProductVoList = contractService.findContractProductVoByShipTime(inputDate,getCompanyId());

//        导出一个excel
//        创建了一个里面什么都没有的工作薄
        Workbook workbook = new XSSFWorkbook();
//        创建新的工作表sheet
        Sheet sheet = workbook.createSheet("POI测试");
//        设置sheet的列宽
        sheet.setColumnWidth(0,4200); //
        sheet.setColumnWidth(1,26*256); //
        sheet.setColumnWidth(2,16*256); //
        sheet.setColumnWidth(3,26*256); //
        sheet.setColumnWidth(4,16*256); //
        sheet.setColumnWidth(5,16*256); //
        sheet.setColumnWidth(6,16*256); //
        sheet.setColumnWidth(7,16*256); //
        sheet.setColumnWidth(8,16*256); //
        Row bigTitleRow = sheet.createRow(0);
//        创建单元格
        for (int i = 1; i <= 8; i++) {
            bigTitleRow.createCell(i);
        }
//        设置行高
        bigTitleRow.setHeightInPoints(36);
//        合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0,0,1,8));
//        向合并后的单元格中写入一句话：2012年8月份出货表
        Cell cell = bigTitleRow.getCell(1);
        cell.setCellValue(inputDate.replace("-0","年").replace("-","年")  +"月份出货表"); //2015-01"把-0换成“年”  "2015-12"  把-换成“年”
        cell.setCellStyle(bigTitle(workbook));
//        创建小标题行
//        客户
        Row titleRow = sheet.createRow(1);
        String[] titles = new String[]{"客户","合同号","货号","数量","工厂","工厂交期","船期","贸易条款"};
        for (int i = 1; i <= 8; i++) {
//            String title = titles[i];
            cell = titleRow.createCell(i);
            cell.setCellStyle(title(workbook));
            cell.setCellValue(titles[i-1]);
        }
//        内容   contractProductVoList

        int rowIndex=2;
        Row row = null;
        for (ContractProductVo contractProductVo : contractProductVoList) {
            row = sheet.createRow(rowIndex);
//            客户	合同号	货号	数量	工厂	工厂交期	船期	贸易条款
            cell = row.createCell(1);
            cell.setCellValue(contractProductVo.getCustomName());
            cell.setCellStyle(text(workbook));

            cell = row.createCell(2);
            cell.setCellValue(contractProductVo.getContractNo());
            cell.setCellStyle(text(workbook));

            cell = row.createCell(3);
            cell.setCellValue(contractProductVo.getProductNo());
            cell.setCellStyle(text(workbook));

            cell = row.createCell(4);
            cell.setCellValue(contractProductVo.getCnumber());
            cell.setCellStyle(text(workbook));

            cell = row.createCell(5);
            cell.setCellValue(contractProductVo.getFactoryName());
            cell.setCellStyle(text(workbook));
//            工厂交期	船期	贸易条款

            cell = row.createCell(6);
            cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(contractProductVo.getDeliveryPeriod()));
            cell.setCellStyle(text(workbook));

            cell = row.createCell(7);
            cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(contractProductVo.getShipTime()));
            cell.setCellStyle(text(workbook));

            cell = row.createCell(8);
            cell.setCellValue(contractProductVo.getTradeTerms());
            cell.setCellStyle(text(workbook));
            rowIndex++;
        }

//        把workbook文件导出
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);  //把workbook的内容写入到缓存流中
        downloadUtil.download(byteArrayOutputStream,response,"出货表.xlsx");

    }



    @RequestMapping(value = "/printExcelWithTemplate",name = "导出出货表方法")
    public void printExcelWithTemplate(String inputDate) throws Exception{ //inputDate "2015-01"  "2015-12"

        List<ContractProductVo>  contractProductVoList = contractService.findContractProductVoByShipTime(inputDate,getCompanyId());

//        String projectRoot = session.getServletContext().getRealPath("");//此方法可以获取项目的根目录
        String filePath = session.getServletContext().getRealPath("/make/xlsprint/tOUTPRODUCT.xlsx");
//        filePath就是模板文件的路径
        FileInputStream inputStream = new FileInputStream(filePath);
//读取用来导出出货表的模板
        Workbook workbook = new XSSFWorkbook(inputStream);
//        获取工作表sheet
        Sheet sheet = workbook.getSheetAt(0);
//        向合并后的单元格中写入一句话：2012年8月份出货表
        Cell cell = sheet.getRow(0).getCell(1);
        cell.setCellValue(inputDate.replace("-0","年").replace("-","年")  +"月份出货表"); //2015-01"把-0换成“年”  "2015-12"  把-换成“年”

//        内容   contractProductVoList
//        获取模板中的8个样式
        CellStyle[] cellStyles = new CellStyle[8];
        Row row = null;
        row = sheet.getRow(2);
        for (int i =1; i <=8; i++) {  //获取模板中第3行的那8个单元格的样式
            cellStyles[i-1] = row.getCell(i).getCellStyle();
        }

        int rowIndex=2;

        for (ContractProductVo contractProductVo : contractProductVoList) {
            row = sheet.createRow(rowIndex);
//            客户	合同号	货号	数量	工厂	工厂交期	船期	贸易条款
            cell = row.createCell(1);
            cell.setCellValue(contractProductVo.getCustomName());
            cell.setCellStyle(cellStyles[0]);

            cell = row.createCell(2);
            cell.setCellValue(contractProductVo.getContractNo());
            cell.setCellStyle(cellStyles[1]);

            cell = row.createCell(3);
            cell.setCellValue(contractProductVo.getProductNo());
            cell.setCellStyle(cellStyles[2]);

            cell = row.createCell(4);
            cell.setCellValue(contractProductVo.getCnumber());
            cell.setCellStyle(cellStyles[3]);

            cell = row.createCell(5);
            cell.setCellValue(contractProductVo.getFactoryName());
            cell.setCellStyle(cellStyles[4]);
//            工厂交期	船期	贸易条款

            cell = row.createCell(6);
            cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(contractProductVo.getDeliveryPeriod()));
            cell.setCellStyle(cellStyles[5]);

            cell = row.createCell(7);
            cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(contractProductVo.getShipTime()));
            cell.setCellStyle(cellStyles[6]);

            cell = row.createCell(8);
            cell.setCellValue(contractProductVo.getTradeTerms());
            cell.setCellStyle(cellStyles[7]);
            rowIndex++;
        }

//        把workbook文件导出
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);  //把workbook的内容写入到缓存流中
        downloadUtil.download(byteArrayOutputStream,response,"出货表.xlsx");

    }

    @RequestMapping(value = "/printExcelMillion",name = "导出百万数据")
    public void printExcelMillion(String inputDate) throws Exception{ //inputDate "2015-01"  "2015-12"

        List<ContractProductVo>  contractProductVoList = contractService.findContractProductVoByShipTime(inputDate,getCompanyId());

//        导出一个excel
//        创建了一个里面什么都没有的工作薄
        Workbook workbook = new SXSSFWorkbook();
//        创建新的工作表sheet
        Sheet sheet = workbook.createSheet("POI测试");
//        设置sheet的列宽
        sheet.setColumnWidth(0,4200); //
        sheet.setColumnWidth(1,26*256); //
        sheet.setColumnWidth(2,16*256); //
        sheet.setColumnWidth(3,26*256); //
        sheet.setColumnWidth(4,16*256); //
        sheet.setColumnWidth(5,16*256); //
        sheet.setColumnWidth(6,16*256); //
        sheet.setColumnWidth(7,16*256); //
        sheet.setColumnWidth(8,16*256); //
        Row bigTitleRow = sheet.createRow(0);
//        创建单元格
        for (int i = 1; i <= 8; i++) {
            bigTitleRow.createCell(i);
        }
//        设置行高
        bigTitleRow.setHeightInPoints(36);
//        合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0,0,1,8));
//        向合并后的单元格中写入一句话：2012年8月份出货表
        Cell cell = bigTitleRow.getCell(1);
        cell.setCellValue(inputDate.replace("-0","年").replace("-","年")  +"月份出货表"); //2015-01"把-0换成“年”  "2015-12"  把-换成“年”
        cell.setCellStyle(bigTitle(workbook));
//        创建小标题行
//        客户
        Row titleRow = sheet.createRow(1);
        String[] titles = new String[]{"客户","合同号","货号","数量","工厂","工厂交期","船期","贸易条款"};
        for (int i = 1; i <= 8; i++) {
//            String title = titles[i];
            cell = titleRow.createCell(i);
            cell.setCellStyle(title(workbook));
            cell.setCellValue(titles[i-1]);
        }
//        内容   contractProductVoList

        int rowIndex=2;
        Row row = null;
        for (ContractProductVo contractProductVo : contractProductVoList) {
            for (int i = 0; i < 6000; i++) {
            row = sheet.createRow(rowIndex);
//            客户	合同号	货号	数量	工厂	工厂交期	船期	贸易条款
            cell = row.createCell(1);
            cell.setCellValue(contractProductVo.getCustomName());
//            cell.setCellStyle(text(workbook));

            cell = row.createCell(2);
            cell.setCellValue(contractProductVo.getContractNo());
//            cell.setCellStyle(text(workbook));

            cell = row.createCell(3);
            cell.setCellValue(contractProductVo.getProductNo());
//            cell.setCellStyle(text(workbook));

            cell = row.createCell(4);
            cell.setCellValue(contractProductVo.getCnumber());
//            cell.setCellStyle(text(workbook));

            cell = row.createCell(5);
            cell.setCellValue(contractProductVo.getFactoryName());
//            cell.setCellStyle(text(workbook));
//            工厂交期	船期	贸易条款

            cell = row.createCell(6);
            cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(contractProductVo.getDeliveryPeriod()));
//            cell.setCellStyle(text(workbook));

            cell = row.createCell(7);
            cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(contractProductVo.getShipTime()));
//            cell.setCellStyle(text(workbook));

            cell = row.createCell(8);
            cell.setCellValue(contractProductVo.getTradeTerms());
//            cell.setCellStyle(text(workbook));
             rowIndex++;
            }

        }

//        把workbook文件导出
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);  //把workbook的内容写入到缓存流中
        downloadUtil.download(byteArrayOutputStream,response,"出货表.xlsx");

    }

    //大标题的样式
    public CellStyle bigTitle(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short)16);
        font.setBold(true);//字体加粗
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);				//横向居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);		//纵向居中
        return style;
    }

    //小标题的样式
    public CellStyle title(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short)12);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);				//横向居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);		//纵向居中
        style.setBorderTop(BorderStyle.THIN);						//上细线
        style.setBorderBottom(BorderStyle.THIN);					//下细线
        style.setBorderLeft(BorderStyle.THIN);						//左细线
        style.setBorderRight(BorderStyle.THIN);						//右细线
        return style;
    }

    //文字样式
    public CellStyle text(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints((short)10);

        style.setFont(font);

        style.setAlignment(HorizontalAlignment.LEFT);				//横向居左
        style.setVerticalAlignment(VerticalAlignment.CENTER);		//纵向居中
        style.setBorderTop(BorderStyle.THIN);						//上细线
        style.setBorderBottom(BorderStyle.THIN);					//下细线
        style.setBorderLeft(BorderStyle.THIN);						//左细线
        style.setBorderRight(BorderStyle.THIN);						//右细线

        return style;
    }


    @RequestMapping(value = "/submit",name = "提交合同")
    public String submit(String id){
//        把合同的状态state改成1
       /* Contract contract = contractService.findById(id);
        contract.setState(1);
        contractService.update(contract);*/
        Contract contract = new Contract();
        contract.setId(id);
        contract.setState(1);
        contractService.update(contract);

        return "redirect:/cargo/contract/list.do";
    }









}

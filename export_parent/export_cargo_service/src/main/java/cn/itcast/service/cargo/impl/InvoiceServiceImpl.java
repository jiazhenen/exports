package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.ExportDao;
import cn.itcast.dao.cargo.InvoiceDao;
import cn.itcast.dao.cargo.PackingDao;
import cn.itcast.dao.cargo.ShippingDao;
import cn.itcast.domain.cargo.*;
import cn.itcast.service.cargo.InvoiceService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    private ShippingDao shippingDao;
    @Autowired
    private PackingDao packingDao;
    @Autowired
    private ExportDao exportDao;


    @Override
    public void save(Invoice invoice) {

        invoiceDao.insert(invoice);
        //修改委托单状态
        Shipping shipping = new Shipping();
        shipping.setShippingOrderId(invoice.getInvoiceId());
        shipping.setState(2);

        shippingDao.updateByPrimaryKeySelective(shipping);

        //修改装箱单状态
        Packing packing = new Packing();
        packing.setPackingListId(invoice.getInvoiceId());
        packing.setState(4);
        packingDao.update(packing);

        //修改报运单状态
        Export export = new Export();
        export.setState(5);
        export.setId(packingDao.findById(invoice.getInvoiceId()).getExportId());
        exportDao.updateByPrimaryKeySelective(export);
    }

    @Override
    public void update(Invoice invoice) {
    invoiceDao.updateByPrimaryKey(invoice);
    }

    @Override
    public void delete(String id) {

        invoiceDao.deleteByPrimaryKey(id);
        //修改委托单状态
        Shipping shipping = new Shipping();
        shipping.setShippingOrderId(id);
        shipping.setState(1);
        shippingDao.updateByPrimaryKey(shipping);

        //修改装箱单状态
        Packing packing = new Packing();
        packing.setPackingListId(id);
        packing.setState(3);
        packingDao.update(packing);

        //修改报运单状态
        Export export = new Export();
        export.setState(4);
        export.setId(packingDao.findById(id).getExportId());
        exportDao.updateByPrimaryKeySelective(export);

    }

    @Override
    public Invoice findById(String id) {
        return invoiceDao.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo findAll(InvoiceExample example, int page, int size) {
        PageHelper.startPage(page,size);
        List<Invoice> list = invoiceDao.selectByExample(example);
        return new PageInfo(list);
    }

    @Override
    public void saveList(List<Invoice>  invoicesList) {
        for (Invoice invoice : invoicesList) {
            invoiceDao.insert(invoice);
        }

    }
}

package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.InvoiceDao;
import cn.itcast.dao.cargo.PackingDao;
import cn.itcast.dao.cargo.ShippingDao;
import cn.itcast.domain.cargo.Invoice;
import cn.itcast.domain.cargo.InvoiceExample;
import cn.itcast.domain.cargo.Shipping;
import cn.itcast.service.cargo.InvoiceService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    private ShippingDao shippingDao;
    @Autowired
    private PackingDao packingDao;


    @Override
    public void save(Invoice invoice) {

        invoiceDao.insert(invoice);
        //修改委托单状态
        Shipping shipping = new Shipping();
        shipping.getShippingOrderId();
        shipping.setState(2);
        shippingDao.updateByPrimaryKey(shipping);
        //修改装箱单状态

    }

    @Override
    public void update(Invoice invoice) {
    invoiceDao.updateByPrimaryKey(invoice);
    }

    @Override
    public void delete(String id) {
        invoiceDao.deleteByPrimaryKey(id);
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

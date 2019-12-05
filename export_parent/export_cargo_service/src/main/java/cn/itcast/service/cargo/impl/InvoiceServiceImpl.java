package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.InvoiceDao;
import cn.itcast.domain.cargo.Invoice;
import cn.itcast.domain.cargo.InvoiceExample;
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

    @Override
    public void save(Invoice invoice) {
        invoiceDao.insert(invoice);
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

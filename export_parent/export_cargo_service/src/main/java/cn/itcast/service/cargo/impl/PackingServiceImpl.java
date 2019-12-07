package cn.itcast.service.cargo.impl;


import cn.itcast.dao.cargo.ExportDao;
import cn.itcast.dao.cargo.InvoiceDao;
import cn.itcast.dao.cargo.PackingDao;
import cn.itcast.dao.cargo.ShippingDao;
import cn.itcast.domain.cargo.Export;
import cn.itcast.domain.cargo.Packing;
import cn.itcast.service.cargo.PackingService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PackingServiceImpl implements PackingService {

    @Autowired
    private PackingDao packingDao;

    @Autowired
    private ExportDao exportDao;//报运单

    @Autowired
    private ShippingDao shippingDao;//委托

    @Autowired
    private InvoiceDao invoiceDao;//发票

    @Override
    public PageInfo findAll(Integer page, Integer pageSize, String companyId) {
        PageHelper.startPage(page,pageSize);
        List<Packing> packingList = packingDao.findAll(companyId);
        return new PageInfo<>(packingList,5);
    }

    @Override
    public void save(Packing packing) {
        packingDao.save(packing);
        //2.修改报运单的状态码
        Export export = new Export();
        export.setState(3);//已报运->已装箱
        export.setId(packingDao.findById(packing.getPackingListId()).getExportId());
        exportDao.updateByPrimaryKeySelective(export);
    }

    @Override
    public void update(Packing packing) {
        packingDao.update(packing);
    }

    @Override
    public Packing findById(String packingListId) {
        return packingDao.findById(packingListId);
    }

    @Override
    public void submit(String id) {
        //1.修改装箱单的状态码
        Packing packing = new Packing();
        packing.setState(1);//草稿->已装箱
        packing.setPackingListId(id);
        packingDao.update(packing);
    }

    @Override
    public void cancel(String id) {
        //1.修改装箱单的状态码
        Packing packing = new Packing();
        packing.setState(0);//已上报->草稿
        packing.setPackingListId(id);
        packingDao.update(packing);
    }

    @Override
    public PageInfo findByState(Integer page, Integer pageSize, Integer state, String companyId) {
        PageHelper.startPage(page,pageSize);
        List<Packing> packingList = packingDao.findByState(state, companyId);
        return new PageInfo<>(packingList,5);
    }

    @Override
    public void delete(String id) {
        //1.删除发票
        invoiceDao.deleteByPrimaryKey(id);
        //2.删除委托单
        shippingDao.deleteByPrimaryKey(id);
        //3.删除装箱单
        packingDao.delete(id);
    }
}

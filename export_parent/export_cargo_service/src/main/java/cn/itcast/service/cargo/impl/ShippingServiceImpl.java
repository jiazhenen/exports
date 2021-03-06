package cn.itcast.service.cargo.impl;


import cn.itcast.dao.cargo.ExportDao;
import cn.itcast.dao.cargo.PackingDao;
import cn.itcast.dao.cargo.ShippingDao;
import cn.itcast.domain.cargo.Export;
import cn.itcast.domain.cargo.Packing;
import cn.itcast.domain.cargo.Shipping;
import cn.itcast.domain.cargo.ShippingExample;
import cn.itcast.service.cargo.ShippingService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    private ShippingDao shippingDao;

    @Autowired
    private PackingDao packingDao;

    @Autowired
    private ExportDao exportDao;

    @Override
    public Shipping findById(String shippingOrderId) {
        return shippingDao.selectByPrimaryKey(shippingOrderId);
    }

    @Override
    public void save(Shipping shipping) {
        // 先根据装箱单id查询 装箱单 (委托单的id等于 装箱单的id)
        // 根据装箱单的exportId报运单id查询报运单的数据
        // 将报运单中的数据设置到委托单中
        // 最后将装箱单的状态设置为 2 委托
        // 查询装箱单
        String packingListId = shipping.getShippingOrderId();
        Packing packing = packingDao.findById(packingListId);

        // 修改装箱单的状态 1 - 2委托
        packing.setState(3);
        packingDao.update(packing);

        // 查询报运单
        String exportId = packing.getExportId();
        Export export = exportDao.selectByPrimaryKey(exportId);

        // 修改报运单的状态 3 - 4委托
        export.setState(4);
        exportDao.updateByPrimaryKeySelective(export);

        // 从报运单中拷贝需要的数据到委托单
        shipping.setOrderType(export.getTransportMode()); // 运输方式
        shipping.setLcNo(export.getLcno()); // 信用证号
        shipping.setPortOfLoading(export.getShipmentPort()); // 装货港
        shipping.setPortOfDischarge(export.getDestinationPort()); // 卸货港目的港

        shippingDao.insertSelective(shipping);
    }

    @Override
    public void update(Shipping shipping) {
        shippingDao.updateByPrimaryKeySelective(shipping);
    }

    @Override
    public void delete(String shippingOrderId) {
        Packing packing = packingDao.findById(shippingOrderId);
        packing.setState(1); // 状态 2 -> 1 已上报

        Export export = exportDao.selectByPrimaryKey(packing.getExportId());
        export.setState(4); // 状态 4 -> 3 装箱

        shippingDao.deleteByPrimaryKey(shippingOrderId);
    }

    @Override
    public PageInfo findAll(ShippingExample shippingExample, int page, int size) {
        PageHelper.startPage(page, size);
        List<Shipping> shippings = shippingDao.selectByExample(shippingExample);
        return new PageInfo(shippings, 5);
    }

    //根据状态查询
    @Override
    public PageInfo findByState(int page, int size, int i, String companyId) {
        PageHelper.startPage(page,size);
        ShippingExample example = new ShippingExample();
        ShippingExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyIdEqualTo(companyId);
        criteria.andStateEqualTo(i);
        List<Shipping> packingList = shippingDao.selectByExample(example);
        return new PageInfo<>(packingList,5);
    }
}

package cn.itcast.service.cargo;


import cn.itcast.domain.cargo.Shipping;
import cn.itcast.domain.cargo.ShippingExample;
import com.github.pagehelper.PageInfo;

public interface ShippingService {

    Shipping findById(String id);

    void save(Shipping shipping);

    void update(Shipping shipping);

    void delete(String id);


    PageInfo findAll(ShippingExample shippingExample, int page, int size);

    PageInfo findByState(int page, int size, int i, String companyId);
}

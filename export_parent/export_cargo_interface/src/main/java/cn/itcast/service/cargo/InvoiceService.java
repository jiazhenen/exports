package cn.itcast.service.cargo;


import cn.itcast.domain.cargo.Invoice;
import cn.itcast.domain.cargo.InvoiceExample;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface InvoiceService {
    /**
     * 保存
     */
    void save(Invoice invoice);

    /**
     * 更新
     */
    void update(Invoice invoice);

    /**
     * 删除
     */
    void delete(String id);

    /**
     * 根据id查询
     */
    Invoice findById(String id);

    /**
     * 分页查询
     */
    PageInfo findAll(InvoiceExample example, int page, int size);

    void saveList(List<Invoice> productList);
    
}

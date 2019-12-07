package cn.itcast.service.cargo;

import cn.itcast.domain.cargo.Packing;
import com.github.pagehelper.PageInfo;

public interface PackingService {

    //查询所有
    PageInfo findAll(Integer page, Integer pageSize, String companyId);
    //保存
    void save(Packing packing);
    //更新
    void update(Packing packing);

    Packing findById(String packingListId);

    void submit(String id);

    void cancel(String id);

    PageInfo findByState(Integer page, Integer pageSize, Integer state, String companyId);

    void delete(String id);
}

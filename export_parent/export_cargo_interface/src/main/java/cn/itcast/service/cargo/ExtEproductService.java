package cn.itcast.service.cargo;

import cn.itcast.domain.cargo.ExtEproduct;
import cn.itcast.domain.cargo.ExtEproductExample;
import com.github.pagehelper.PageInfo;

public interface ExtEproductService {

    public ExtEproduct findById(String id);

    public void save(ExtEproduct extEproduct);

    public void update(ExtEproduct extEproduct);

    public void delete(String id);

    public PageInfo findAll(ExtEproductExample extEproductExample, int page, int size);

    }

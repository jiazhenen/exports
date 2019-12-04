package cn.itcast.service.system;

import cn.itcast.domain.system.Dept;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DeptService {

    public List<Dept> findAll(String companyId);

    void save(Dept dept);

    Dept findById(String id);

    void update(Dept dept);

    void deleteById(String id);

    PageInfo findPage(String companyId,int pageNum, int pageSize);
}

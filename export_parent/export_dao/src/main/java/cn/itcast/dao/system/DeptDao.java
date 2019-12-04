package cn.itcast.dao.system;

import cn.itcast.domain.system.Dept;

import java.util.List;

public interface DeptDao {

    public List<Dept> findAll(String companyId);

    void save(Dept dept);

    Dept findById(String id);

    void update(Dept dept);

    void deleteById(String id);

}

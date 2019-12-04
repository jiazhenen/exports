package cn.itcast.dao.company;

import cn.itcast.domain.company.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyDao {
    public List<Company> findAll();

    void save(Company company);

    Company findById(String id);

    void update(Company company);

    void deleteById(String id);

    Long selectCount();

    List findPage(@Param("start") int start, @Param("pageSize") int pageSize);
}

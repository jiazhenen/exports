package cn.itcast.service.company;

import cn.itcast.domain.company.Company;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CompanyService {

    public List<Company> findAll();

    void save(Company company);

    Company findById(String id);

    void update(Company company);

    void deleteById(String id);

//    PageBean findPage(int pageNum, int pageSize);
    PageInfo findPage(int pageNum, int pageSize);
}

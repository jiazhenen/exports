package cn.itcast.service.company.impl;

import cn.itcast.dao.company.CompanyDao;
import cn.itcast.domain.company.Company;
import cn.itcast.service.company.CompanyService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }

    @Override
    public void save(Company company) {
        companyDao.save(company);
    }

    @Override
    public Company findById(String id) {
        return companyDao.findById(id);
    }

    @Override
    public void update(Company company) {
        companyDao.update(company);
    }

    @Override
    public void deleteById(String id) {
        companyDao.deleteById(id);
    }

    /*@Override
    public PageBean findPage(int pageNum, int pageSize) {
//        查询总条数  select count(0) from ss_company
        Long total = companyDao.selectCount();
//        起始位置=(pageNum-1)*pageSize
//     查询当前页的数据 select * from ss_company limit 起始位置,每页显示的条数
        List list = companyDao.findPage((pageNum-1)*pageSize,pageSize);
//        Integer pageNum , Integer pageSize, List list , Long total
        return new PageBean(pageNum,pageSize,list,total);
    }*/


    public PageInfo findPage(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Company> list = companyDao.findAll(); //表面上是查询所有，但是在执行select查询之前会根据分页拦截器把sql语句做了处理，
//        1、分页带上了limit关键字 2、还执行了count
        return new PageInfo(list,5);
    }
}

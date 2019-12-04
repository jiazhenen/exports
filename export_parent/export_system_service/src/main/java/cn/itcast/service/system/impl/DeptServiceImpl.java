package cn.itcast.service.system.impl;

import cn.itcast.dao.system.DeptDao;
import cn.itcast.domain.system.Dept;
import cn.itcast.service.system.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> findAll(String companyId) {
        return deptDao.findAll(companyId);
    }

    @Override
    public void save(Dept dept) {
        deptDao.save(dept);
    }

    @Override
    public Dept findById(String id) {
        return deptDao.findById(id);
    }

    @Override
    public void update(Dept dept) {
        deptDao.update(dept);
    }

    @Override
    public void deleteById(String id) {
        deptDao.deleteById(id);
    }



    public PageInfo findPage(String companyId,int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Dept> list = deptDao.findAll(companyId); //表面上是查询所有，但是在执行select查询之前会根据分页拦截器把sql语句做了处理，
//        1、分页带上了limit关键字 2、还执行了count
        return new PageInfo(list,5);
    }
}

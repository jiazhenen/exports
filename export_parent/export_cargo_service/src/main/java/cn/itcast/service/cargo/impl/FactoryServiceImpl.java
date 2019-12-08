package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.FactoryDao;
import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.cargo.FactoryExample;
import cn.itcast.service.cargo.FactoryService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
@Service
public class FactoryServiceImpl implements FactoryService {

    @Autowired
    private FactoryDao factoryDao;
    @Override
    public void save(Factory factory) {
        factory.setCreateTime(new Date());
        factory.setUpdateTime(new Date());
        factoryDao.insertSelective(factory);
    }

    @Override
    public void update(Factory factory) {
        factoryDao.updateByPrimaryKeySelective(factory);
    }

    @Override
    public void delete(String id) {
        factoryDao.deleteByPrimaryKey(id);
    }

    @Override
    public Factory findById(String id) {
        return factoryDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Factory> findAll(FactoryExample example) {
        return factoryDao.selectByExample(example);
    }

    @Override
    public PageInfo findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
       List<Factory> list =  factoryDao.findAll();
        return new PageInfo(list,5);
    }
}

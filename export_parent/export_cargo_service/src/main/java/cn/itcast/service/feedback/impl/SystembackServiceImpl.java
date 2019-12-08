package cn.itcast.service.feedback.impl;

import cn.itcast.dao.systemback.SystembackDao;
import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.cargo.FactoryExample;
import cn.itcast.domain.feedback.Feedback;
import cn.itcast.domain.systemback.Systemback;
import cn.itcast.domain.systemback.SystembackExample;
import cn.itcast.service.feedback.SystembackService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SystembackServiceImpl implements SystembackService {

    @Autowired
    private SystembackDao systembackDao;

    @Override
    public void save(Factory factory) {

    }

    @Override
    public void update(Factory factory) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Factory findById(String id) {
        return null;
    }

    @Override
    public List<Factory> findAll(FactoryExample example) {
        return null;
    }





    @Override
    public PageInfo<Systemback> selectAll(SystembackExample example, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Systemback> list = systembackDao.selectByExample(example);
        return new PageInfo(list);
    }

    @Override
    public Systemback selectSystembackById(String id) {
        return systembackDao.selectByPrimaryKey(id);
    }

    @Override
    public void updateSystemback(Systemback systemback) {
        systembackDao.updateByPrimaryKeySelective(systemback);

    }

    @Override
    public void deleteSystemback(String id) {
        systembackDao.deleteByPrimaryKey(id);
    }

    @Override
    public void addSystemback(Systemback systemback) {
        systembackDao.insertSelective(systemback);
    }
}

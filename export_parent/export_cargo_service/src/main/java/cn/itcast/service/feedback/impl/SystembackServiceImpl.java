package cn.itcast.service.feedback.impl;

import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.cargo.FactoryExample;
import cn.itcast.domain.systemback.Systemback;
import cn.itcast.domain.systemback.SystembackExample;
import cn.itcast.service.feedback.SystembackService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;

@Service
public class SystembackServiceImpl implements SystembackService {
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
        return null;
    }

    @Override
    public Systemback selectSystembackById(String id) {
        return null;
    }

    @Override
    public void updateSystemback(Systemback systemback) {

    }

    @Override
    public void deleteSystemback(String id) {

    }

    @Override
    public void addSystemback(Systemback systemback) {

    }
}

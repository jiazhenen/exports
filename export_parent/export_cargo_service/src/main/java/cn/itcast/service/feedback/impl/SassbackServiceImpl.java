package cn.itcast.service.feedback.impl;

import cn.itcast.dao.systemback.SassfeedbackDao;
import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.cargo.FactoryExample;
import cn.itcast.domain.feedback.Feedback;
import cn.itcast.domain.systemback.Sassfeedback;
import cn.itcast.domain.systemback.SassfeedbackExample;
import cn.itcast.service.feedback.SassbackService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SassbackServiceImpl implements SassbackService {

    @Autowired
    private SassfeedbackDao sassfeedbackDao;

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
    public Sassfeedback selectSassfeedbackById(String id) {
        return sassfeedbackDao.selectByPrimaryKey(id);
    }

    @Override
    public void addSassfeedback(Sassfeedback sassfeedback) {
        sassfeedbackDao.insertSelective(sassfeedback);
    }

    @Override
    public PageInfo<Sassfeedback> selectAll(SassfeedbackExample sassfeedbackExample, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Sassfeedback> list = sassfeedbackDao.selectByExample(sassfeedbackExample);
        return new PageInfo(list);
    }

    @Override
    public void updateSassfeedback(Sassfeedback sassfeedback) {
        sassfeedbackDao.updateByPrimaryKey(sassfeedback);
    }
}

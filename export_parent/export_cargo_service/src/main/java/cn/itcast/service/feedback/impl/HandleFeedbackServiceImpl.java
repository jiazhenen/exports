package cn.itcast.service.feedback.impl;

import cn.itcast.dao.feedback.FeedbackDao;
import cn.itcast.domain.cargo.ContractProduct;
import cn.itcast.domain.feedback.Feedback;
import cn.itcast.domain.feedback.FeedbackExample;
import cn.itcast.service.feedback.HandleFeedbackService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class HandleFeedbackServiceImpl implements HandleFeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;

    @Override
    public void save(Feedback feedback) {

    }

    @Override
    public void update(Feedback feedback) {

    }

    @Override
    public void delete(String id) {

    }




    @Override
    public Feedback findById(String id) {
        return feedbackDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Feedback> findAll(FeedbackExample example) {
        return feedbackDao.selectByExample(example);
    }



    @Override
    public PageInfo<Feedback> selectAll(FeedbackExample example, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Feedback> list = feedbackDao.selectByExample(example);
        return new PageInfo(list);
    }

    @Override
    public Object selectFeedbackById(String id) {
        return feedbackDao.selectByPrimaryKey(id);
    }



    @Override
    public void deleteFeedback(String id) {
        feedbackDao.deleteByPrimaryKey(id);
    }





    @Override
    public void addFeedback(Feedback feedback) {
        feedbackDao.insertSelective(feedback);
    }

    @Override
    public void updateFeedback(Feedback feedback) {
        feedbackDao.updateByPrimaryKeySelective(feedback);
    }
}

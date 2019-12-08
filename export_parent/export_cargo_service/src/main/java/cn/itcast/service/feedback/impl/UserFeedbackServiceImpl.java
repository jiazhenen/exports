package cn.itcast.service.feedback.impl;

import cn.itcast.dao.feedback.UserFeedbackDao;
import cn.itcast.domain.cargo.Shipping;
import cn.itcast.domain.feedback.Feedback;
import cn.itcast.domain.feedback.FeedbackExample;
import cn.itcast.domain.systemback.Systemback;
import cn.itcast.service.feedback.UserFeedbackService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.bouncycastle.jce.provider.JDKMessageDigest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

@Service
public class UserFeedbackServiceImpl implements UserFeedbackService {

    @Autowired
    private UserFeedbackDao userFeedbackDao;

    @Override
    public void save(Feedback feedback) {
//        System.out.println(feedback.getFeedbackId())

        userFeedbackDao.save(feedback);
    }

    @Override
    public void update(Feedback feedback) {

        userFeedbackDao.updateByPrimaryKey(feedback);
    }

    @Override
    public void delete(String id) {
        userFeedbackDao.deleteByPrimaryKey(id);
    }

    @Override
    public Feedback findById(String id) {
         return  userFeedbackDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Feedback> findAll(FeedbackExample example) {
        return  userFeedbackDao.selectByExample(example);
    }




    @Override
    public void updateFeedback(Feedback feedback) {
        userFeedbackDao.updateByPrimaryKeySelective(feedback);

    }

    @Override
    public PageInfo selectAll(FeedbackExample feedbackExample, Integer page, Integer pageSize) {

        PageHelper.startPage(page,pageSize);
        List list = userFeedbackDao.selectByExample(feedbackExample);
        return new PageInfo(list, 5);
    }

    @Override
    public Feedback selectFeedbackById(String id) {
        return userFeedbackDao.selectByPrimaryKey(id);
    }

    @Override
    public void addFeedback(Feedback feedback) {
        userFeedbackDao.insertSelective(feedback);
    }

    @Override
    public void deleteFeedback(String id) {
        userFeedbackDao.deleteByPrimaryKey(id);
    }
}

package cn.itcast.service.feedback.impl;

import cn.itcast.domain.feedback.Feedback;
import cn.itcast.domain.feedback.FeedbackExample;
import cn.itcast.service.feedback.UserFeedbackService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;

@Service
public class UserFeedbackServiceImpl implements UserFeedbackService {
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
        return null;
    }

    @Override
    public List<Feedback> findAll(FeedbackExample example) {
        return null;
    }

    @Override
    public void updateFeedback(Feedback feedback) {

    }

    @Override
    public PageInfo selectAll(FeedbackExample feedbackExample, Integer page, Integer pageSize) {
        return null;
    }

    @Override
    public Feedback selectFeedbackById(String id) {
        return null;
    }

    @Override
    public void addFeedback(Feedback feedback) {

    }

    @Override
    public void deleteFeedback(String id) {

    }
}

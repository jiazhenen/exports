package cn.itcast.service.feedback.impl;

import cn.itcast.domain.feedback.Feedback;
import cn.itcast.domain.feedback.FeedbackExample;
import cn.itcast.service.feedback.HandleFeedbackService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;

@Service
public class HandleFeedbackServiceImpl implements HandleFeedbackService {
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
    public PageInfo<Feedback> selectAll(FeedbackExample example, Integer page, Integer pageSize) {
        return null;
    }

    @Override
    public Object selectFeedbackById(String id) {
        return null;
    }

    @Override
    public void deleteFeedback(String id) {

    }

    @Override
    public void addFeedback(Feedback feedback) {

    }

    @Override
    public void updateFeedback(Feedback feedback) {

    }
}

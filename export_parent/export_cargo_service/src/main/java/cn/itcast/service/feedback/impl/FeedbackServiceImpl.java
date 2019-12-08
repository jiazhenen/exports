package cn.itcast.service.feedback.impl;

import cn.itcast.dao.feedback.FeedbackDao;
import cn.itcast.service.feedback.FeedbackService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;

    @Override
    public void deleteFeedback(String id) {
        feedbackDao.deleteByPrimaryKey(id);
    }
}

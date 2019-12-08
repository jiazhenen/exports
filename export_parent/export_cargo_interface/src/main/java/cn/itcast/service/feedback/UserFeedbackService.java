package cn.itcast.service.feedback;


import cn.itcast.domain.feedback.Feedback;
import cn.itcast.domain.feedback.FeedbackExample;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserFeedbackService {
    /**
     * 保存
     */
    void save(Feedback feedback);

    /**
     * 更新
     */
    void update(Feedback feedback);

    /**
     * 删除
     */
    void delete(String id);

    /**
     * 根据id查询
     */
    Feedback findById(String id);

    //查询所有
    public List<Feedback> findAll(FeedbackExample example);

    void updateFeedback(Feedback feedback);

    PageInfo selectAll(FeedbackExample feedbackExample, Integer page, Integer pageSize);

    Feedback selectFeedbackById(String id);

    void addFeedback(Feedback feedback);

    void deleteFeedback(String id);
}

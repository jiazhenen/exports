package cn.itcast.service.feedback;


import cn.itcast.domain.feedback.Feedback;
import cn.itcast.domain.feedback.FeedbackExample;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface HandleFeedbackService {
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

    PageInfo<Feedback> selectAll(FeedbackExample example, Integer page, Integer pageSize);

    Object selectFeedbackById(String id);

    void deleteFeedback(String id);

    void addFeedback(Feedback feedback);

    void updateFeedback(Feedback feedback);
}

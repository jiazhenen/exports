package cn.itcast.service.feedback;

import cn.itcast.domain.feedback.Feedback;
import cn.itcast.domain.feedback.FeedbackExample;

import java.util.List;

public interface FeedbackService {
  /*  *//**
     * 保存
     *//*
    void save(Feedback feedback);

    *//**
     * 更新
     *//*
    void update(Feedback feedback);

    *//**
     * 删除
     *//*
    void delete(String id);

    *//**
     * 根据id查询
     *//*
    Feedback findById(String id);

    //查询所有
    public List<Feedback> findAll(FeedbackExample example);*/

    void deleteFeedback(String id);
}

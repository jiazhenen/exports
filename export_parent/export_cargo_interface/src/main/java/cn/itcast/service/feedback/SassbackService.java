package cn.itcast.service.feedback;

import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.cargo.FactoryExample;
import cn.itcast.domain.systemback.Sassfeedback;
import cn.itcast.domain.systemback.SassfeedbackExample;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SassbackService {
    /**
     * 保存
     */
    void save(Factory factory);

    /**
     * 更新
     */
    void update(Factory factory);

    /**
     * 删除
     */
    void delete(String id);

    /**
     * 根据id查询
     */
    Factory findById(String id);

    //查询所有
    public List<Factory> findAll(FactoryExample example);

    Sassfeedback selectSassfeedbackById(String id);

    void addSassfeedback(Sassfeedback sassfeedback);

    PageInfo<Sassfeedback> selectAll(SassfeedbackExample sassfeedbackExample, Integer pageNum, Integer pageSize);

    void updateSassfeedback(Sassfeedback sassfeedback);
}

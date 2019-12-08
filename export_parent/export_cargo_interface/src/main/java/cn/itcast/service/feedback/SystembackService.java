package cn.itcast.service.feedback;

import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.cargo.FactoryExample;
import cn.itcast.domain.systemback.Systemback;
import cn.itcast.domain.systemback.SystembackExample;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SystembackService {
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

    PageInfo<Systemback> selectAll(SystembackExample example, Integer pageNum, Integer pageSize);

    Systemback selectSystembackById(String id);

    void updateSystemback(Systemback systemback);

    void deleteSystemback(String id);

    void addSystemback(Systemback systemback);

}

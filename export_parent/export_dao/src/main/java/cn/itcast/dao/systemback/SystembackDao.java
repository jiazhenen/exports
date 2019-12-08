package cn.itcast.dao.systemback;

import cn.itcast.domain.systemback.Systemback;
import cn.itcast.domain.systemback.SystembackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystembackDao {
    long countByExample(SystembackExample example);

    int deleteByExample(SystembackExample example);

    int deleteByPrimaryKey(String systembackId);

    int insert(Systemback record);

    int insertSelective(Systemback record);

    List<Systemback> selectByExample(SystembackExample example);

    Systemback selectByPrimaryKey(String systembackId);

    int updateByExampleSelective(@Param("record") Systemback record, @Param("example") SystembackExample example);

    int updateByExample(@Param("record") Systemback record, @Param("example") SystembackExample example);

    int updateByPrimaryKeySelective(Systemback record);

    int updateByPrimaryKey(Systemback record);

}
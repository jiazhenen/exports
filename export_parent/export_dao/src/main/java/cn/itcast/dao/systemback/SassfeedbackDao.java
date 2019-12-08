package cn.itcast.dao.systemback;

import cn.itcast.domain.systemback.Sassfeedback;
import cn.itcast.domain.systemback.SassfeedbackExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SassfeedbackDao {
    long countByExample(SassfeedbackExample example);

    int deleteByExample(SassfeedbackExample example);

    int deleteByPrimaryKey(String sassfeedId);

    int insert(Sassfeedback record);

    int insertSelective(Sassfeedback record);

    List<Sassfeedback> selectByExample(SassfeedbackExample example);

    Sassfeedback selectByPrimaryKey(String sassfeedId);

    int updateByExampleSelective(@Param("record") Sassfeedback record, @Param("example") SassfeedbackExample example);

    int updateByExample(@Param("record") Sassfeedback record, @Param("example") SassfeedbackExample example);

    int updateByPrimaryKeySelective(Sassfeedback record);

    int updateByPrimaryKey(Sassfeedback record);
}
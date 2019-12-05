package cn.itcast.dao.cargo;


import cn.itcast.domain.cargo.Invoice;
import cn.itcast.domain.cargo.InvoiceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvoiceDao {
    long countByExample(InvoiceExample example);

    int deleteByExample(InvoiceExample example);

    int deleteByPrimaryKey(String invoiceId);

    int insert(Invoice record);

    int insertSelective(Invoice record);

    List<Invoice> selectByExample(InvoiceExample example);

    Invoice selectByPrimaryKey(String invoiceId);

    int updateByExampleSelective(@Param("record") Invoice record, @Param("example") InvoiceExample example);

    int updateByExample(@Param("record") Invoice record, @Param("example") InvoiceExample example);

    int updateByPrimaryKeySelective(Invoice record);

    int updateByPrimaryKey(Invoice record);
}
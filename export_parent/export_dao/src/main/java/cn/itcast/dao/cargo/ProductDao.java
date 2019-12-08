package cn.itcast.dao.cargo;

import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.cargo.Product;
import cn.itcast.domain.cargo.ProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Factory> findAll();

}
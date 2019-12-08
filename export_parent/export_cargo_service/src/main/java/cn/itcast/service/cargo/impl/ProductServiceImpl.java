package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.ProductDao;
import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.cargo.Product;
import cn.itcast.domain.cargo.ProductExample;
import cn.itcast.service.cargo.ProductService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public long countByExample(ProductExample example) {
        return productDao.countByExample(example);
    }

    @Override
    public int deleteByExample(ProductExample example) {
        return productDao.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return productDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Product record) {
        return productDao.insert(record);
    }

    @Override
    public int insertSelective(Product record) {
        return productDao.insertSelective(record);
    }

    @Override
    public List<Product> selectByExample(ProductExample example) {
        return productDao.selectByExample(example);
    }

    @Override
    public Product selectByPrimaryKey(String id) {
        return productDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Product record, ProductExample example) {
        return productDao.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Product record, ProductExample example) {
        return productDao.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return productDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return productDao.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Factory> list =  productDao.findAll();
        return new PageInfo(list,5);
    }
}

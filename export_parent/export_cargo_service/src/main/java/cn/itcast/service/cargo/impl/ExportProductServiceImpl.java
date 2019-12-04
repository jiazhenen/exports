package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.ExportProductDao;
import cn.itcast.domain.cargo.ExportProduct;
import cn.itcast.domain.cargo.ExportProductExample;
import cn.itcast.service.cargo.ExportProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;

@Service
public class ExportProductServiceImpl implements ExportProductService {


    @Autowired
    private ExportProductDao exportProductDao;
    @Override
    public ExportProduct findById(String id) {
        return exportProductDao.selectByPrimaryKey(id);
    }

    @Override
    public void save(ExportProduct exportProduct) {
        exportProductDao.insertSelective(exportProduct);
    }

    @Override
    public void update(ExportProduct exportProduct) {
        exportProductDao.updateByPrimaryKeySelective(exportProduct);
    }

    @Override
    public void delete(String id) {
        exportProductDao.deleteByPrimaryKey(id);
    }


    public PageInfo findAll(ExportProductExample exportProductExample, int page, int size) {
        PageHelper.startPage(page,size);
        List<ExportProduct> list = exportProductDao.selectByExample(exportProductExample);
        return new PageInfo(list);
    }

    @Override
    public List<ExportProduct> findByExportId(String id) {
        ExportProductExample exportProductExample = new ExportProductExample();
        exportProductExample.createCriteria().andExportIdEqualTo(id);
        return exportProductDao.selectByExample(exportProductExample);
    }
}

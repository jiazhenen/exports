package cn.itcast.service.cargo;


import cn.itcast.domain.cargo.ExportProduct;
import cn.itcast.domain.cargo.ExportProductExample;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface ExportProductService {

	ExportProduct findById(String id);

	void save(ExportProduct exportProduct);

	void update(ExportProduct exportProduct);

	void delete(String id);

	PageInfo findAll(ExportProductExample exportProductExample, int page, int size);

    List<ExportProduct> findByExportId(String id);
}

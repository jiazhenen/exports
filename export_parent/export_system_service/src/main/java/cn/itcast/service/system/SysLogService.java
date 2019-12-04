package cn.itcast.service.system;

import cn.itcast.domain.system.SysLog;
import com.github.pagehelper.PageInfo;

public interface SysLogService {

    void save(SysLog sysLog);

    PageInfo findPage(String companyId, int pageNum, int pageSize);
}

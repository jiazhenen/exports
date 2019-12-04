package cn.itcast.dao.system;

import cn.itcast.domain.system.SysLog;

import java.util.List;

public interface SysLogDao {
    public List<SysLog> findAll(String companyId);
    public void save(SysLog sysLog);
}

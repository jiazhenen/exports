package cn.itcast.domain.system;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysLog implements Serializable {
  private String id;
  private String userName;//操作人用户名
  private String ip;// 操作用的ip地址
  private Date time; //操作时间
  private String method; //操作方法名
  private String action; //方法上RequestMapping注解的name值
  private String companyId;
  private String companyName;
}

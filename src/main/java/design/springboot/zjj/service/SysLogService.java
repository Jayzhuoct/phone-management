package design.springboot.zjj.service;

import design.springboot.zjj.entity.Syslog;

import java.util.List;

public interface SysLogService {
    int addLog(Syslog syslog);
    List<Syslog>getAllLog();
    List<Syslog> getLogByLike(String name);
}

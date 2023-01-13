package design.springboot.zjj.service.impl;

import design.springboot.zjj.entity.Syslog;
import design.springboot.zjj.mapper.SysLogMapper;
import design.springboot.zjj.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    SysLogMapper sysLogMapper;
    @Override
    public int addLog(Syslog syslog) {
        return sysLogMapper.addLog(syslog);
    }

    @Override
    public List<Syslog> getAllLog() {
        return sysLogMapper.getAllLog();
    }

    @Override
    public List<Syslog> getLogByLike(String name) {
        return sysLogMapper.getLogByLike(name);
    }
}

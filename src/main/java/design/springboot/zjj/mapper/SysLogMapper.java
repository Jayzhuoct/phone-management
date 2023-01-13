package design.springboot.zjj.mapper;

import design.springboot.zjj.entity.Syslog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysLogMapper {
    int addLog(Syslog syslog);
    List<Syslog> getAllLog();
    List<Syslog> getLogByLike(@Param("name") String name);
}

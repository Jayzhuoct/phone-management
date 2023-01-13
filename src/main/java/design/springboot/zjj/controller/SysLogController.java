package design.springboot.zjj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import design.springboot.zjj.annotation.MyLog;
import design.springboot.zjj.entity.Syslog;
import design.springboot.zjj.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SysLogController {
    @Autowired
    SysLogService sysLogService;
    @MyLog(value = "查看日志")
    @RequestMapping("/sysloglist")
    public String SysLog(@RequestParam("page")int page,
                         Model model) {
        PageHelper.startPage(page, 15);
        List<Syslog> syslogs = sysLogService.getAllLog();
        PageInfo<Syslog> pageInfo = new PageInfo<>(syslogs);
        model.addAttribute("syslogs", syslogs);
        model.addAttribute("pageInfo", pageInfo);
        return "syslog-list";
    }
    @MyLog(value = "搜索日志")
    @RequestMapping(value = "/sysloglike",method = RequestMethod.POST)
    public String SysLogLike(@RequestParam("name")String name,
                             Model model) {
        PageHelper.startPage(1, 15);
        List<Syslog> syslogs = sysLogService.getLogByLike(name);
        PageInfo<Syslog> pageInfo = new PageInfo<>(syslogs);
        model.addAttribute("syslogs", syslogs);
        model.addAttribute("pageInfo", pageInfo);
        return "syslog-list";
    }
}

package design.springboot.zjj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import design.springboot.zjj.annotation.MyLog;
import design.springboot.zjj.entity.Market;
import design.springboot.zjj.entity.Repertory;
import design.springboot.zjj.entity.Syslog;
import design.springboot.zjj.entity.Type;
import design.springboot.zjj.service.MarketService;
import design.springboot.zjj.service.RepertoryService;
import design.springboot.zjj.service.SysLogService;
import design.springboot.zjj.service.TypeService;
import design.springboot.zjj.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Controller
public class ExcelController {
    @Value("${file.upload.path}")
    private String readpath;
    @Value("${file.download.path}")
    private String writepath;
    @Autowired
    TypeService typeService;
    @Autowired
    MarketService marketService;
    @Autowired
    RepertoryService repertoryService;
    @Autowired
    SysLogService sysLogService;
    @MyLog(value = "导入手机型号信息")
    @PostMapping("/readType")
    public String readType(@RequestPart MultipartFile file,
                           Model model) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = readpath + fileName;
        File dest = new File(filePath);
        Files.copy(file.getInputStream(), dest.toPath());
        List<Type> list = ExcelUtil.readType(dest.getPath());
        if (typeService.insertTypes(list) == 0) {
            model.addAttribute("msg", "导入失败");
        }
        PageHelper.startPage(1,10);
        List<Type>types=typeService.getTypeAll();
        PageInfo<Type> pageInfo = new PageInfo<>(types);
        model.addAttribute("types",types);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("msg", "导入成功");
        return "type-list";
    }
    @MyLog(value = "导出手机型号信息")
    @GetMapping("/writeType")
    public String writeType(Model model) throws IOException {
        List<Type> list = typeService.getTypeAll();
        String filePath = writepath + "type.xlsx";
        if (ExcelUtil.writeType(list, filePath) !=1) {
            model.addAttribute("msg", "导出失败!");
        }
        PageHelper.startPage(1,10);
        List<Type>types=typeService.getTypeAll();
        PageInfo<Type> pageInfo = new PageInfo<>(types);
        model.addAttribute("types",types);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("msg", "导出成功!");
        return "type-list";
    }
    @MyLog(value = "导入手机销售信息")
    @PostMapping("/readMarket")
    public String readMarket(@RequestPart MultipartFile file,
                             Model model) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = readpath + fileName;
        File dest = new File(filePath);
        Files.copy(file.getInputStream(), dest.toPath());
        List<Market> list = ExcelUtil.readMarket(dest.getPath());
        if (marketService.insertMarkets(list) == 0) {
            model.addAttribute("msg", "导入失败");
        }
        PageHelper.startPage(1,10);
        List<Market>markets=marketService.getMarketAll();
        PageInfo<Market> pageInfo = new PageInfo<>(markets);
        model.addAttribute("markets",markets);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("msg", "导入成功");
        return "market-list";
    }
    @MyLog(value = "导出手机销售信息")
    @GetMapping("/writeMarket")
    public String writeMarket(Model model) throws IOException {
        List<Market> list = marketService.getMarketAll();
        String filePath = writepath + "market.xlsx";
        if (ExcelUtil.writeMarket(list, filePath) !=1) {
            model.addAttribute("msg", "导出失败!");
        }
        PageHelper.startPage(1,10);
        List<Market>markets=marketService.getMarketAll();
        PageInfo<Market> pageInfo = new PageInfo<>(markets);
        model.addAttribute("markets",markets);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("msg", "导出成功!");
        return "market-list";
    }
    @MyLog(value = "导入手机库存信息")
    @PostMapping("/readRepertory")
    public String readRepertory(@RequestPart MultipartFile file,
                                Model model) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = readpath + fileName;
        File dest = new File(filePath);
        Files.copy(file.getInputStream(), dest.toPath());
        List<Repertory> list = ExcelUtil.readRepertory(dest.getPath());
        if (repertoryService.insertRepertories(list) == 0) {
            model.addAttribute("msg", "导入失败");
        }
        PageHelper.startPage(1,10);
        List<Repertory>repertories=repertoryService.getRepertoryAll();
        PageInfo<Repertory> pageInfo = new PageInfo<>(repertories);
        model.addAttribute("repertorys",repertories);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("msg", "导入成功");
        return "repertory-list";
    }
    @MyLog(value = "导出手机库存信息")
    @GetMapping("/writeRepertory")
    public String writeRepertory(Model model) throws IOException {
        List<Repertory> list = repertoryService.getRepertoryAll();
        String filePath = writepath + "repertory.xlsx";
        if (ExcelUtil.writeRepertory(list, filePath) !=1) {
            model.addAttribute("msg", "导出失败!");
        }
        PageHelper.startPage(1,10);
        List<Repertory>repertories=repertoryService.getRepertoryAll();
        PageInfo<Repertory> pageInfo = new PageInfo<>(repertories);
        model.addAttribute("repertorys",repertories);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("msg", "导出成功!");
        return "repertory-list";
    }
    @MyLog(value = "导出操作日志")
    @GetMapping("/writeLog")
    public String writeLog(Model model) throws IOException {
        List<Syslog> list = sysLogService.getAllLog();
        String filePath = writepath + "syslog.xlsx";
        if (ExcelUtil.writeLog(list, filePath) !=1) {
            model.addAttribute("msg", "导出失败!");
        }
        PageHelper.startPage(1,10);
        List<Syslog>logs=sysLogService.getAllLog();
        PageInfo<Syslog> pageInfo = new PageInfo<>(logs);
        model.addAttribute("syslogs",logs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("msg", "导出成功!");
        return "syslog-list";
    }

}

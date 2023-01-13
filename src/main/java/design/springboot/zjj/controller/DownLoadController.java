package design.springboot.zjj.controller;

import design.springboot.zjj.annotation.MyLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@Controller
public class DownLoadController {
    @MyLog(value = "跳转到下载文件")
    @RequestMapping("/download")
    public String todownload(){
        return "down";
    }
    @MyLog(value = "下载手机型号文件")
    @GetMapping("/d1")
    @ResponseBody
    public String downLoad1 (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realPath = "src/main/resources/file/Type.xlsx";
        File file = new File(realPath);
        String filename = file.getName();
        response.setHeader("content-disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
        InputStream in = new FileInputStream(file);
        byte[] buf = new byte[1024];
        while (in.read(buf) > 0) {
            response.getOutputStream().write(buf, 0, buf.length);
        }
        in.close();
        return "welcome";
    }
    @MyLog(value = "下载手机销售文件")
    @GetMapping("/d2")
    @ResponseBody
    public String downLoad2 (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realPath = "src/main/resources/file/Market.xlsx";
        File file = new File(realPath);
        String filename = file.getName();
        response.setHeader("content-disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
        InputStream in = new FileInputStream(file);
        byte[] buf = new byte[1024];
        while (in.read(buf) > 0) {
            response.getOutputStream().write(buf, 0, buf.length);
        }
        in.close();
        return "welcome";
    }
    @MyLog(value = "下载手机库存文件")
    @GetMapping("/d3")
    @ResponseBody
    public String downLoad3 (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realPath = "src/main/resources/file/Repertory.xlsx";
        File file = new File(realPath);
        String filename = file.getName();
        response.setHeader("content-disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
        InputStream in = new FileInputStream(file);
        byte[] buf = new byte[1024];
        while (in.read(buf) > 0) {
            response.getOutputStream().write(buf, 0, buf.length);
        }
        in.close();
        return "welcome";
    }
}

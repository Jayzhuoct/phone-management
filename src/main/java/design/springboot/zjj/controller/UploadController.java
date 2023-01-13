package design.springboot.zjj.controller;

import design.springboot.zjj.annotation.MyLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class UploadController {

    @Value("${file.upload.path}")
    private String path;
    @MyLog(value = "跳转到上传文件页面")
    @GetMapping("/up")
    public String uploadPage() {
        return "upload";
    }
    @MyLog(value = "上传文件")
    @PostMapping("/upload")
    @ResponseBody
    public String create(@RequestPart MultipartFile file, Model model) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = path + fileName;
        File dest = new File(filePath);
        Files.copy(file.getInputStream(), dest.toPath());
        return "Upload file success : " + dest.getAbsolutePath();
    }

}
package design.springboot.zjj.controller;

import design.springboot.zjj.annotation.MyLog;
import design.springboot.zjj.entity.Admin;
import design.springboot.zjj.entity.User;
import design.springboot.zjj.service.AdminService;
import design.springboot.zjj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Controller
public class LoginController {
    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;
    @MyLog(value = "显示登陆页面")
    @RequestMapping(value = "/")
    public String login() {
        return "login";
    }
    @MyLog(value = "显示登陆页面")
    @RequestMapping("/login")
    public String tologin(){
        return "login";
    }
    @MyLog(value = "显示欢迎页面")
    @RequestMapping("/welcome")
    public String welcome(){return "welcome";}
    @MyLog(value = "用户登录")
    @RequestMapping("/check")
    public String check(@RequestParam("choice")String choice,
                        @RequestParam("name")String name,
                        @RequestParam("password")String password,
                        Model model, HttpSession httpSession,
                        HttpServletRequest request){
        System.out.println(choice);
        System.out.println(name);
        System.out.println(password);
        if ("admin".equals(choice)){
            Admin admin = new Admin();
            admin = adminService.getAdminByName(name);
            System.out.println(admin.getaName());
            System.out.println(admin.getKey());
            if (admin.getaName().equals(name)&&admin.getKey().equals(password)){
                httpSession.setAttribute("name",name);
                request.setAttribute("name",name);
                model.addAttribute("name",name);
                return "admin";
            }else{
                model.addAttribute("msg","账号或密码错误！");
                return "login";
            }
        }
        if("user".equals(choice)){
            User user = new User();
            user=userService.getUserByName(name);
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            if (user.getUsername().equals(name)&&user.getPassword().equals(password)){
                httpSession.setAttribute("name",name);
                request.setAttribute("name",name);
                model.addAttribute("name",name);
            return "user";}
            else {
                model.addAttribute("msg","账号或密码错误！");
                return "login";
            }
        }else {
            model.addAttribute("msg","账号或密码空！");
            return "login";
        }
    }
    @MyLog(value = "退出登录")
    @RequestMapping("/out")
    public String out() {
        return "redirect:/login";
    }
    @MyLog(value = "生成验证码")
    @RequestMapping("/image")
    public void code(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedImage bi=new BufferedImage(78, 30,BufferedImage.TYPE_INT_RGB);
        Graphics g=bi.getGraphics();
        Color c=new Color(192,192,192);
        g.setColor(c);
        g.fillRect(0, 0, 78,30);
        g.setFont(new Font("Times New Roman", Font.PLAIN,22));
        char[] ch="ABCDEFGHJKMNPQRSTUVWXYZ23456789".toCharArray();
        Random r=new Random();
        int len=ch.length;
        int index;
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<4;i++)
        {
            index=r.nextInt(len);
            g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
            g.drawString(ch[index]+"",(i*15)+10, 22);
            sb.append(ch[index]);
        }
        request.getSession().setAttribute("code",sb.toString());
        ImageIO.write(bi, "JPG", response.getOutputStream());
    }

}

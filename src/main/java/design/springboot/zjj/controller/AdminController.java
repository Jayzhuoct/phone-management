package design.springboot.zjj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import design.springboot.zjj.annotation.MyLog;
import design.springboot.zjj.entity.Admin;
import design.springboot.zjj.entity.User;
import design.springboot.zjj.service.AdminService;
import design.springboot.zjj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;
    @MyLog(value = "查询所有管理员")
    @RequestMapping("/adminlist")
    public String adminlist(@RequestParam("page")int page,
                            Model model){
        PageHelper.startPage(page,10);
        List<Admin>admins=adminService.getAdminAll();
        PageInfo<Admin> pageInfo = new PageInfo<>(admins);
        model.addAttribute("admins",admins);
        model.addAttribute("pageInfo", pageInfo);
        return "admin-list";
    }
    @MyLog(value = "跳转到添加管理员页面")
    @RequestMapping("/adminadd")
    public String toadminadd(){
        return "admin-add";
    }
    @MyLog(value = "添加管理员")
    @RequestMapping(value = "/admin-add",method = RequestMethod.POST)
    public String adminadd(Admin admin, Model model){
        if (adminService.insertAdmin(admin)==0){
            model.addAttribute("msg","添加失败");
            return "welcome";
        }
        admins(model);
        return "admin-list";
    }
    @MyLog(value = "跳转到修改管理员页面")
    @RequestMapping("/adminedit")
    public String toadminedit(@RequestParam("aName") String aName,Model model){
        model.addAttribute("admin",adminService.getAdminByName(aName));
        return "admin-edit";
    }
    @MyLog(value = "修改管理员")
    @RequestMapping(value = "/admin-edit",method = RequestMethod.POST)
    public String adminedit(Admin admin,Model model){
        if (adminService.updateAdmin(admin)==0){
            model.addAttribute("msg","修改失败");
            return "welcome";
        }
        admins(model);
        return "admin-list";
    }
    @MyLog(value = "删除管理员")
    @RequestMapping("/admindelete")
    public String admindelete(@RequestParam("aId") int aId,Model model){
        if (adminService.delAdmin(aId)==0){
            model.addAttribute("msg","删除失败");
            return "welcome";
        }
        admins(model);
        return "admin-list";
    }
    @MyLog(value = "查询所有用户")
    @RequestMapping("/userlist")
    public String userlist(@RequestParam("page")int page,
                           Model model){
        PageHelper.startPage(page,10);
        List<User>users=userService.getUserAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        model.addAttribute("users",users);
        model.addAttribute("pageInfo", pageInfo);
        return "user-list";
    }
    @MyLog(value = "删除用户")
    @RequestMapping("/userdelete")
    public String userdelete(@RequestParam("uId") int uId,Model model){
        if (userService.delUser(uId)==0){
            model.addAttribute("msg","删除失败");
            return "welcome";
        }
        users(model);
        return "user-list";
    }
    @MyLog(value = "跳转到修改用户页面")
    @RequestMapping("/useredit")
    public String touseredit(@RequestParam("username") String username,Model model){
        model.addAttribute("user",userService.getUserByName(username));
        return "user-edit";
    }
    @RequestMapping(value = "/user-edit",method = RequestMethod.POST)
    public String useredit(User user, Model model){
        if (userService.updateUser(user)==0){
            model.addAttribute("msg","修改失败");
            return "welcome";
        }
        users(model);
        return "user-list";
    }
    @MyLog(value = "跳转到添加用户页面")
    @RequestMapping("/useradd")
    public String touseradd(){
        return "user-add";
    }
    @MyLog(value = "添加用户")
    @RequestMapping(value = "/user-add",method = RequestMethod.POST)
    public String useradd(User user, Model model){
        if (userService.insertUser(user)==0){
            model.addAttribute("msg","添加失败");
            return "welcome";
        }
        users(model);
        return "user-list";
    }

    private void admins(Model model){
        PageHelper.startPage(1,10);
        List<Admin>admins=adminService.getAdminAll();
        PageInfo<Admin> pageInfo = new PageInfo<>(admins);
        model.addAttribute("admins",admins);
        model.addAttribute("pageInfo", pageInfo);
    }
    private void users(Model model){
        PageHelper.startPage(1,10);
        List<User>users=userService.getUserAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        model.addAttribute("users",users);
        model.addAttribute("pageInfo", pageInfo);
    }

}

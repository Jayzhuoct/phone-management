package design.springboot.zjj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import design.springboot.zjj.annotation.MyLog;
import design.springboot.zjj.entity.Repertory;
import design.springboot.zjj.service.RepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RepertoryController {
    @Autowired
    RepertoryService repertoryService;
    @MyLog(value = "查询所有手机库存")
    @RequestMapping("/repertorylist")
    public String repertorylist(@RequestParam("page")int page,
                                Model model){
        PageHelper.startPage(page,10);
        List<Repertory>repertories=repertoryService.getRepertoryAll();
        PageInfo<Repertory> pageInfo = new PageInfo<>(repertories);
        model.addAttribute("repertorys",repertories);
        model.addAttribute("pageInfo", pageInfo);
        return "repertory-list";
    }
    @MyLog(value = "库存模糊查询")
    @RequestMapping("/repertoryfound")
    public String repertoryfound(@RequestParam("name") String name,Model model){
        PageHelper.startPage(1,10);
        List<Repertory>repertories=repertoryService.getRepertoryByLike(name);
        PageInfo<Repertory> pageInfo = new PageInfo<>(repertories);
        model.addAttribute("repertorys",repertories);
        model.addAttribute("pageInfo", pageInfo);
        return "repertory-list";
    }
    @MyLog(value = "跳转到添加库存页面")
    @RequestMapping("/repertoryadd")
    public String torepertoryadd(){
        return "repertory-add";
    }
    @MyLog(value = "添加库存")
    @RequestMapping("/repertory-add")
    public String repertoryadd(Repertory repertory,Model model){
        if (repertoryService.insertRepertory(repertory)==0){
            model.addAttribute("msg","添加失败");
            return "welcome";
        }
        list(model);
        return "repertory-list";
    }
    @MyLog(value = "跳转到修改库存页面")
    @RequestMapping("/repertoryedit")
    public String torepertoryedit(@RequestParam("pName") String pName,Model model){
        model.addAttribute("repertory",repertoryService.getRepertoryByName(pName));
        return "repertory-edit";
    }
    @MyLog(value = "修改手机库存")
    @RequestMapping("/repertory-edit")
    public String repertoryedit(Repertory repertory,Model model){
        if (repertoryService.updateRepertory(repertory)==0){
            model.addAttribute("msg","修改失败");
            return "welcome";
        }
        list(model);
        return "repertory-list";
    }
    @MyLog(value = "删除手机库存")
    @RequestMapping("/repertorydelete")
    public String repertorydelete(@RequestParam("pName") String pName,Model model){
        if (repertoryService.delRepertory(pName)==0){
            model.addAttribute("msg","删除失败");
            return "welcome";
        }
        list(model);
        return "repertory-list";
    }
    private void list(Model model){
        PageHelper.startPage(1,10);
        List<Repertory>repertories=repertoryService.getRepertoryAll();
        PageInfo<Repertory> pageInfo = new PageInfo<>(repertories);
        model.addAttribute("repertorys",repertories);
        model.addAttribute("pageInfo", pageInfo);
    }
}

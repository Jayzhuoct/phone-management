package design.springboot.zjj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import design.springboot.zjj.annotation.MyLog;
import design.springboot.zjj.entity.Type;
import design.springboot.zjj.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypeController {
    @Autowired
    TypeService typeService;
    @MyLog(value = "查询所有手机型号")
    @RequestMapping("/typelist")
    public String typelist(@RequestParam("page")int page,
                           Model model){
        PageHelper.startPage(page,10);
        List<Type>types=typeService.getTypeAll();
        PageInfo<Type> pageInfo = new PageInfo<>(types);
        model.addAttribute("types",types);
        model.addAttribute("pageInfo", pageInfo);
        return "type-list";
    }
    @MyLog(value = "手机型号模糊查询")
    @RequestMapping("/typefound")
    public String typefound(Model model,
                            @RequestParam("name") String name){
        List<Type>types=typeService.getTypeByLike(name);
        PageHelper.startPage(1,10);
        PageInfo<Type> pageInfo = new PageInfo<>(types);
        model.addAttribute("types",types);
        model.addAttribute("pageInfo", pageInfo);
        return "type-list";
    }
    @MyLog(value = "跳转到添加手机型号页面")
    @RequestMapping("/typeadd")
    public String totypeadd(){
        return "type-add";
    }
    @MyLog(value = "添加手机型号")
    @RequestMapping(value = "/type-add",method = RequestMethod.POST)
    public String typeadd(Type type,Model model){
        if (typeService.insertType(type)==0){
            model.addAttribute("msg","添加失败");
            return "welcome";
        }
        list(model);
        return "type-list";
    }
    @MyLog(value = "跳转到修改手机型号页面")
    @RequestMapping("/typeedit")
    public String totypeedit(@RequestParam("pId") int pId,Model model){
        Type type=typeService.getTypeById(pId);
        model.addAttribute("type",type);
        return "type-edit";
    }
    @MyLog(value = "修改手机型号")
    @RequestMapping(value = "/type-edit",method = RequestMethod.POST)
    public String typeedit(Type type,Model model){
        if (typeService.updateType(type)==0){
            model.addAttribute("msg","修改失败");
            return "welcome";
        }
        list(model);
        return "type-list";
    }
    @MyLog(value = "删除手机型号")
    @RequestMapping("/typedel")
    public String typedel(@RequestParam("pId") int pId,Model model){
        if (typeService.delType(pId)==0){
            model.addAttribute("msg","删除失败");
            return "welcome";
        }
        list(model);
        return "type-list";
    }
    private void list(Model model){
        PageHelper.startPage(1,10);
        List<Type>types=typeService.getTypeAll();
        PageInfo<Type> pageInfo = new PageInfo<>(types);
        model.addAttribute("types",types);
        model.addAttribute("pageInfo", pageInfo);
    }
}

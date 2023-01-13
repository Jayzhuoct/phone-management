package design.springboot.zjj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import design.springboot.zjj.annotation.MyLog;
import design.springboot.zjj.entity.Market;
import design.springboot.zjj.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MarketController {
    @Autowired
    MarketService marketService;
    @MyLog(value = "查询所有手机销售")
    @RequestMapping("/marketlist")
    public String marketlist(@RequestParam("page")int page,
                             Model model){
        PageHelper.startPage(page,10);
        List<Market>markets=marketService.getMarketAll();
        PageInfo<Market> pageInfo = new PageInfo<>(markets);
        model.addAttribute("markets",markets);
        model.addAttribute("pageInfo", pageInfo);
        return "market-list";
    }
    @MyLog(value = "手机销售模糊查询")
    @RequestMapping("/marketfound")
    public String marketfound(@RequestParam("name") String name,Model model){
        PageHelper.startPage(1,10);
        List<Market>markets=marketService.getMarketByLike(name);
        PageInfo<Market> pageInfo = new PageInfo<>(markets);
        model.addAttribute("markets",markets);
        model.addAttribute("pageInfo", pageInfo);
        return "market-list";
    }
    @MyLog(value = "跳转到添加手机销售页面")
    @RequestMapping("/marketadd")
    public String tomarketadd(){
        return "market-add";
    }
    @MyLog(value = "添加手机销售信息")
    @RequestMapping(value = "/market-add",method = RequestMethod.POST)
    public String marketadd(Market market,Model model){
        if (marketService.insertMarket(market)==0){
            model.addAttribute("msg","添加失败");
            return "welcome";
        }
        list(model);
        return "market-list";
    }
    @MyLog(value = "跳转到修改手机销售页面")
    @RequestMapping("/marketedit")
    public String tomarketedit(@RequestParam("pName") String pName,Model model){
        model.addAttribute("market",marketService.getMarketByName(pName));
        return "market-edit";
    }
    @MyLog(value = "修改手机销售信息")
    @RequestMapping(value = "/market-edit",method = RequestMethod.POST)
    public String marketedit(Market market,Model model){
        if (marketService.updateMarket(market)==0){
            model.addAttribute("msg","修改失败");
            return "welcome";
        }
        list(model);
        return "market-list";
    }
    @MyLog(value = "删除手机销售信息")
    @RequestMapping("/marketdelete")
    public String marketdelete(@RequestParam("pName") String pName,Model model){
        if (marketService.delMarket(pName)==0){
            model.addAttribute("msg","删除失败");
            return "welcome";
        }
        list(model);
        return "market-list";
    }
    private void list(Model model){
        PageHelper.startPage(1,10);
        List<Market>markets=marketService.getMarketAll();
        PageInfo<Market> pageInfo = new PageInfo<>(markets);
        model.addAttribute("markets",markets);
        model.addAttribute("pageInfo", pageInfo);
    }


}

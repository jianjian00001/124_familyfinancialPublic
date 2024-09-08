package com.xust.ffms.controller;


import com.xust.ffms.entity.Curaccount;
import com.xust.ffms.entity.UserInfo;
import com.xust.ffms.service.CuraccountService;
import com.xust.ffms.utils.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping("/curaccount")
public class CuraccountController {
    @Resource
    private CuraccountService curaccountService;



    @RequestMapping("/getBillsByWhere/{pageNo}/{pageSize}")
    public Result<Curaccount> getBillsByWhere(Curaccount curaccount, @PathVariable int pageNo, @PathVariable int pageSize, HttpSession session){
        curaccount = getHouseBill(curaccount,session);
        PageModel model = new PageModel<>(pageNo,curaccount);
        model.setPageSize(pageSize);
        return curaccountService.findByWhere(model);
    }



    private Curaccount getHouseBill(Curaccount bill, HttpSession session) {
        UserInfo currentUser = Config.getSessionUser(session);
        //当登录用户为家主时，查询默认查询全家账单情况
        //当登录用户为普通用户时，仅查询当前用户的账单
        if (currentUser.getRoleid() == 2){
            bill.setHouseid(currentUser.getHouseid());
        }else if (currentUser.getRoleid() == 3){
            bill.setUserid(currentUser.getId());
        }
        return bill;
    }

    @RequestMapping(value = "/addBill",method = RequestMethod.POST)
    public Result add(Curaccount curaccount, HttpSession session){
        if (Config.getSessionUser(session)!=null){
            curaccount.setUserid(Config.getSessionUser(session).getId());
            curaccount.setHouseid(Config.getSessionUser(session).getHouseid());
        }
        Utils.log(curaccount.toString());
        try {
            int num = curaccountService.add(curaccount);
            if(num>0){
                int billid = curaccount.getId();
                curaccount = new Curaccount();
                curaccount.setId(billid);
                return ResultUtil.success("记录成功！",curaccountService.findByWhereNoPage(curaccount));
//                return ResultUtil.success("记账成功！",bill);
            }else {
                return ResultUtil.unSuccess();
            }
        }catch (Exception e){
            return ResultUtil.error(e);
        }
    }

    @RequestMapping("/updateBill")
    public Result update(Curaccount curaccount, HttpSession session){
        if (Config.getSessionUser(session)!=null){
            curaccount.setUserid(Config.getSessionUser(session).getId());
            curaccount.setHouseid(Config.getSessionUser(session).getHouseid());
        }
        Utils.log(curaccount.toString());
        int num = curaccountService.update(curaccount);
        if(num>0){
            return ResultUtil.success("修改成功！",null);
        }else {
            return ResultUtil.unSuccess();
        }
    }

    @RequestMapping("/delBill")
    public Result del(int id){
        try {
            int num = curaccountService.del(id);
            if(num>0){
                return ResultUtil.success("删除成功！",null);
            }else {
                return ResultUtil.unSuccess();
            }
        }catch (Exception e){
            return ResultUtil.error(e);
        }
    }

    @RequestMapping("/getMoney")
    public Result getMoney(HttpSession session){
        Integer userid = null;
        if (Config.getSessionUser(session)!=null){
            userid = Config.getSessionUser(session).getId();
        }
        String moneyStr = curaccountService.getMoney(userid);
        Double money = Double.valueOf(moneyStr==null ? "0" : moneyStr);
        double v = 0.3;
        Double s = money * v;
        HashMap<String, Double> map = new HashMap<>();
        map.put("money", money);
        map.put("money3", s);
        return ResultUtil.success(map);
    }


}


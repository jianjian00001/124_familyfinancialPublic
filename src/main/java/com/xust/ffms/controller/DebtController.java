package com.xust.ffms.controller;

import com.xust.ffms.entity.Debt;
import com.xust.ffms.entity.UserInfo;
import com.xust.ffms.service.DebtService;
import com.xust.ffms.utils.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/debt")
public class DebtController {

    @Resource
    private DebtService debtService;


    @RequestMapping("/getBillsByWhere/{pageNo}/{pageSize}")
    public Result<Debt> getBillsByWhere(Debt debt, @PathVariable int pageNo, @PathVariable int pageSize, HttpSession session){
        debt = getHouseBill(debt,session);
        PageModel model = new PageModel<>(pageNo,debt);
        model.setPageSize(pageSize);
        return debtService.findByWhere(model);
    }



    private Debt getHouseBill(Debt bill, HttpSession session) {
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
    public Result add(Debt debt, HttpSession session){
        if (Config.getSessionUser(session)!=null){
            debt.setUserid(Config.getSessionUser(session).getId());
            debt.setHouseid(Config.getSessionUser(session).getHouseid());
        }
        Utils.log(debt.toString());
        try {
            int num = debtService.add(debt);
            if(num>0){
                int billid = debt.getId();
                debt = new Debt();
                debt.setId(billid);
                return ResultUtil.success("记录成功！",debtService.findByWhereNoPage(debt));
//                return ResultUtil.success("记账成功！",bill);
            }else {
                return ResultUtil.unSuccess();
            }
        }catch (Exception e){
            return ResultUtil.error(e);
        }
    }

    @RequestMapping("/updateBill")
    public Result update(Debt debt, HttpSession session){
        if (Config.getSessionUser(session)!=null){
            debt.setUserid(Config.getSessionUser(session).getId());
            debt.setHouseid(Config.getSessionUser(session).getHouseid());
        }
        Utils.log(debt.toString());
        int num = debtService.update(debt);
        if(num>0){
            return ResultUtil.success("修改成功！",null);
        }else {
            return ResultUtil.unSuccess();
        }
    }

    @RequestMapping("/delBill")
    public Result del(int id){
        try {
            int num = debtService.del(id);
            if(num>0){
                return ResultUtil.success("删除成功！",null);
            }else {
                return ResultUtil.unSuccess();
            }
        }catch (Exception e){
            return ResultUtil.error(e);
        }
    }

}


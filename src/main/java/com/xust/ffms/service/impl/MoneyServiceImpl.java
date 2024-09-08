package com.xust.ffms.service.impl;

import com.xust.ffms.dao.MoneyManageMapper;
import com.xust.ffms.entity.MoneyManage;
import com.xust.ffms.service.MoneyManageService;
import com.xust.ffms.utils.PageModel;
import com.xust.ffms.utils.Result;
import com.xust.ffms.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyServiceImpl implements MoneyManageService {
    @Autowired
    MoneyManageMapper mapper;
    @Override
    public Result<MoneyManage> findByWhere(PageModel model) {

            List<MoneyManage> bills = mapper.findByWhere(model);
            if (bills.size()>=0){
                Result<MoneyManage> result = ResultUtil.success(bills);
                result.setTotal(mapper.getTotalByWhere(model));
                if (result.getTotal() == 0) {
                    result.setMsg("没有查到相关数据");
                } else {
                    result.setMsg("数据获取成功");
                }
                return result;
            }else {
                return ResultUtil.unSuccess("获取数据失败！");
            }
    }

    @Override
    public int add(MoneyManage moneyManage) {
        return mapper.add(moneyManage);
    }

    @Override
    public int update(MoneyManage moneyManage) {
        return mapper.update(moneyManage);
    }

    @Override
    public int del(int id) {
        return mapper.del(id);
    }

    @Override
    public Result<MoneyManage> findByWhereNoPage(MoneyManage moneyManage) {
        List<MoneyManage> bills = mapper.findByWhereNoPage(moneyManage);
        if (bills.size()>=0){
            Result<MoneyManage> result = ResultUtil.success(bills);
            result.setMsg("数据获取成功");
            return result;
        }else {
            return ResultUtil.unSuccess("没有找到符合条件的属性！");
        }
    }
}

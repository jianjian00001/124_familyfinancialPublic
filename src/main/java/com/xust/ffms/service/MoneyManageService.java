package com.xust.ffms.service;

import com.xust.ffms.entity.MoneyManage;
import com.xust.ffms.utils.PageModel;
import com.xust.ffms.utils.Result;

public interface MoneyManageService {

    Result<MoneyManage> findByWhere(PageModel model);

    int add(MoneyManage moneyManage);

    int update(MoneyManage moneyManage);

    int del(int id);

    Result<MoneyManage> findByWhereNoPage(MoneyManage moneyManage);
}

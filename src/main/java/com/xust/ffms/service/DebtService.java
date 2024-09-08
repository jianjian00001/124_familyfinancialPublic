package com.xust.ffms.service;

import com.xust.ffms.entity.Debt;
import com.xust.ffms.utils.PageModel;
import com.xust.ffms.utils.Result;

public interface DebtService{

    Result<Debt> findByWhere(PageModel model);

    int add(Debt debt);

    int update(Debt debt);

    int del(int id);

    Result<Debt> findByWhereNoPage(Debt debt);
}

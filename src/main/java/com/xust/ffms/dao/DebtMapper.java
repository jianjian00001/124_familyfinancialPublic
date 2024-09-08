package com.xust.ffms.dao;


import com.xust.ffms.entity.Bill;
import com.xust.ffms.entity.Debt;
import com.xust.ffms.utils.PageModel;

import java.util.List;

public interface DebtMapper{
    int add(Debt debt);

    int update(Debt debt);

    int del(int id);

    List<Debt> findByWhere(PageModel<Debt> model);

    List<Debt> findByWhereNoPage(Debt model);

    int getTotalByWhere(PageModel<Bill> model);

}

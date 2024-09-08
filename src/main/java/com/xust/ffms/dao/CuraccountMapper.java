package com.xust.ffms.dao;


import com.xust.ffms.entity.Bill;
import com.xust.ffms.entity.Curaccount;
import com.xust.ffms.utils.PageModel;

import java.util.List;

public interface CuraccountMapper{
    int add(Curaccount curaccount);

    int update(Curaccount curaccount);

    int del(int id);

    List<Curaccount> findByWhere(PageModel<Curaccount> model);

    List<Curaccount> findByWhereNoPage(Curaccount model);

    int getTotalByWhere(PageModel<Bill> model);

    Curaccount queryOneByBill(Bill bill);

    String getMoney(Integer userid);
}

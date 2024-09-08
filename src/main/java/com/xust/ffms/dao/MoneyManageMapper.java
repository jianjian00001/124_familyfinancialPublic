package com.xust.ffms.dao;


import com.xust.ffms.entity.Bill;
import com.xust.ffms.entity.MoneyManage;
import com.xust.ffms.utils.PageModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoneyManageMapper {

    int add(MoneyManage moneyManage);

    int update(MoneyManage moneyManage);

    int del(int id);

    List<MoneyManage> findByWhere(PageModel<MoneyManage> model);

   List<MoneyManage> findByWhereNoPage(MoneyManage model);

    int getTotalByWhere(PageModel<Bill> model);


}

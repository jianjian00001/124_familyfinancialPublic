package com.xust.ffms.dao;


import com.xust.ffms.entity.Bill;
import com.xust.ffms.entity.Payway;
import com.xust.ffms.utils.PageModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BillMapper {

    int add(Bill bill);

    int update(Bill bill);

    int del(int id);

    List<Bill> findByWhere(PageModel<Bill> model);

    List<Bill> findByWhereNoPage(Bill model);

    int getTotalByWhere(PageModel<Bill> model);

    List<Map<String,Float>> getMonthlyInfo(PageModel<Bill> model);

    List<Payway> getAllPayways();

    /**
     * 返回今日支出总额
     * @return
     */
    Integer getTodayPayMoney(@Param("nowTime") String nowTime);
}

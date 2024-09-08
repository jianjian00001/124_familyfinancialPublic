package com.xust.ffms.service;


import com.xust.ffms.entity.Bill;
import com.xust.ffms.entity.Payway;
import com.xust.ffms.entity.Product;
import com.xust.ffms.utils.PageModel;
import com.xust.ffms.utils.Result;

import java.util.List;
import java.util.Map;

public interface BillService {

    int add(Bill bill);

    int update(Bill bill);

    int del(int id);

    Result<Bill> findByWhere(PageModel model);

    Result<Bill> findByWhereNoPage(Bill bill);

    List<Payway> getAllPayways();

    List<Map<String,Float>>  getMonthlyInfo(PageModel<Bill> model);

    Result<Product> getProducts(PageModel model);

    int delProduct(int id);

    int addProduct(Product product);

    Result<Product>  findProductfPage(Product product);

    int updateProduct(Product product);

    /**
     * 返回今日支出总额
     * @return
     */
    Integer getExpensesBill();
}

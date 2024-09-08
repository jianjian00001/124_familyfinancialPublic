package com.xust.ffms.service.impl;

import com.xust.ffms.dao.BillMapper;
import com.xust.ffms.dao.CuraccountMapper;
import com.xust.ffms.dao.ProductMapper;
import com.xust.ffms.entity.Bill;
import com.xust.ffms.entity.Curaccount;
import com.xust.ffms.entity.Payway;
import com.xust.ffms.entity.Product;
import com.xust.ffms.service.BillService;
import com.xust.ffms.utils.PageModel;
import com.xust.ffms.utils.Result;
import com.xust.ffms.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class BillServiceImpl implements BillService {

    @Resource
    private BillMapper mapper;
    @Resource
    private CuraccountMapper curaccountMapper;
    @Autowired
    ProductMapper productMapper;

    @Override
    public int add(Bill bill) {
        Curaccount curaccount = curaccountMapper.queryOneByBill(bill);
        if (curaccount != null) {
            if (bill.getTypeid() == 1)//支出
            {
                curaccount.setMoney(curaccount.getMoney().subtract(bill.getMoney()));
            } else {
                curaccount.setMoney(curaccount.getMoney().add(bill.getMoney()));
            }
            curaccountMapper.update(curaccount);
        } else {
            Curaccount curaccount1 = new Curaccount();
            curaccount1.setHouseid(bill.getHouseid());
            curaccount1.setUserid(bill.getUserid());
            curaccount1.setName("家庭资产");
            curaccount1.setRemark("无");
            if (bill.getTypeid() == 1)//支出
            {
                curaccount1.setMoney(new BigDecimal(0).subtract(bill.getMoney()));
            } else {
                curaccount1.setMoney(new BigDecimal(0).add(bill.getMoney()));
            }
            curaccountMapper.add(curaccount1);
        }
        return mapper.add(bill);
    }

    @Override
    public int addProduct(Product product) {
        return productMapper.add(product);
    }

    public static void main(String[] args) {
        System.out.println(new BigDecimal(0).add(new BigDecimal(100)));
    }

    @Override
    public int update(Bill bill) {
        return mapper.update(bill);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.update(product);
    }

    @Override
    public int del(int id) {
        return mapper.del(id);
    }

    @Override
    public Result<Bill> findByWhere(PageModel model) {
        try {
            List<Bill> bills = mapper.findByWhere(model);
            if (bills.size() >= 0) {
                Result<Bill> result = ResultUtil.success(bills);
                result.setTotal(mapper.getTotalByWhere(model));
                if (result.getTotal() == 0) {
                    result.setMsg("没有查到相关数据");
                } else {
                    result.setMsg("数据获取成功");
                }
                return result;
            } else {
                return ResultUtil.unSuccess("获取数据失败！");
            }
        } catch (Exception e) {
            return ResultUtil.error(e);
        }
    }

    @Override
    public Result<Product> getProducts(PageModel model) {
        try {
            List<Product> products = productMapper.getProducts(model);
            if (products.size() >= 0) {
                Result<Product> result = ResultUtil.success(products);
                result.setTotal(productMapper.getProductsTotal(model));
                if (result.getTotal() == 0) {
                    result.setMsg("没有查到相关数据");
                } else {
                    result.setMsg("数据获取成功");
                }
                return result;
            } else {
                return ResultUtil.unSuccess("获取数据失败！");
            }
        } catch (Exception e) {
            return ResultUtil.error(e);
        }
    }

    @Override
    public int delProduct(int id) {
        return productMapper.del(id);
    }


    @Override
    public Result<Bill> findByWhereNoPage(Bill bill) {
        try {
            List<Bill> bills = mapper.findByWhereNoPage(bill);
            if (bills.size() >= 0) {
                Result<Bill> result = ResultUtil.success(bills);
                result.setMsg("数据获取成功");
                return result;
            } else {
                return ResultUtil.unSuccess("没有找到符合条件的属性！");
            }
        } catch (Exception e) {
            return ResultUtil.error(e);
        }
    }

    @Override
    public Integer getExpensesBill() {
        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(nowTime);
        return mapper.getTodayPayMoney(format);
    }

    @Override
    public Result<Product> findProductfPage(Product product) {
        try {
            List<Product> bills = productMapper.findByWhereNoPage(product);
            if (bills.size() >= 0) {
                Result<Product> result = ResultUtil.success(bills);
                result.setMsg("数据获取成功");
                return result;
            } else {
                return ResultUtil.unSuccess("没有找到符合条件的属性！");
            }
        } catch (Exception e) {
            return ResultUtil.error(e);
        }
    }


    @Override
    public List<Payway> getAllPayways() {
        return mapper.getAllPayways();
    }

    @Override
    public List<Map<String, Float>> getMonthlyInfo(PageModel<Bill> model) {
        return mapper.getMonthlyInfo(model);
    }

}

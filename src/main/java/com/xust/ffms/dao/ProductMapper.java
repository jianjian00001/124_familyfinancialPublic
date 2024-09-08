package com.xust.ffms.dao;

import com.xust.ffms.entity.Product;
import com.xust.ffms.utils.PageModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    List<Product> getProducts(PageModel model);

    Integer getProductsTotal(PageModel model);

    int del(int id);

    int add(Product product);

    List<Product> findByWhereNoPage(Product product);

    int update(Product product);
}

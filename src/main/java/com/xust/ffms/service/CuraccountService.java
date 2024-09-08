package com.xust.ffms.service;


import com.xust.ffms.entity.Curaccount;
import com.xust.ffms.utils.PageModel;
import com.xust.ffms.utils.Result;

public interface CuraccountService{
    Result<Curaccount> findByWhere(PageModel model);

    int add(Curaccount curaccount);

    int update(Curaccount curaccount);

    int del(int id);

    Result<Curaccount> findByWhereNoPage(Curaccount curaccount);

    String getMoney(Integer userid);
}

package com.czxy.order.service;

import com.czxy.order.domain.Order;
import com.czxy.order.domain.PagingVo;
import com.github.pagehelper.PageInfo;

public interface OrderService {
    PageInfo<Order> findAll(Integer uid, PagingVo pagingVo);
}

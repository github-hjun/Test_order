package com.czxy.order.service.impl;

import com.czxy.order.domain.Order;
import com.czxy.order.domain.PagingVo;
import com.czxy.order.mapper.OrderMapper;
import com.czxy.order.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class OrderServiceimpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public PageInfo<Order> findAll(Integer uid, PagingVo pagingVo) {
        PageHelper.startPage(pagingVo.getPageNum(),pagingVo.getPageSize());

        if (pagingVo.getBeginTime()!=null && !"".equals(pagingVo.getBeginTime())){
            pagingVo.setBeginTime(pagingVo.getBeginTime()+" 00:00:00");
        }
        if (pagingVo.getEndTime()!=null && !"".equals(pagingVo.getEndTime())){
            pagingVo.setEndTime(pagingVo.getEndTime()+" 23:59:59");
        }
        if (pagingVo.getTotalPrice()!=null && !"".equals(pagingVo.getTotalPrice())){
            pagingVo.setTotalPrice("%"+pagingVo.getTotalPrice()+"%");
        }

        List<Order> list = orderMapper.findAll(uid,pagingVo);
        return new PageInfo<>(list);
    }
}

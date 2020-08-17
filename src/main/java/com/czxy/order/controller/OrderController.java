package com.czxy.order.controller;

import com.czxy.order.domain.Order;
import com.czxy.order.domain.PagingVo;
import com.czxy.order.domain.User;
import com.czxy.order.service.OrderService;
import com.czxy.order.service.UserService;
import com.czxy.order.vo.BaseResult;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private UserService userService;

    @Resource
    private OrderService orderService;
    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping
        public ResponseEntity<User> login(@RequestBody User user){
       return userService.login(user);
    }

    /**
     * 根据用户uid查询所有
     * @param uid
     * @return
     */
    @PostMapping("/{uid}")
    public BaseResult findAll(@PathVariable("uid") Integer uid, @RequestBody  PagingVo pagingVo){
        System.out.println(uid);
        System.out.println(pagingVo);
      PageInfo<Order> olist= orderService.findAll(uid,pagingVo);
      return BaseResult.ok("查询成功",olist);
    }
}

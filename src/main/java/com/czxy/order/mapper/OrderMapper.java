package com.czxy.order.mapper;

import com.czxy.order.domain.Order;
import com.czxy.order.domain.PagingVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderMapper extends Mapper<Order> {
    @Select("<script> select * from t_order where uid=#{uid} " +
            "<if test=\" pagingVo.status!=null and pagingVo.status!='' \"> and status=#{pagingVo.status} </if>" +
            "<if test=\" pagingVo.beginTime!=null and pagingVo.beginTime!='' \"> and create_time >= #{pagingVo.beginTime} </if>" +
            "<if test=\" pagingVo.endTime!=null and pagingVo.endTime!='' \">  <![CDATA[ and create_time <= #{pagingVo.endTime}]]> </if>" +
            "<if test=\" pagingVo.totalPrice!=null and pagingVo.totalPrice!='' \"> and total_price like #{pagingVo.totalPrice} </if>"+
            "</script>")
    @Results({
            @Result(property = "oid",column = "oid"),
            @Result(property = "create_time",column = "create_time"),
            @Result(property = "total_price",column = "total_price"),
            @Result(property = "status",column = "STATUS"),
            @Result(property = "uid",column = "uid"),
    })
    List<Order> findAll(@Param("uid") Integer uid,@Param("pagingVo")PagingVo pagingVo);
}

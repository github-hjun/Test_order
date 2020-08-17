package com.czxy.order.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Table(name = "t_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    private  String     oid ;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date    create_time ;//#创建时间
    private Double  total_price;//#总价
    @Column(name = "STATUS")
    private Integer  status ;//#订单状态（0-未付款，1-已付款，2-已发货，3-已收货，4-结束）
    private Integer  uid;//#用户表外键

    private List<OrderItem> olist;

}

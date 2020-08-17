package com.czxy.order.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_order_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderItem {
     @Id
    private String    iid ;
    private String     title ;//#商品的标题
    private Double      price ;//#商品的单价
    private Integer       COUNT ;//#购买的数量
    private String       order_id ;//#所属订单

}

package com.czxy.order.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PagingVo {
    private Integer pageNum;  //当前页
    private Integer pageSize; //每页展示几条数据
    private String  status;  //订单状态
    private String  beginTime;//开始时间
    private  String  endTime ;//结束时间
    private String totalPrice;//总金额

}

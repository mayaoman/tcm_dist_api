package com.yention.tcm.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.yention.tcm.api.entities.OrderEntity;
import com.yention.tcm.api.services.OrderService;

/** 
 * @Package com.yention.tcm.api.controllers
 * @ClassName: OrderController
 * @Description: 用户订单核心控制类
 * @author 孙刚
 * @date 2019年4月19日 上午10:38:46
 */
@RestController
@RequestMapping("/wechat/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	/**
	 * @Title: getOrderList
	 * @Description: 获取用户的订单列表
	 * @param openid
	 * @return List<Map<String,Object>>   
	 */
	@RequestMapping(path="/list", method=RequestMethod.GET)
    public @ResponseBody Map<String,Object> getOrderList(String openid) {
		
		List<OrderEntity> dfkOrders = orderService.findByUserIdAndStatus(openid, "待付款");
		List<OrderEntity> dshOrders = orderService.findByUserIdAndStatus(openid, "待收货");
		List<OrderEntity> ywcOrders = orderService.findByUserIdAndStatus(openid, "已完成");
		List<OrderEntity> allOrders = orderService.findByUserId(openid);
		
		System.out.println("openid:"+openid);
		Map<String,Object> orderList = new HashMap<String,Object>();
		orderList.put("ywc", JSON.toJSON(ywcOrders));
		orderList.put("all", JSON.toJSON(allOrders));
		orderList.put("dfk", JSON.toJSON(dfkOrders));
		orderList.put("dsh", JSON.toJSON(dshOrders));
		System.out.println("ywcOrders:"+JSON.toJSON(orderList));
        return orderList;
    }
}

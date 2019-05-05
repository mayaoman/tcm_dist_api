package com.yention.tcm.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yention.tcm.api.repositories.OrderRepository;

/** 
 * @Package com.yention.tcm.api.services
 * @ClassName: OrderService
 * @Description: 订单业务处理类
 * @author 孙刚
 * @date 2019年4月27日 下午9:59:01
 */
@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
}

package com.yention.tcm.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yention.tcm.api.entities.OrderEntity;
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
	
	/**
	 * @Title: findByUserIdAndStatus
	 * @Description: 根据用户和订单状态查询订单
	 * @param userId
	 * @param status
	 * @return List<OrderEntity>   
	 */
	public List<OrderEntity> findByUserIdAndStatus(String userId,String status){
		return orderRepository.findByUserIdAndStatus(userId, status);
	}
	
	/**
	 * @Title: findByUserId
	 * @Description: 根据用户查询全部订单
	 * @param userId
	 * @return List<OrderEntity>   
	 */
	public List<OrderEntity> findByUserId(String userId){
		return orderRepository.findByUserId(userId);
	}
	
	/**
	 * @Title: getOrderById
	 * @Description: 根据订单编号获取订单详情
	 * @param orderId
	 * @return OrderEntity   
	 */
	public OrderEntity getOrderById(String orderId){
		return orderRepository.getOne(orderId);
	}
}

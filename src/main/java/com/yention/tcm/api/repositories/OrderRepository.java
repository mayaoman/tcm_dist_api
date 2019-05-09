package com.yention.tcm.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yention.tcm.api.entities.OrderEntity;

/** 
 * @Package com.yention.tcm.api.repositories
 * @ClassName: OrderRepository
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 孙刚
 * @date 2019年4月26日 下午9:02:28
 */
public interface OrderRepository extends JpaRepository<OrderEntity, String> {
	
	/**
	 * @Title: findByUserIdAndStatus
	 * @Description: 根据用户和订单状态查询订单
	 * @param userId
	 * @param status
	 * @return List<OrderEntity>   
	 */
	public List<OrderEntity> findByUserIdAndStatus(String userId,String status);
}

package com.yention.tcm.api.repositories;

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

}

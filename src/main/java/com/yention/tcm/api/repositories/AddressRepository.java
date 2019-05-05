package com.yention.tcm.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yention.tcm.api.entities.AddressEntity;

/** 
 * @Package com.yention.tcm.api.repositories
 * @ClassName: AddressRepository
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 孙刚
 * @date 2019年4月26日 下午8:57:44
 */
public interface AddressRepository extends JpaRepository<AddressEntity, String> {
	/**
	 * @Title: findByUserId
	 * @Description: 查询用户的收货地址
	 * @param userId
	 * @return List<AddressEntity>   
	 */
	public List<AddressEntity> findByUserId(String userId);
}

package com.yention.tcm.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yention.tcm.api.entities.PatientEntity;

/** 
 * @Package com.yention.tcm.api.repositories
 * @ClassName: PatientRepository
 * @Description: 就诊人数据处理类
 * @author 孙刚
 * @date 2019年4月26日 下午9:03:18
 */
public interface PatientRepository extends JpaRepository<PatientEntity, String> {
	
	/**
	 * @Title: findByUserId
	 * @Description: 根据公众号ID获取就诊人列表
	 * @param userId
	 * @return List<PatientEntity>   
	 */
	public List<PatientEntity> findByUserId(String userId);
}

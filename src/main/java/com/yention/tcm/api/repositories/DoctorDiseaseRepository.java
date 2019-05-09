package com.yention.tcm.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yention.tcm.api.entities.DoctorDiseaseEntity;

/** 
 * @Package com.yention.tcm.api.repositories
 * @ClassName: DoctorDiseaseRepository
 * @Description: 医生擅长专业数据处理类
 * @author 孙刚
 * @date 2019年4月26日 下午9:00:27
 */
public interface DoctorDiseaseRepository extends JpaRepository<DoctorDiseaseEntity, String> {
	/**
	 * @Title: findByDoctorId
	 * @Description: 根据医生查询擅长的病症
	 * @param doctorId
	 * @return List<DoctorDiseaseEntity>   
	 */
	public List<DoctorDiseaseEntity> findByDoctorId(String doctorId);
}

package com.yention.tcm.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yention.tcm.api.entities.DoctorEntity;
import com.yention.tcm.api.repositories.DoctorRepository;

/** 
 * @Package com.yention.tcm.api.services
 * @ClassName: DoctorService
 * @Description: 医生业务处理类
 * @author 孙刚
 * @date 2019年4月27日 下午9:57:41
 */
@Service
public class DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;
	
	/**
	 * @Title: queryAllDoctor
	 * @Description: 获取所有医生列表
	 * @return List<DoctorEntity>   
	 */
	public List<DoctorEntity> queryAllDoctor(){
		return doctorRepository.findAll();
	}
	
	/**
	 * @Title: queryDoctorByDisease
	 * @Description: 根据擅长的病症获取医生
	 * @param diseaseId
	 * @return List<DoctorEntity>   
	 */
	public List<DoctorEntity> queryDoctorByDisease(String diseaseId){
		return null;
	}
}

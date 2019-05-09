package com.yention.tcm.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yention.tcm.api.entities.AddressEntity;
import com.yention.tcm.api.entities.DoctorDiseaseEntity;
import com.yention.tcm.api.repositories.DoctorDiseaseRepository;

/** 
 * @Package com.yention.tcm.api.services
 * @ClassName: DoctorDiseaseService
 * @Description: 医生擅长专业业务类
 * @author 孙刚
 * @date 2019年4月27日 下午9:56:46
 */
@Service
public class DoctorDiseaseService {
	@Autowired
	private DoctorDiseaseRepository doctorDiseaseRepository;
	
	/**
	 * @Title: queryDiseaseByDoctor
	 * @Description: 根据医生查询擅长的病症
	 * @param doctorId
	 * @return List<DoctorDiseaseEntity>   
	 */
	public List<DoctorDiseaseEntity> queryDiseaseByDoctor(String doctorId){
		return doctorDiseaseRepository.findByDoctorId(doctorId);
	}
}

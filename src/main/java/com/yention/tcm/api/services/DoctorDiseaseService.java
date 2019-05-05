package com.yention.tcm.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

package com.yention.tcm.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yention.tcm.api.repositories.PatientRepository;

/** 
 * @Package com.yention.tcm.api.services
 * @ClassName: PatientService
 * @Description: 就诊人业务处理类
 * @author 孙刚
 * @date 2019年4月27日 下午9:59:21
 */
@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
}

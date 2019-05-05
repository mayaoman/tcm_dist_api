package com.yention.tcm.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

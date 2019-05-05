package com.yention.tcm.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yention.tcm.api.repositories.MyDoctorRepository;

/** 
 * @Package com.yention.tcm.api.services
 * @ClassName: MyDoctorService
 * @Description: 我的医生业务处理类
 * @author 孙刚
 * @date 2019年4月27日 下午9:58:41
 */
@Service
public class MyDoctorService {
	@Autowired
	private MyDoctorRepository myDoctorRepository;
}

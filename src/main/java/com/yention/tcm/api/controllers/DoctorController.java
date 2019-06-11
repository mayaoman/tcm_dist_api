package com.yention.tcm.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yention.tcm.api.entities.DeptEntity;
import com.yention.tcm.api.entities.DiseaseEntity;
import com.yention.tcm.api.entities.DoctorEntity;
import com.yention.tcm.api.services.DiseaseService;
import com.yention.tcm.api.services.DoctorService;

/** 
 * @Package com.yention.tcm.api.controllers
 * @ClassName: DoctorController
 * @Description: 医生控制类
 * @author 孙刚
 * @date 2019年4月27日 下午10:30:57
 */
@RestController
@RequestMapping("/wechat/doctor")
public class DoctorController {
	@Autowired
	private DiseaseService diseaseService;
	@Autowired
	private DoctorService doctorService;
	
	/**
	 * @Title: queryAllDisease
	 * @Description: 获取全部科室和病症
	 * @return List<DeptEntity>   
	 */
	@RequestMapping(path="/queryAllDisease", method=RequestMethod.GET)
	public @ResponseBody List<DeptEntity> queryAllDisease(){
		return diseaseService.queryAll();
	}
	
	/**
	 * @Title: queryAllDoctor
	 * @Description: 获取所有医生列表
	 * @return List<DoctorEntity>   
	 */
	@RequestMapping(path="/queryAllDoctor", method=RequestMethod.GET)
	public @ResponseBody List<DoctorEntity> queryAllDoctor(){
		List<DoctorEntity> doctors = doctorService.queryAllDoctor();
		return doctors;
	}
	
	/**
	 * @Title: queryDoctorByDisease
	 * @Description: 根据病症获取医生列表
	 * @param diseaseId
	 * @return List<DoctorEntity>   
	 */
	@RequestMapping(path="/queryDoctorByDisease", method=RequestMethod.GET)
	public @ResponseBody List<DoctorEntity> queryDoctorByDisease(String diseaseId){
		DiseaseEntity disease = diseaseService.findDiseaseById(diseaseId);
		List<DoctorEntity> doctors = disease.getDoctorList();
		return doctors;
	}
	
	/**
	 * @Title: queryDoctorById
	 * @Description: 获取医生详情
	 * @param doctorId
	 * @return DoctorEntity   
	 */
	@RequestMapping(path="/queryDoctorById", method=RequestMethod.GET)
	public @ResponseBody DoctorEntity queryDoctorById(String doctorId){
		DoctorEntity doctor = doctorService.queryDoctorById(doctorId);
		return doctor;
	}
}



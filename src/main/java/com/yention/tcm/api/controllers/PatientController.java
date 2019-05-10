package com.yention.tcm.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yention.tcm.api.entities.PatientEntity;
import com.yention.tcm.api.services.PatientService;

/** 
 * @Package com.yention.tcm.api.controllers
 * @ClassName: PatientController
 * @Description: 就诊人控制类
 * @author 孙刚
 * @date 2019年4月27日 下午10:31:56
 */
@RestController
@RequestMapping("/wechat/patient")
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	/**
	 * @Title: getPatientByOpenId
	 * @Description: 根据公众号ID获取就诊人列表
	 * @param openId
	 * @return List<PatientEntity>   
	 */
	@RequestMapping(path="/list", method=RequestMethod.GET)
	public @ResponseBody List<PatientEntity> getPatientByOpenId(String openid){
		return patientService.getPatientByOpenId(openid);
	}
	
	/**
	 * @Title: save
	 * @Description: 新增就诊人
	 * @param patient
	 * @return boolean   
	 */
	@RequestMapping(path="/add", method=RequestMethod.POST)
	public @ResponseBody boolean save(@RequestBody PatientEntity patient){
		return patientService.savePatient(patient);
	}
	
	/**
	 * @Title: update
	 * @Description: 修改就诊人
	 * @param patient
	 * @return boolean   
	 */
	@RequestMapping(path="/update", method=RequestMethod.POST)
	public @ResponseBody boolean update(@RequestBody PatientEntity patient){
		return patientService.updatePatient(patient);
	}
	
	/**
	 * @Title: delete
	 * @Description: 删除就诊人
	 * @param patientId
	 * @return boolean   
	 */
	@RequestMapping(path="/delete", method=RequestMethod.GET)
	public @ResponseBody boolean delete(String patientId){
		return patientService.deletePatient(patientId);
	}
}

package com.yention.tcm.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yention.tcm.api.entities.AddressEntity;
import com.yention.tcm.api.entities.PatientEntity;
import com.yention.tcm.api.repositories.PatientRepository;
import com.yention.tcm.api.utils.GenerateID;

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
	
	/**
	 * @Title: getPatientByOpenId
	 * @Description: 根据公众号ID获取就诊人列表
	 * @param openId
	 * @return List<PatientEntity>   
	 */
	public List<PatientEntity> getPatientByOpenId(String openId){
		return patientRepository.findByUserId(openId);
	}
	
	/**
	 * @Title: savePatient
	 * @Description: 保存就诊人
	 * @param patient
	 * @return boolean   
	 */
	public boolean savePatient(PatientEntity patient){
		boolean result = false;
		String id = GenerateID.getID();
		patient.setPatientId(id);
		PatientEntity saveResult = patientRepository.saveAndFlush(patient);
		if (saveResult != null)
			result = true;
		return result;
	}
	
	/**
	 * @Title: deletePatient
	 * @Description: 删除就诊人
	 * @param patientId
	 * @return boolean   
	 */
	public boolean deletePatient(String patientId){
		try{
			patientRepository.deleteById(patientId);
		}catch (Exception e) {
			e.printStackTrace(); 
			return false;
		}
		return true;
	}
	
	/**
	 * @Title: updatePatient
	 * @Description: 修改就诊人
	 * @param patient
	 * @return boolean   
	 */
	public boolean updatePatient(PatientEntity patient){
		boolean result = false;
		PatientEntity saveResult = patientRepository.saveAndFlush(patient);
		if (saveResult != null)
			result = true;
		return result;
	}
}

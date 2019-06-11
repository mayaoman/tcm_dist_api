package com.yention.tcm.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yention.tcm.api.entities.DeptEntity;
import com.yention.tcm.api.entities.DiseaseEntity;
import com.yention.tcm.api.repositories.DeptRepository;
import com.yention.tcm.api.repositories.DiseaseRepository;

/** 
 * @Package com.yention.tcm.api.services
 * @ClassName: DiseaseService
 * @Description: 病症常量业务实现类
 * @author 孙刚
 * @date 2019年4月27日 下午9:46:12
 */
@Service
public class DiseaseService {
	@Autowired
	private DiseaseRepository diseaseRepository;
	
	@Autowired
	private DeptRepository deptRepository;
	
	/**
	 * @Title: queryAll
	 * @Description: 获取所有病症及科室
	 * @return List<DeptEntity>   
	 */
	public List<DeptEntity> queryAll(){
		return deptRepository.findAll();
	}
	
	/**
	 * @Title: findDiseaseById
	 * @Description: 根据ID获取病症信息
	 * @param diseaseId
	 * @return DiseaseEntity   
	 */
	public DiseaseEntity findDiseaseById(String diseaseId){
		return diseaseRepository.getOne(diseaseId);
	}
}

package com.yention.tcm.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yention.tcm.api.entities.DiseaseEntity;
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
	
	public List<DiseaseEntity> queryAll(){
		return diseaseRepository.findAll();
	}
}

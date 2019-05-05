package com.yention.tcm.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/** 
 * @Package com.yention.tcm.api.entities
 * @ClassName: DiseaseEntity
 * @Description: 病症常量实体类
 * @author 孙刚
 * @date 2019年4月26日 下午3:15:34
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "diseaseId") 
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer"})
@Table(name="tcm_patient")
public class DiseaseEntity {
	/**
	 * 病症ID
	 */
	@Id
	@Column(length=20)
	private String diseaseId;
	/**
	 * 科室
	 */
	@Column(length=50)
	private String dept;
	/**
	 * 病症名
	 */
	@Column(length=50)
	private String name;
	
	public String getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(String diseaseId) {
		this.diseaseId = diseaseId;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

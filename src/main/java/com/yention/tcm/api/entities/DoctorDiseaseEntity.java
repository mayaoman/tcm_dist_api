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
 * @ClassName: DoctorDisease
 * @Description: 医生擅长专业实体类
 * @author 孙刚
 * @date 2019年4月26日 下午5:55:41
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id") 
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer"})
@Table(name="tcm_doctor_disease")
public class DoctorDiseaseEntity {
	@Id
	@Column(length=20)
	private String id;
	
	@Column(length=20)
	private String doctorId;
	/**
	 * 擅长病症ID
	 */
	@Column(length=20)
	private String diseaseId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(String diseaseId) {
		this.diseaseId = diseaseId;
	}
}

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
 * @ClassName: DoctorEntity
 * @Description: 医生实体类
 * @author 孙刚
 * @date 2019年4月26日 下午3:23:53
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "doctorId") 
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer"})
@Table(name="tcm_patient")
public class DoctorEntity {
	@Id
	@Column(length=20)
	private String doctorId;
	/**
	 * 医生名
	 */
	@Column(length=50)
	private String name;
	/**
	 * 医生职称
	 */
	@Column(length=50)
	private String professionalTitle;
	/**
	 * 医生医院
	 */
	@Column(length=50)
	private String hospital;
	/**
	 * 医生头像
	 */
	@Column(length=128)
	private String headPortrait;
	/**
	 * 医生简介
	 */
	@Column(length=256)
	private String intro;
	/**
	 * 医生推荐语
	 */
	@Column(length=256)
	private String recommend;
	
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfessionalTitle() {
		return professionalTitle;
	}
	public void setProfessionalTitle(String professionalTitle) {
		this.professionalTitle = professionalTitle;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
}

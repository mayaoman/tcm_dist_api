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
 * @ClassName: patient
 * @Description: 就诊人实体类
 * @author 孙刚
 * @date 2019年4月26日 下午3:06:26
 */
@Entity
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer"})
@Table(name="tcm_patient")
public class PatientEntity {
	/**
	 * 就诊人编号
	 */
	@Id
	@Column(length=20)
	private String patientId;
	/**
	 * 用户ID
	 */
	@Column(length=50)
	private String userId;
	/**
	 * 与本人关系
	 */
	@Column(length=20)
	private String relation;
	/**
	 * 姓名
	 */
	@Column(length=20)
	private String name;
	/**
	 * 性别
	 */
	@Column(length=20)
	private String sex;
	/**
	 * 年龄
	 */
	@Column(length=20)
	private String age;
	/**
	 * 手机号
	 */
	@Column(length=20)
	private String phone;
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}

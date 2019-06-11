package com.yention.tcm.api.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/** 
 * @Package com.yention.tcm.api.entities
 * @ClassName: DiseaseEntity
 * @Description: 病症常量实体类
 * @author 孙刚
 * @date 2019年4月26日 下午3:15:34
 */
@Entity
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer"})
@Table(name="tcm_disease")
public class DiseaseEntity {
	/**
	 * 病症ID
	 */
	@Id
	@Column(length=20)
	private String diseaseId;
	
	/**
	 * 病症名
	 */
	@Column(length=50)
	private String name;
	
	/**
	 * 科室
	 */
	@JsonIgnoreProperties(value = { "diseaseList" })
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//可选属性optional=false,表示dept不能为空。删除病症，不影响科室
    @JoinColumn(name = "deptId")//设置在tcm_disease表中的关联字段(外键)
	private DeptEntity dept;
	
	//@JsonIgnoreProperties(value = { "diseaseList" })
	//@JsonManagedReference
	@ManyToMany(mappedBy = "diseaseList")
    private List<DoctorEntity> doctorList;
	
	public List<DoctorEntity> getDoctorList() {
		return doctorList;
	}
	public void setDoctorList(List<DoctorEntity> doctorList) {
		this.doctorList = doctorList;
	}
	public String getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(String diseaseId) {
		this.diseaseId = diseaseId;
	}
	public DeptEntity getDept() {
		return dept;
	}
	public void setDept(DeptEntity dept) {
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

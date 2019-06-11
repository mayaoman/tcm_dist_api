package com.yention.tcm.api.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/** 
 * @Package com.yention.tcm.api.entities
 * @ClassName: DoctorEntity
 * @Description: 医生实体类
 * @author 孙刚
 * @date 2019年4月26日 下午3:23:53
 */
@Entity
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer"})
@Table(name="tcm_doctor")
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
	
	//1、关系维护端，负责多对多关系的绑定和解除
    //2、@JoinTable注解的name属性指定关联表的名字，joinColumns指定外键的名字，关联到关系维护端(User)
    //3、inverseJoinColumns指定外键的名字，要关联的关系被维护端(Authority)
    //4、其实可以不使用@JoinTable注解，默认生成的关联表名称为主表表名+下划线+从表表名，
    //即表名为user_authority
    //关联到主表的外键名：主表名+下划线+主表中的主键列名,即user_id
    //关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,即authority_id
    //主表就是关系维护端对应的表，从表就是关系被维护端对应的表
	@JsonIgnoreProperties(value = { "doctorList" })
//	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "tcm_doctor_disease",joinColumns = @JoinColumn(name = "doctorId"),inverseJoinColumns = @JoinColumn(name = "diseaseId"))
    private List<DiseaseEntity> diseaseList;
	
	public List<DiseaseEntity> getDiseaseList() {
		return diseaseList;
	}
	public void setDiseaseList(List<DiseaseEntity> diseaseList) {
		this.diseaseList = diseaseList;
	}
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

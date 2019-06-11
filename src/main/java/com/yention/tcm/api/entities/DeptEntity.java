package com.yention.tcm.api.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/** 
 * @Package com.yention.tcm.api.entities
 * @ClassName: DeptEntity
 * @Description: 科室实体类
 * @author 孙刚
 * @date 2019年5月14日 下午4:40:20
 */
@Entity
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer"})
@Table(name="tcm_dept")
public class DeptEntity {
	/**
	 * 科室ID
	 */
	@Id
	@Column(length=20)
	private String deptId;
	/**
	 * 科室名
	 */
	@Column(length=50)
	private String name;
	
    //级联保存、更新、删除、刷新;延迟加载。当删除用户，会级联删除该用户的所有文章
    //拥有mappedBy注解的实体类为关系被维护端
     //mappedBy="dept"中的dept是DiseaseEntity中的dept属性
	@OneToMany(mappedBy="dept", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DiseaseEntity> diseaseList;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<DiseaseEntity> getDiseaseList() {
//		return diseaseList;
//	}
//
//	public void setDiseaseList(List<DiseaseEntity> diseaseList) {
//		this.diseaseList = diseaseList;
//	}
	
}

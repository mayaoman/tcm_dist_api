package com.yention.tcm.api.entities;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer"})
@Table(name="tcm_user")
public class UserEntity {
	@Id
	@Column(length=128)
	private String id;

	@Column(length=128)
	private String username;

	@Column(length=256)
	private String password;

	@Column(length=128)
	private String email;

	@Column(length=16)
	private String cellPhoneNum;

	@Column(length=16)
	private String wxNickName;

	@Column(length=128)
	private String wxOpenId;

	@Column(length=8)
	private Integer sex;

	@Column(length=512)
	private String headImgUrl;
	
	@JsonIgnoreProperties(value = { "userList" })
	@ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "tcm_user_doctor",joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "doctorId"))
    private List<DoctorEntity> doctorList;
	
	public List<DoctorEntity> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<DoctorEntity> doctorList) {
		this.doctorList = doctorList;
	}

	public String getHeadImgUrl(){
		return headImgUrl;
	}
	 
	public void setHeadImgUrl(String headImgUrl){
		this.headImgUrl = headImgUrl;
	}
	
	public Integer getSex(){
		return sex;
	}
	 
	public void setSex(Integer sex){
		this.sex = sex;
	}
	
	public String getWxOpenId(){
		return wxOpenId;
	}
	 
	public void setWxOpenId(String wxOpenId){
		this.wxOpenId = wxOpenId;
	}
	
	public String getWxNickName(){
		return wxNickName;
	}
	 
	public void setWxNickName(String wxNickName){
		this.wxNickName = wxNickName;
	}

	// @ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
    @JoinColumn(name = "role_id")
	private RoleEntity role;
	
	public RoleEntity getRole(){
		return role;
	}
	 
	public void setRole(RoleEntity role){
		this.role = role;
	}
	
	
	public String getCellPhoneNum(){
		return cellPhoneNum;
	}
	 
	public void setCellPhoneNum(String cellPhoneNum){
		this.cellPhoneNum = cellPhoneNum;
	}
	
	public String getEmail(){
		return email;
	}
	 
	public void setEmail(String email){
		this.email = email;
	}
	
	
	public String getPassword(){
		return password;
	}
	 
	public void setPassword(String password){
		this.password = password;
	}

	
	public String getUsername(){
		return username;
	}
	 
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getId(){
		return id;
	}
	 
	public void setId(String id){
		this.id = id;
	}

	public UserEntity() {

	}
	
//	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<AddressEntity> addressList;
//
//	public List<AddressEntity> getAddressList() {
//		return addressList;
//	}
//
//	public void setAddressList(List<AddressEntity> addressList) {
//		this.addressList = addressList;
//	}
}
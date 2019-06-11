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
 * @ClassName: AddressEntity
 * @Description: 收货地址实体类
 * @author 孙刚
 * @date 2019年4月26日 下午3:11:21
 */
@Entity
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer"})
@Table(name="tcm_address")
public class AddressEntity {
	@Id
	@Column(length=20)
	private String addressId;
	
	@Column(length=20)
	private String userId;
	/**
	 * 收货人姓名
	 */
	@Column(length=20)
	private String name;
	/**
	 * 手机号
	 */
	@Column(length=20)
	private String phone;
	/**
	 * 所在地
	 */
	@Column(length=50)
	private String location;
	/**
	 * 详细地址
	 */
	@Column(length=128)
	private String detailed;
	
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDetailed() {
		return detailed;
	}
	public void setDetailed(String detailed) {
		this.detailed = detailed;
	}
}

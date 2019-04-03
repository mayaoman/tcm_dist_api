package com.yention.tcm.api.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id") 
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer"})
@Table(name="tcm_user")
public class UserEntity {
	@Id
	@Column(length=128)
	private String id;

	@Column(length=128)
	private String username;

	@Column(length=128)
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
	private int sex;

	@Column(length=512)
	private String headImgUrl;
	
	public String getHeadImgUrl(){
		return headImgUrl;
	}
	 
	public void setHeadImgUrl(String headImgUrl){
		this.headImgUrl = headImgUrl;
	}
	
	public int getSex(){
		return sex;
	}
	 
	public void setSex(int sex){
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

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_group_id")
	private UserGroupEntity userGroup;
	
	public UserGroupEntity getUserGroup(){
		return userGroup;
	}

	public void setUserGroup(UserGroupEntity userGroup){
		this.userGroup = userGroup;
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
}
package com.yention.tcm.api.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id") 
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer"})
@Table(name="tcm_role")
public class RoleEntity {
	@Id
	@Column(length=128)
	private String id;

	@Column(length=64)
	private String name;

	@OneToOne(mappedBy="userGroup")
	private UserGroupEntity userGroup;
	
	public UserGroupEntity getUserGroup(){
		return userGroup;
	}
	 
	public void setUserGroup(UserGroupEntity userGroup){
		this.userGroup = userGroup;
	}
	
	public String getName(){
		return name;
	}
	 
	public void setName(String name){
		this.name = name;
	}

	
	public String getId(){
		return id;
	}
	 
	public void setId(String id){
		this.id = id;
	}

	public RoleEntity() {

	}
}
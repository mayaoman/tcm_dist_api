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
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer", "user"})
@Table(name="tcm_role")
public class RoleEntity {
	@Id
	@Column(length=128)
	private String id;

	@Column(length=64)
	private String name;
	@OneToOne(mappedBy = "role", cascade = CascadeType.ALL,
              fetch = FetchType.LAZY, optional = false)
	private UserEntity user;
	
	public UserEntity getUser(){
		return user;
	}
	 
	public void setUser(UserEntity user){
		this.user = user;
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
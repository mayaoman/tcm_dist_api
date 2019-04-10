package com.yention.tcm.api.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id") 
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer","users"})
@Table(name="tcm_role")
public class RoleEntity {
	@Id
	@Column(length=128)
	private String id;

	@Column(length=64)
	private String name;

	@OneToMany(mappedBy="role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<UserEntity> users;
	
	public List<UserEntity> getUsers(){
		return users;
	}
	 
	public void setUsers(List<UserEntity> users){
		this.users = users;
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
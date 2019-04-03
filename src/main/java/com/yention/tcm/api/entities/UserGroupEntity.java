package com.yention.tcm.api.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id") 
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer"})
@Table(name="tcm_user_group")
public class UserGroupEntity {
	@Id
	@Column(length=128)
	private String id;

	@Column(length=128)
	private String name;

	@OneToMany(mappedBy="userGroup", cascade = CascadeType.ALL)
	private List<UserEntity> users;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
	private RoleEntity role;
	
	public RoleEntity getRole(){
		return role;
	}
	 
	public void setRole(RoleEntity role){
		this.role = role;
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

	public List<UserEntity> getUsers(){
		return users;
	}
	 
	public void setUsers(List<UserEntity> users){
		this.users = users;
	}
}
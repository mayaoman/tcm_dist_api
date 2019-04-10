package com.yention.tcm.api.repositories;

import com.yention.tcm.api.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

 
public interface UserRepository extends JpaRepository<UserEntity, String>{
	public UserEntity findByUsername(String username);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update UserEntity u set u.password = :password where u.id =:id")
	void updatePassword(@Param("password")String password,@Param("id")String id);

	@Query("select u from UserEntity u")
	public List<UserEntity> getUserList();

	public UserEntity findFirstByOrderById();
}
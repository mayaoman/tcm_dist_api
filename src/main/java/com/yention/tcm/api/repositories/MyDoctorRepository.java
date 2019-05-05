package com.yention.tcm.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yention.tcm.api.entities.MyDoctorEntity;

/** 
 * @Package com.yention.tcm.api.repositories
 * @ClassName: MyDoctorRepository
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 孙刚
 * @date 2019年4月26日 下午9:01:53
 */
public interface MyDoctorRepository extends JpaRepository<MyDoctorEntity, String> {

}

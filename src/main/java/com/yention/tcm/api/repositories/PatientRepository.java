package com.yention.tcm.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yention.tcm.api.entities.PatientEntity;

/** 
 * @Package com.yention.tcm.api.repositories
 * @ClassName: PatientRepository
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 孙刚
 * @date 2019年4月26日 下午9:03:18
 */
public interface PatientRepository extends JpaRepository<PatientEntity, String> {

}

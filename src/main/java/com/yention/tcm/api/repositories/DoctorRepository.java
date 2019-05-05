package com.yention.tcm.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yention.tcm.api.entities.DoctorEntity;

/** 
 * @Package com.yention.tcm.api.repositories
 * @ClassName: DoctorRepository
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 孙刚
 * @date 2019年4月26日 下午9:01:06
 */
public interface DoctorRepository extends JpaRepository<DoctorEntity, String> {

}

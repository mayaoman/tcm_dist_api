package com.yention.tcm.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yention.tcm.api.entities.DeptEntity;

/** 
 * @Package com.yention.tcm.api.repositories
 * @ClassName: DeptRepository
 * @Description: 科室
 * @author 孙刚
 * @date 2019年5月14日 下午4:49:17
 */
public interface DeptRepository extends JpaRepository<DeptEntity, String> {

}

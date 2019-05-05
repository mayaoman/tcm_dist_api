package com.yention.tcm.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yention.tcm.api.entities.AddressEntity;
import com.yention.tcm.api.repositories.AddressRepository;
import com.yention.tcm.api.utils.GenerateID;

/** 
 * @Package com.yention.tcm.api.services
 * @ClassName: AddressService
 * @Description: 收货地址业务处理类
 * @author 孙刚
 * @date 2019年4月26日 下午9:49:18
 */
@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	/**
	 * @Title: save
	 * @Description: 保存收货地址
	 * @param address
	 * @return boolean   
	 */
	public boolean save(AddressEntity address){
		boolean result = false;
		String id = GenerateID.getID();
		address.setAddressId(id);
		AddressEntity saveResult = addressRepository.saveAndFlush(address);
		if (saveResult != null)
			result = true;
		return result;
	}
	
	/**
	 * @Title: queryAddressByUser
	 * @Description: 查询用户的收货地址
	 * @param userId
	 * @return List<AddressEntity>   
	 */
	public List<AddressEntity> queryAddressByUser(String userId){
		return addressRepository.findByUserId(userId);
	}
	
	/**
	 * @Title: delete
	 * @Description: 删除一条收货地址
	 * @param addressId
	 * @return boolean   
	 */
	public boolean delete(String addressId){
		try{
			addressRepository.deleteById(addressId);
		} catch(Exception e) {
			e.printStackTrace(); 
			return false;
		}
		return true;
	}
}

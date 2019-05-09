package com.yention.tcm.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yention.tcm.api.entities.AddressEntity;
import com.yention.tcm.api.services.AddressService;

/** 
 * @Package com.yention.tcm.api.controllers
 * @ClassName: AddressController
 * @Description: 收货地址
 * @author 孙刚
 * @date 2019年4月27日 下午10:30:04
 */
@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	/**
	 * @Title: add
	 * @Description: 保存收货地址
	 * @param address
	 * @return boolean   
	 */
	@RequestMapping(path="/add", method=RequestMethod.POST)
    public @ResponseBody boolean add(@RequestBody AddressEntity address) {
		return addressService.save(address);
	}
	
	/**
	 * @Title: queryAll
	 * @Description: 查询用户的收货地址
	 * @param userId
	 * @return List<AddressEntity>   
	 */
	@RequestMapping(path="/queryAll", method=RequestMethod.GET)
	public @ResponseBody List<AddressEntity> queryAll(String userId){
		return addressService.queryAddressByUser(userId);
	}
	
	
}

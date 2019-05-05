package com.yention.tcm.api.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @Package com.yention.tcm.api.controllers
 * @ClassName: OrderController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 孙刚
 * @date 2019年4月19日 上午10:38:46
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@RequestMapping(path="/list", method=RequestMethod.GET)
    public @ResponseBody List<Map<String,Object>> getOrderList(String openid) {
		System.out.println("openid:"+openid);
		List<Map<String,Object>> orderList = new ArrayList<Map<String,Object>>();
		Map<String,Object> order1 = new HashMap<String,Object>();
		order1.put("name", "order1");
		order1.put("pri", "123");
		order1.put("desc", "沙发垫我问问");
		Map<String,Object> order2 = new HashMap<String,Object>();
		order2.put("name", "order2");
		order2.put("pri", "12333");
		order2.put("desc", "aaad我问问");
		orderList.add(order1);
		orderList.add(order2);
        return orderList;
    }
}

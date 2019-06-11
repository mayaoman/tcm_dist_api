package com.yention.tcm.api.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

import com.yention.tcm.api.entities.DoctorEntity;
import com.yention.tcm.api.entities.UserEntity;
import java.util.Map;
import java.util.List;
import com.yention.tcm.api.services.UserService;
import com.yention.tcm.api.utils.GenerateID;

import org.springframework.security.core.AuthenticationException;
import com.yention.tcm.api.domains.ResultResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(path="/list", method=RequestMethod.GET)
    public @ResponseBody ResultResponse<List> getUserList() {
        List result = userService.getUserList();
        return new ResultResponse<List>(result);
    }

    @RequestMapping(path="/login", method=RequestMethod.POST)
    public @ResponseBody ResultResponse<Map<String, Object>> login(String username, String password) throws AuthenticationException {
        Map<String, Object> result = userService.login(username, password);
        return new ResultResponse<Map<String, Object>>(result);
    }
    
    /**
     * @Title: addUser
     * @Description: 微信公众号扫码新增用户
     * @param user
     * @return boolean   
     */
    @RequestMapping(path="/addUser", method=RequestMethod.POST)
    public @ResponseBody boolean addUser(@RequestBody UserEntity user) {
		String id = GenerateID.getID();
		user.setId(id);
		boolean result = userService.save(user);
        return result;
    }
    
    /**
     * @Title: getUserByOpenId
     * @Description: 根据微信号获取用户信息
     * @param openid
     * @return UserEntity   
     */
    @RequestMapping(path="/getUserByOpenId", method=RequestMethod.GET)
    public @ResponseBody UserEntity getUserByOpenId(String openid){
    	return userService.findByWxOpenId(openid);
    }
    
    /**
     * @Title: getMyDoctor
     * @Description: 获取我的医生列表
     * @param openid
     * @return List<DoctorEntity>   
     */
    @RequestMapping(path="/getMyDoctor", method=RequestMethod.GET)
    public @ResponseBody List<DoctorEntity> getMyDoctor(String openid){
    	UserEntity user = userService.findByWxOpenId(openid);
    	return user.getDoctorList();
    }

    // @RequestMapping(path="/password", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    // public @ResponseBody boolean updatePassword(@RequestBody Map<String, String> params) {
    //     String userId = params.get("userId");
    //     String oldPassword = params.get("oldPassword");
    //     String newPassword = params.get("newPassword");

    //     if ((userId == null) || oldPassword == null || newPassword == null ) {
    //         return false;
    //     }

    //     if ( userId.isEmpty() || oldPassword.isEmpty() || newPassword.isEmpty() ) {
    //         return false;
    //     }

    //     UserEntity user = userService.findById(userId);

    //     if (user == null) {
    //         return false;
    //     }

    //     if (!user.getPassword().equals(oldPassword)) {
    //         return false;
    //     }

    //     return userService.updatePassword(newPassword, userId);
    // }


    // @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    // public @ResponseBody boolean save(@RequestBody UserEntity user) {
    //     String token = tokenService.create(user.getUsername(), user.getPassword());
    //     user.setToken(token);
    //     return userService.save(user);
    // }

    // @RequestMapping(path="/{userId}", method=RequestMethod.DELETE)
    // public @ResponseBody boolean delete(@PathVariable(value="userId") String id) {
    //     boolean result = userService.delete(id);
    //     return result;
    // }

    // @RequestMapping(path="/{userId}", method=RequestMethod.GET)
    // public @ResponseBody UserEntity getUserById(@PathVariable(value="userId") String id) {
    //     UserEntity user = userService.findById(id);
    //     return user;
    // }

}
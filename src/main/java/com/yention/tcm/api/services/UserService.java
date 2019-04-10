package com.yention.tcm.api.services;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier; 
import org.springframework.beans.factory.annotation.Autowired;
import com.yention.tcm.api.entities.UserEntity;
import com.yention.tcm.api.repositories.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import com.yention.tcm.api.domains.JwtUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import com.yention.tcm.api.services.JwtUserDetailsService;
import com.yention.tcm.api.utils.JwtTokenUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.Map;
import java.util.HashMap;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private AuthenticationManager authenticationManager;


	public Map<String, Object> login(String username, String password) {
		System.out.println("login...");
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
       
        System.out.println("upToken:" + upToken);
        Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final JwtUserDetails userDetail = (JwtUserDetails) authentication.getPrincipal();
        
       	String token = jwtTokenUtil.generateToken(userDetail);

       	Map<String, Object> result = new HashMap();
       	result.put("user",userDetail);
       	result.put("token", token);
       	return result;
    }

	public boolean save(UserEntity UserEntity) {
		boolean result = false;
		UserEntity saveResult = this.userRepository.saveAndFlush(UserEntity);
		if (saveResult != null)
			result = true;
		return result;
	}

	// public boolean delete(String id) {
	// 	try{
	// 		this.userRepository.delete(id);
	// 	} catch(EmptyResultDataAccessException e) {
	// 		e.printStackTrace(); 
	// 		return false;
	// 	}
	// 	return true;
	// }

	public UserEntity getDefault() {
		return this.userRepository.findFirstByOrderById();
	}

	public List<UserEntity> getUserList() {
		return this.userRepository.getUserList();
	}

	public UserEntity findById(String id) {
		return this.userRepository.getOne(id);
	}
	
	public UserEntity findByUsername(String name) {
		return this.userRepository.findByUsername(name);
	}

	public boolean updatePassword(String password, String id) {
		this.userRepository.updatePassword(password, id);
		return true;
	}
}


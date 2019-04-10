package com.yention.tcm.api.services;

import com.yention.tcm.api.repositories.UserRepository;
import com.yention.tcm.api.entities.UserEntity;
import com.yention.tcm.api.entities.RoleEntity;
import com.yention.tcm.api.domains.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.yention.tcm.api.domains.JwtUserDetails;
import java.util.stream.Collectors;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public JwtUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            System.out.println(user.getRole());
            RoleEntity roleEntity = user.getRole();
            Role role = new Role(roleEntity.getId(), roleEntity.getName());
            return new JwtUserDetails(user.getId(), user.getUsername(), user.getPassword(), role);
        }
    }

}
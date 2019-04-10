package com.yention.tcm.api.configurations.security;

import com.yention.tcm.api.domains.JwtUserDetails;
import com.yention.tcm.api.services.JwtUserDetailsService;
import com.yention.tcm.api.utils.JwtTokenUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
    								HttpServletResponse response, 
    								FilterChain chain) throws ServletException, IOException {

        String token = request.getHeader(this.tokenHeader);

        System.out.println("################################");
        System.out.println("token:" + token);
        System.out.println("################################");

        if (token != null) {
        	String username = jwtTokenUtil.getUsernameFromToken(token);
        	if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        	    UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
		        if (jwtTokenUtil.validateToken(token, userDetails)) {
		        	UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			        SecurityContextHolder.getContext().setAuthentication(authentication);
		        }
        	}
        }

        chain.doFilter(request, response);
    }
}
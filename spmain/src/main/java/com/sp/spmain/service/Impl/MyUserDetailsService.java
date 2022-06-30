package com.sp.spmain.service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sp.spmain.model.User;
import com.sp.spmain.repo.UserDetailsRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserDetailsRepo userDetailsRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user =userDetailsRepo.findByUsername(username);
 		ArrayList<SimpleGrantedAuthority> role= new ArrayList<>();
 		user.getRoles().forEach((r)->
 		role.add(new SimpleGrantedAuthority(r.getName())) 
 		);
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
	}

}

package com.sp.spmain.service.Impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		//User user =userDetailsRepo.findByUsername(username);
		//System.out.println(user.getRole());
		//System.out.println("This have an username:"+user.getUsername());
		return new org.springframework.security.core.userdetails.User("mujeeb","mujeeb",new ArrayList<>());
	}

}

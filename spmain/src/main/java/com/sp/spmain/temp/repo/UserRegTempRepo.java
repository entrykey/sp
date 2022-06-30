package com.sp.spmain.temp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.spmain.temp.model.UserRegTemp;

@Repository
public interface UserRegTempRepo extends JpaRepository<UserRegTemp, Long> {
	
	UserRegTemp findByPhone(String mobile);
	
	UserRegTemp findByPhoneAndOtp(String mobile,String otp);
	
	
}


package com.sp.spmain.temp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sp.spmain.temp.dto.UserTempGenOtpDto;
import com.sp.spmain.temp.model.UserRegTemp;
import com.sp.spmain.temp.repo.UserRegTempRepo;

@Component
public class UserRegTempService {
	
	 @Autowired UserRegTempRepo repository;
	 
	 public void generate(UserTempGenOtpDto userTempGenOtpDto) {
		 UserRegTemp ob = new UserRegTemp();
		 ob.setPhone(userTempGenOtpDto.getPhone());
		 ob.setOtp("0011");
		 repository.save(ob);
	    }
	 
	 public void validate(UserTempGenOtpDto userTempGenOtpDto) {
		 UserRegTemp dataobj=repository.findByPhoneAndOtp(userTempGenOtpDto.getPhone(),userTempGenOtpDto.getOtp());
	    }
	 
}

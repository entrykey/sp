package com.sp.spmain.temp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sp.spmain.model.User;
import com.sp.spmain.temp.dto.UserRegDto;
import com.sp.spmain.temp.dto.UserTempGenOtpDto;
import com.sp.spmain.temp.model.UserRegTemp;
import com.sp.spmain.temp.repo.UserRegTempRepo;
import com.sp.spmain.temp.repo.UserRepo;

@Component
public class UserRegTempService {
	
	 @Autowired UserRegTempRepo userTempRep;
	 @Autowired UserRepo userRep;
	 
	 public void generate(UserTempGenOtpDto td) {
		 UserRegTemp ob = new UserRegTemp();
		 ob.setPhone(td.getPhone());
		 ob.setOtp("0011");
		 userTempRep.save(ob);
	    }
	 
	 public void validate(UserTempGenOtpDto td) {
		 UserRegTemp dataobj=userTempRep.findByPhoneAndOtp(td.getPhone(),td.getOtp());
	    }
	 
	 public void userRegister(UserRegDto ur) {
		 User user=new User();
		 user.setPhone(ur.getPhone());
		 user.setEmail(ur.getEmail());
		 user.setGender(ur.getGender());
		 user.setUsername(ur.getName());
		 userRep.save(user);
	 }

}

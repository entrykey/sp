package com.sp.spmain.temp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sp.spmain.common.bean.Validations;
import com.sp.spmain.exception.ValidationException;
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
	 Validations validate = new Validations();
	 
	 public Boolean generate(UserTempGenOtpDto td) throws ValidationException{
		 
		 if(validate.validatePhoneNum(td.getPhone())) {
		 UserRegTemp ob = new UserRegTemp();
		 ob=userTempRep.findByPhone(td.getPhone());
		 if(ob!=null) {
			 ob.setOtp("0011");
		 }
		 else {
			 ob = new UserRegTemp();
			 ob.setPhone(td.getPhone());
			 ob.setOtp("0011");
		 }
		 userTempRep.save(ob);
		 return true;
		 }
		 else {
			 throw new ValidationException("No valid mobile number found");
		 }
	    }
	 
	 public Boolean validate(UserTempGenOtpDto td) throws ValidationException{
			 if(validate.validatePhoneNum(td.getPhone()) && validate.validateOtp(td.getOtp())) {
				 UserRegTemp dataobj=userTempRep.findByPhoneAndOtp(td.getPhone(),td.getOtp());
				 if(dataobj!=null)
					 return true;
				 else
					 throw new ValidationException("No data found");
			 }
			 else {
				 throw new ValidationException("No valid input data found");
			 }
	    }
	 
	 public Boolean userRegister(UserRegDto ur) {
		 User user=new User();
		 user.setPhone(ur.getPhone());
		 user.setEmail(ur.getEmail());
		 user.setGender(ur.getGender());
		 user.setUsername(ur.getName());
		 userRep.save(user);
		 return true;
	 }

}

package com.sp.spmain.common.bean;

public class Validations {
	
	public Boolean validatePhoneNum(String phone) {
		if(phone!=null && phone.length()==10)
			return true;
		else
			return false;
	}

	public Boolean validateOtp(String otp) {
		if(otp!=null && otp.length()==4)
			return true;
		else
			return false;
	}
	
}

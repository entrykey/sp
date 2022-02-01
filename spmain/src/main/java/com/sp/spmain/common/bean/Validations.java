package com.sp.spmain.common.bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	public Boolean email(String email) {
		if(email!=null && email.length()>5) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
		}
		else return false;
	}
	
	public Boolean gender(String gender) {
		if(gender!=null && gender.length()==1) {
		if(gender.equals("M") || gender.equals("m") || gender.equals("F") || gender.equals("f"))
			return true;
		else
			return false;
		}
		else {
			return false;
		}
	}
	
	public Boolean username(String username) {
		if(username!=null && username.length()>5)
		return true;
		else
		return false;
	}
	
	public Boolean shopDetails(String shopDetails) {
		if(shopDetails!=null && valNumChar(shopDetails))
		return true;
		else
		return false;
	}
	
	public Boolean valNumChar(String str) {
		if(str.matches("^[a-zA-Z0-9]+$"))
			return true;
			else
			return false;
	}
	

}

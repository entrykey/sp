package com.sp.spmain.temp.dto;

public class OtpVerificationDto {
	private Boolean isOtpValid;
	private Boolean isRegistered;
	private UserRegDto userRegDto;
	
	public Boolean getIsOtpValid() {
		return isOtpValid;
	}
	public void setIsOtpValid(Boolean isOtpValid) {
		this.isOtpValid = isOtpValid;
	}
	public Boolean getIsRegistered() {
		return isRegistered;
	}
	public void setIsRegistered(Boolean isRegistered) {
		this.isRegistered = isRegistered;
	}
	public UserRegDto getUserRegDto() {
		return userRegDto;
	}
	public void setUserRegDto(UserRegDto userRegDto) {
		this.userRegDto = userRegDto;
	}
	
}

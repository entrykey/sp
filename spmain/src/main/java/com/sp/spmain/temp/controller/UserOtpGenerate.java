package com.sp.spmain.temp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.spmain.temp.dto.UserTempGenOtpDto;
import com.sp.spmain.temp.service.UserRegTempService;

@RestController
@RequestMapping("temp")
public class UserOtpGenerate {
	
	@Autowired UserRegTempService userRegTempService;
	
	@RequestMapping("/usergenotp")
	@PostMapping
    public void genuserotp(@RequestBody UserTempGenOtpDto userTempGenOtpDto) {
		userRegTempService.generate(userTempGenOtpDto);
    }
	
	@RequestMapping("/valotp")
	@PostMapping
    public void validateotp(@RequestBody UserTempGenOtpDto userTempGenOtpDto) {
		userRegTempService.validate(userTempGenOtpDto);
    }
	
}

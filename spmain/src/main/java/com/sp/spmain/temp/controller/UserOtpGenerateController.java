package com.sp.spmain.temp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.spmain.common.bean.ApiResponse;
import com.sp.spmain.exception.ServiceException;
import com.sp.spmain.temp.dto.UserRegDto;
import com.sp.spmain.temp.dto.UserTempGenOtpDto;
import com.sp.spmain.temp.service.UserRegTempService;


@RestController
@RequestMapping("temp")
public class UserOtpGenerateController {
	
	@Autowired UserRegTempService userRegTempService;
	
	@RequestMapping("/usergenotp")
	@PostMapping
    public ResponseEntity<ApiResponse> genuserotp(@RequestBody UserTempGenOtpDto userTempGenOtpDto) throws ServiceException {
		ApiResponse apiResponse = new ApiResponse();
		try {
			System.out.println(userTempGenOtpDto);
			apiResponse.setData(userRegTempService.generate(userTempGenOtpDto));
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		}catch(Exception e) {
			apiResponse=apiResponse.errorset(e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);						
		}
    }
	@RequestMapping("/valotp")
	@PostMapping
    public ResponseEntity<ApiResponse> validateotp(@RequestBody UserTempGenOtpDto userTempGenOtpDto)throws ServiceException {
		ApiResponse apiResponse = new ApiResponse();
		try {		
			apiResponse.setData(userRegTempService.validate(userTempGenOtpDto));
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		}catch(Exception e) {
			apiResponse=apiResponse.errorset(e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);						
		}
    }
	
	@RequestMapping("/reguser")
	@PostMapping
    public ResponseEntity<ApiResponse> registerUser(@RequestBody UserRegDto userRegDto) throws ServiceException {
		ApiResponse apiResponse = new ApiResponse();
		try {		
			apiResponse.setData(userRegTempService.userRegister(userRegDto));
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		}catch(Exception e) {
			apiResponse=apiResponse.errorset(e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);						
		}
    }
	
}

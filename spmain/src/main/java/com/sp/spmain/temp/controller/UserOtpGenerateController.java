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
			apiResponse=apiResponse.errorset("500",e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);						
		}
    }
	
	@RequestMapping("/valotp")
	@PostMapping
    public ResponseEntity<ApiResponse> validateotp(@RequestBody UserTempGenOtpDto userTempGenOtpDto)throws ServiceException {
		ApiResponse apiResponse = new ApiResponse();
		try {
			System.out.println(userTempGenOtpDto);
			apiResponse.setData(userRegTempService.validate(userTempGenOtpDto));
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		}catch(Exception e) {
			apiResponse=apiResponse.errorset("500",e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);						
		}
    }
	
	@RequestMapping("/reguser")
	@PostMapping
    public void registerUser(@RequestBody UserRegDto userRegDto) {
		userRegTempService.userRegister(userRegDto);
    }
	
	/*
	@GetMapping("/qubbit/getSurveyTemplates")
	public ResponseEntity<ApiResponse> getSurveyTemplates() throws ServiceException {
		ApiResponse apiResponse = new ApiResponse();
		try {			
			if(superAdminService.getPropertyStatus(IConstant.QUBBIT_PROPERTY_NAME))
			{
				List<QubbitSurveyDetailsDTO> QubbitSurveyDetailsList =  qubbitService.fetchSurveyTemplates();
				apiResponse.setResponse(QubbitSurveyDetailsList);
				return new ResponseEntity<>(apiResponse, HttpStatus.OK);
			}
			else {
				apiResponse.setErrorFlag(true);
				apiResponse.setResponseMessage("Qubbit Not Enabled in Ldesk!");
				return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);	
			}			
		}catch(Exception e) {
			apiResponse.setErrorFlag(true);
			apiResponse.setResponseMessage(e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);						
		}				
	}
	*/
}

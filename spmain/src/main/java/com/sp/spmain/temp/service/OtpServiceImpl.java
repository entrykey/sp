package com.sp.spmain.temp.service;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sp.spmain.temp.repo.OtpService;

@Service
public class OtpServiceImpl implements OtpService {

	@Override
	public Boolean sendOtp(String mobileNumber,String otp) {
		RestTemplate restTemplate = new RestTemplate();
		String url="https://2factor.in/API/V1/63489e96-518a-11ec-b710-0200cd936042/SMS/"+mobileNumber+"/"+otp+"/SP-verify";
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_FORM_URLENCODED));
	    HttpEntity request = new HttpEntity(headers);
	    ResponseEntity<String> response = restTemplate.exchange(
	            url,
	            HttpMethod.GET,
	            request,
	            String.class,
	            1
	    );
	    // check response
	    if (response.getStatusCode() == HttpStatus.OK) {
	        //System.out.println("Request Successful.");
	        //System.out.println(response.getBody());
	    	return true;
	    } else {
	        //System.out.println("Request Failed");
	        //System.out.println(response.getStatusCode());
	    	return false;
	    }
	}

}

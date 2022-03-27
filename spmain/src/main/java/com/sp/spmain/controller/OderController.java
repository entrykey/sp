package com.sp.spmain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.spmain.common.bean.ApiResponse;
import com.sp.spmain.common.bean.order.OderDto;
import com.sp.spmain.dto.OderOutDto;
import com.sp.spmain.exception.ServiceException;

@RestController
@RequestMapping("sporder")
public class OderController {

	@PostMapping({"/ord"})
    public ResponseEntity<ApiResponse> getShopDetails(@RequestBody OderDto Oder) throws ServiceException {
		ApiResponse apiResponse = new ApiResponse();
		try {
			
			apiResponse.setData(new OderOutDto("6656","SUCCESS"));
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		}catch(Exception e) {
			apiResponse=apiResponse.errorset(e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);						
		}
    }
}

package com.sp.spmain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.spmain.common.bean.ApiResponse;
import com.sp.spmain.common.bean.order.OderDto;
import com.sp.spmain.common.bean.order.OrderDetailsDto;
import com.sp.spmain.exception.ServiceException;
import com.sp.spmain.repo.UserOrderRepo;
import com.sp.spmain.service.Impl.UserOrderServiceImpl;

@RestController
@RequestMapping("sporder")
public class OderController {
	
	@Autowired UserOrderRepo userOrderRepo;
	@Autowired UserOrderServiceImpl userOrderServiceImpl;
	 
	@PostMapping({"/ord"})
    public ResponseEntity<ApiResponse> saveOrderDetails(@RequestBody OderDto Oder) throws ServiceException {
		ApiResponse apiResponse = new ApiResponse();
		try {
			
			apiResponse.setData(userOrderServiceImpl.save(Oder));
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		}catch(Exception e) {
			apiResponse=apiResponse.errorset(e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);						
		}
    }
	
	@PostMapping({"/orddet"})
    public ResponseEntity<ApiResponse> getOrderDetailsById(@RequestBody OrderDetailsDto orderDetailsDto) throws ServiceException {
		ApiResponse apiResponse = new ApiResponse();
		try {
			
			//apiResponse.setData(userOrderServiceImpl.save(Oder));
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		}catch(Exception e) {
			apiResponse=apiResponse.errorset(e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);						
		}
    }
}

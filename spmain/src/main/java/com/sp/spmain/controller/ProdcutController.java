package com.sp.spmain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.spmain.common.bean.ApiResponse;
import com.sp.spmain.exception.ServiceException;
import com.sp.spmain.service.Impl.ProductServiceImpl;


@RestController
@RequestMapping("spprod")
public class ProdcutController {
	
	@Autowired ProductServiceImpl productServiceImpl;
	
	@PostMapping({"/{details}"})
    public ResponseEntity<ApiResponse> getByShopId(@PathVariable("details") String details) throws ServiceException {
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse.setData(productServiceImpl.findByBarcode(details));
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		}catch(Exception e) {
			apiResponse=apiResponse.errorset(e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);						
		}
    }

}

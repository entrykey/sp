package com.sp.spmain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.spmain.common.bean.ApiResponse;
import com.sp.spmain.exception.ServiceException;
import com.sp.spmain.model.Shop;

@RestController
@RequestMapping("admin")
public class AdminShopController {

	
	@PostMapping({"/shop/save"})
    public ResponseEntity<ApiResponse> saveShop(@RequestBody Shop shop) throws ServiceException {
		ApiResponse apiResponse = new ApiResponse();
		try {
			System.out.println(shop);
			apiResponse.setData(null);
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		}catch(Exception e) {
			apiResponse=apiResponse.errorset(e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);						
		}
    }

}
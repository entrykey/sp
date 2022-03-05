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
import com.sp.spmain.service.Impl.ShopServiceImpl;

@RestController
@RequestMapping("spshop")
public class ShopController {
	
	@Autowired ShopServiceImpl shopServiceImpl;
	
	/*
	 * @PostMapping({"/{qrcode}"}) public ResponseEntity<ApiResponse>
	 * qrcode(@PathVariable("qrcode") String qrcode) throws ServiceException {
	 * ApiResponse apiResponse = new ApiResponse(); try {
	 * System.out.println(qrcode); apiResponse.setData("ok"); return new
	 * ResponseEntity<>(apiResponse, HttpStatus.OK); }catch(Exception e) {
	 * apiResponse=apiResponse.errorset(e.getLocalizedMessage()); return new
	 * ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST); } }
	 */
	
	@PostMapping({"/{shopdetails}"})
    public ResponseEntity<ApiResponse> getByShopId(@PathVariable("shopdetails") String shopDetails) throws ServiceException {
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse.setData(shopServiceImpl.findByShopDetails(shopDetails));
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		}catch(Exception e) {
			apiResponse=apiResponse.errorset(e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);						
		}
    }
	
	@PostMapping("/getlocations")
    public ResponseEntity<ApiResponse> getAllByGeoLocation() throws ServiceException {
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse.setData(shopServiceImpl.getAllByGeolocation(true));
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		}catch(Exception e) {
			apiResponse=apiResponse.errorset(e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);						
		}
    }
	
	
}

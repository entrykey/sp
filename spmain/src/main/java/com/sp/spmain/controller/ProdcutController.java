package com.sp.spmain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.spmain.common.bean.ApiResponse;
import com.sp.spmain.dto.ProductSaveDto;
import com.sp.spmain.exception.ServiceException;
import com.sp.spmain.repo.ProductRepo;
import com.sp.spmain.repo.ProductUnitRepo;
import com.sp.spmain.service.Impl.ProductServiceImpl;


@RestController
@RequestMapping("spprod")
public class ProdcutController {
	
	@Autowired ProductServiceImpl productServiceImpl;
	@Autowired ProductRepo productRepo;
	@Autowired ProductUnitRepo productUnitRepo;
	
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
	
	@PostMapping({"/saveProduct"})
    public ResponseEntity<ApiResponse> saveProduct(@ModelAttribute ProductSaveDto productSaveDto) throws ServiceException {
		ApiResponse apiResponse = new ApiResponse();
		try {
			
			apiResponse.setData(productServiceImpl.saveProduct(productSaveDto));
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		}catch(Exception e) {
			apiResponse=apiResponse.errorset(e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);						
		}
    }
	
	
	
	@PostMapping({"/getAllProduct"})
    public ResponseEntity<ApiResponse> getAllProduct() throws ServiceException {
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse.setData(productServiceImpl.findByStatus(true));
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		}catch(Exception e) {
			apiResponse=apiResponse.errorset(e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);						
		}
    }
	
	@PostMapping({"/getAllUnit"})
    public ResponseEntity<ApiResponse> getAllUnits() throws ServiceException {
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse.setData(productUnitRepo.findAll());
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		}catch(Exception e) {
			apiResponse=apiResponse.errorset(e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);						
		}
    }
	
	@PostMapping({"/deleteProduct"})
    public ResponseEntity<ApiResponse> deleteProduct(@RequestBody ProductSaveDto productSaveDto) throws ServiceException {
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse.setData(productServiceImpl.deleteProduct(productSaveDto.getShopId()));
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		}catch(Exception e) {
			apiResponse=apiResponse.errorset(e.getLocalizedMessage());
			return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);						
		}
    }
	
	

}

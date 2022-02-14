package com.sp.spmain.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.spmain.common.bean.Validations;
import com.sp.spmain.exception.ValidationException;
import com.sp.spmain.model.Product;
import com.sp.spmain.repo.ProductRepo;
import com.sp.spmain.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired ProductRepo productRepo;
	Validations validate = new Validations();
	
	@Override
	public Product findByBarcode(String barcode) throws ValidationException{
		if(validate.prdoDetails(barcode)==false) throw new ValidationException("Not a valid details");
		 Product product= productRepo.findByBarcode(barcode.trim());
		 if(product==null) throw new ValidationException("No Data found");
		 return product;
	}
		
	

}

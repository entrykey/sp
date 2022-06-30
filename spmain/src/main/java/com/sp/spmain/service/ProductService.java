package com.sp.spmain.service;

import java.io.IOException;
import java.util.List;

import com.sp.spmain.dto.ProductSaveDto;
import com.sp.spmain.exception.ValidationException;
import com.sp.spmain.model.Product;

public interface ProductService {
	Product findByBarcode(String barcode) throws ValidationException;
	Boolean saveProduct(ProductSaveDto productSaveDto)throws ValidationException, IOException;
	List<Product> findByStatus(Boolean status)throws ValidationException;
	Boolean deleteProduct(Integer productId)throws ValidationException;
}

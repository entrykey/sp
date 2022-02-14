package com.sp.spmain.service;

import com.sp.spmain.exception.ValidationException;
import com.sp.spmain.model.Product;

public interface ProductService {
	Product findByBarcode(String barcode) throws ValidationException;
}

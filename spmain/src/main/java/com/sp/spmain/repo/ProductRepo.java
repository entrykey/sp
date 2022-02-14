package com.sp.spmain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.spmain.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
	Product findByBarcode(String barcode);
}

package com.sp.spmain.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sp.spmain.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
	Product findByBarcode(String barcode);
	List<Product> findByStatus(Boolean status);
	Boolean deleteById(Integer Integer);
	Product findById(Integer Integer);
}

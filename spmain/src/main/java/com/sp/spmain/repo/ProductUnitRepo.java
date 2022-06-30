package com.sp.spmain.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.spmain.model.ProductUnit;

public interface ProductUnitRepo extends JpaRepository<ProductUnit, Long> {
	ProductUnit findById(Integer id);
}

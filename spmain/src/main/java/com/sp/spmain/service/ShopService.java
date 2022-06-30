package com.sp.spmain.service;

import java.util.List;

import com.sp.spmain.dto.ShopSaveDto;
import com.sp.spmain.exception.ValidationException;
import com.sp.spmain.model.Shop;

public interface ShopService {
	Shop findById(Integer id);
	List<Shop> findByStatus(Boolean status);
	Shop findByIdAndStatus(Integer id);
	Shop findByShopDetails(String shopDetails) throws ValidationException;
	List<Shop> getAllByGeolocation(Boolean status);
	Boolean saveShop(ShopSaveDto shopSaveDto) throws ValidationException;
	
}

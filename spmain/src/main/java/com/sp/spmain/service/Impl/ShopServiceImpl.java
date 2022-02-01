package com.sp.spmain.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.spmain.common.bean.Validations;
import com.sp.spmain.exception.ValidationException;
import com.sp.spmain.model.Shop;
import com.sp.spmain.repo.ShopRepo;
import com.sp.spmain.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService{
	
	@Autowired ShopRepo shopRepo;
	Validations validate = new Validations();
	
	@Override
	public Shop findById(Integer id) {
		return shopRepo.findById(id);
	}

	@Override
	public List<Shop> findByStatus(Boolean status) {
		return shopRepo.findByStatus(status);
	}

	@Override
	public Shop findByIdAndStatus(Integer id) {
		return shopRepo.findByIdAndStatus(id,true);
	}

	@Override
	public Shop findByShopDetails(String shopDetails) throws ValidationException{
		 if(validate.shopDetails(shopDetails)==false) throw new ValidationException("Not a valid details");
		 Shop shop= shopRepo.findById(Integer.parseInt(shopDetails.trim()));
		 if(shop==null) throw new ValidationException("No Data found");
		 return shop;
	}

	@Override
	public List<Shop> getAllByGeolocation(Boolean status) {
		return shopRepo.findByStatus(true);
	}
	
}

package com.sp.spmain.service.Impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.spmain.common.bean.Validations;
import com.sp.spmain.dto.ShopSaveDto;
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

	@Override
	public Boolean saveShop(ShopSaveDto shopSaveDto) throws ValidationException{
		if(shopSaveDto!=null) {
		if(shopSaveDto.getShopName()!=null && shopSaveDto.getShopName().length()>1) {
			if(shopRepo.findByShopName(shopSaveDto.getShopName())==null){
				Shop shop = new Shop();
				Random random = new Random(); 
				shop.setShopName(shopSaveDto.getShopName());
				shop.setGeolocation(shopSaveDto.getLatitude()+","+shopSaveDto.getLongitude());
				shop.setAddress(shopSaveDto.getAddress());
				shop.setCity(shopSaveDto.getCity());
				shop.setPincode(shopSaveDto.getPincode());
				shop.setStatus(true);
				shop.setShopCode(shopSaveDto.getShopName().substring(0, 4).toUpperCase()+random.nextInt(1000));
				shopRepo.save(shop);
				return true;
				}
			else {
				throw new ValidationException("This shop name already there...");
			}
			}
		}
		return false;
	}	
	
}

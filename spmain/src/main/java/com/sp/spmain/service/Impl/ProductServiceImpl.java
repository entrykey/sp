package com.sp.spmain.service.Impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.spmain.common.bean.Validations;
import com.sp.spmain.dto.ProductSaveDto;
import com.sp.spmain.exception.ValidationException;
import com.sp.spmain.model.Product;
import com.sp.spmain.repo.ProductRepo;
import com.sp.spmain.repo.ProductUnitRepo;
import com.sp.spmain.repo.ShopRepo;
import com.sp.spmain.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired ShopRepo shopRepo;
	@Autowired ProductRepo productRepo;
	@Autowired ProductUnitRepo productUnitRepo;
	Validations validate = new Validations();
	
	@Override
	public Product findByBarcode(String barcode) throws ValidationException{
		if(validate.prdoDetails(barcode)==false) throw new ValidationException("Not a valid details");
		 Product product= productRepo.findByBarcode(barcode.trim());
		 if(product==null) throw new ValidationException("No Data found");
		 product.setImage(null);
		 product.setUnitInfo(product.getProductUnit().getNos()+" "+product.getProductUnit().getUnitName());
		 product.setProductUnit(null);
		 product.setImageUrl("/sporder/pimage/"+product.getId());
		 return product;
	}

	@Override
	public Boolean saveProduct(ProductSaveDto productSaveDto) throws ValidationException, IOException {
		Product product = new Product();
		product.setName(productSaveDto.getProductName());
		product.setBarcode(productSaveDto.getBarcode());
		product.setMrp(productSaveDto.getMrp());
		product.setCgst(productSaveDto.getCgst());
		product.setSgst(productSaveDto.getSgst());
		product.setStatus(true);
		product.setPercentage(this.calCulatePer(productSaveDto.getMrp(),productSaveDto.getOfferPrice()));
		product.setOfferPrice(productSaveDto.getOfferPrice());
		product.setShop(shopRepo.findById(productSaveDto.getShopId()));
		product.setProductUnit(productUnitRepo.findById(productSaveDto.getUnitId()));
		product.setImage(productSaveDto.getProductImage().getBytes());
		productRepo.save(product);
		return true;
	}

	@Override
	public List<Product> findByStatus(Boolean status) throws ValidationException {
		List<Product> prodcutList=productRepo.findByStatus(true);
		if(prodcutList==null) throw new ValidationException("No Data found");
		return prodcutList;
	}
		
	Double calCulatePer(Double x,Double y) {
		return Double.valueOf(String.format("%1.2f",(100-(y*100)/x)));
	}

	@Override
	public Boolean deleteProduct(Integer productId) throws ValidationException {
		productRepo.delete(productRepo.findById(productId));
		return true;
	}

}

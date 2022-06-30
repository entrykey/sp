package com.sp.spmain.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sp.spmain.model.Shop;


@Repository
public interface ShopRepo extends JpaRepository<Shop, Long> {
	
	Shop findById(Integer id);
	List<Shop> findByStatus(Boolean status);
	Shop findByIdAndStatus(Integer id,Boolean status);
	@Query("select s.id,s.shopName,s.shopCode,s.geolocation from Shop s where s.status is true")
	public List<Shop> getAllByGeoLocation();
	Shop findByShopName(String ShopName);

}




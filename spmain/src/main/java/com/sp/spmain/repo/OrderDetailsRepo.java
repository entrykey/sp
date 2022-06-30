package com.sp.spmain.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.spmain.model.order.OrderDetails;
import com.sp.spmain.model.order.UserOrder;
@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {
	OrderDetails findByUserOrder(UserOrder userOrder);
	ArrayList<OrderDetails> findByUserOrderId(Long orderId);
}

package com.sp.spmain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.spmain.model.order.PaymentDetails;
@Repository
public interface PaymentDetailsRepo extends JpaRepository<PaymentDetails,Long> {

}

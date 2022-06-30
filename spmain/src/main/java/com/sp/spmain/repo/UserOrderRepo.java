package com.sp.spmain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sp.spmain.model.order.UserOrder;
@Repository
public interface UserOrderRepo extends JpaRepository<UserOrder, Long>{

}

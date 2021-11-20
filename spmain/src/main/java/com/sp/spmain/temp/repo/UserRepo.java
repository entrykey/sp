package com.sp.spmain.temp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.spmain.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByPhone(String mobile);
}

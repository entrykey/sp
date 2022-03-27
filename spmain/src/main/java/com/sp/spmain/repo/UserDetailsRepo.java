package com.sp.spmain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.spmain.model.User;

@Repository
public interface UserDetailsRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);
	
}

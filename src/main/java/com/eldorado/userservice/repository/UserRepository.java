package com.eldorado.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eldorado.userservice.entities.User;




@Repository
public interface UserRepository  extends JpaRepository<User, String>{
	 User findByUsernameIgnoreCase(String username);
}

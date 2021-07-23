package com.eldorado.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eldorado.userservice.entities.ConfirmationToken;


@Repository
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {

	public ConfirmationToken findByConfirmationToken(String confirmationToken);
}
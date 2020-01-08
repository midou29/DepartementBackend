package com.cloud.departement.gestiondepartementbackend.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.cloud.departement.gestiondepartementbackend.model.User;



public interface UserService {

	User save(User user);
	
	List<User> findAll();

	User getUserByEmail(String emai);

}

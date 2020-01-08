package com.cloud.departement.gestiondepartementbackend.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.departement.gestiondepartementbackend.model.User;
import com.cloud.departement.gestiondepartementbackend.repository.UserRepository;
import com.cloud.departement.gestiondepartementbackend.util.PasswordUtil;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired UserRepository userRepository ;

	@Override
	public User save(User user) {
		String password=PasswordUtil.getPasswordHash(user.getPassword());
		user.setPassword(password);
		user.setCreatedDate(new Date());
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
	
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		
		return userRepository.findByEmailIgnoreCase(email);
	}
}

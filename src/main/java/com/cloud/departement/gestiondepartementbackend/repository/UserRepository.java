package com.cloud.departement.gestiondepartementbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloud.departement.gestiondepartementbackend.model.User;
@Repository
public interface UserRepository extends CrudRepository<User,Long>{

	User findByEmailIgnoreCase(String username);

}

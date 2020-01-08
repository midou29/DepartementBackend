package com.cloud.departement.gestiondepartementbackend.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.departement.gestiondepartementbackend.model.User;
import com.cloud.departement.gestiondepartementbackend.service.UserService;
import com.cloud.departement.gestiondepartementbackend.domain.Response;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class PreLoginController {
	@Autowired private UserService userService ;
	
@PostMapping(value="/registration")	
public ResponseEntity<Response> registration(@RequestBody User user){
	User dbUser=userService.save(user);
	if(dbUser!=null) {
		return new ResponseEntity<Response>(new Response("User is saved succesfully"),HttpStatus.OK);
	}
	return null;
}
}

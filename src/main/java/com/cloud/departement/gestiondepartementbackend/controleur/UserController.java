package com.cloud.departement.gestiondepartementbackend.controleur;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.departement.gestiondepartementbackend.model.User;
import com.cloud.departement.gestiondepartementbackend.service.UserService;



@RestController
public class UserController {
@Autowired private UserService userService;
@GetMapping(value="/users")

public ResponseEntity<List<User>> getAllusers(){
	List<User> users=userService.findAll();
	return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	
	
}

@GetMapping(value="/getuser")



public ResponseEntity <User> getUser(Principal principal){
	
	User user=userService.getUserByEmail(principal.getName());
	return new ResponseEntity<User>(user,HttpStatus.OK);

}
}

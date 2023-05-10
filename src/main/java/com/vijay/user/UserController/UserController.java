package com.vijay.user.UserController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.user.UserEntity.User;
import com.vijay.user.UserRepository.UserRepo;
import com.vijay.user.UserService.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private UserRepo userrepo;
	
	@GetMapping("/alluser")
	public ResponseEntity<List<User>> getAllUser(){
		return ResponseEntity.ok(userservice.getAllUserList());
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserdetails(@PathVariable int id) {
//		return ResponseEntity.ok(userservice.getUserdetails(id));
		return ResponseEntity.status(HttpStatus.OK).body(userservice.getUserdetails(id));
	}
	
	@PostMapping("/saveuser")
	public ResponseEntity<User> createUserDetail(@RequestBody User user) {
		System.out.println(user.getFirstname());
		return ResponseEntity.ok(this.userservice.saveUserdetails(user));
		
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<User> updateUserDetails(@RequestBody User user, @PathVariable int id) throws NullPointerException{	
		System.out.println(id);
		return ResponseEntity.ok(userservice.updateUserdetail(user,id));
	}

}

package com.kzeus.Admin.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kzeus.Admin.Service.UsersService;
import com.kzeus.Admin.entity.Users;

@RestController
@RequestMapping("/api")
public class UsersRestController {
	
	private UsersService usersService;
	
	@Autowired
	public UsersRestController(UsersService theusersService) {
		usersService=theusersService;
	}
	
	@GetMapping("/users")
	public List<Users> findAll(){
		return usersService.findAll();
	}
	
	@GetMapping("/users/{userId}")
	public Users getUser(@PathVariable int userId) {
		Users user=usersService.findById(userId);
		if(user==null) {
			throw new RuntimeException("User not found");
		}
		return user;
	}
	
	@PostMapping("/users")
	public Users createUsers(@RequestBody Users theUsers) {
		theUsers.setId(0);
		usersService.save(theUsers);
		return theUsers;
	}
	
	@PutMapping("/users")
	public Users updateUsers(@RequestBody Users theUsers) {
		usersService.save(theUsers);
		return theUsers;
	}
	
	@DeleteMapping("/users/{usersId}")
	public String deleteUsers(@PathVariable int userId) {
		Users tempUser=usersService.findById(userId);
		if(tempUser==null) {
			throw new RuntimeException("User not found");
		}
		usersService.deleteById(userId);
		return "User with userId "+userId+" is deleted";
	}
	
	
}

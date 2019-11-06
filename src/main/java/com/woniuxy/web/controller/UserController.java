package com.woniuxy.web.controller;

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

import com.woniuxy.domain.User;
import com.woniuxy.service.IUserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private IUserService us;
	
	@PostMapping
	public void save(@RequestBody User user) {	
		
		us.add(user);
	}
	@DeleteMapping("{uid}")
	public void delete(@PathVariable Integer uid) {
		us.delete(uid);
	}
	@PutMapping
	public void update(User user) {
		us.update(user);
	}
	@GetMapping("{uid}")
	public User findOne(@PathVariable Integer uid) {
		User user = us.findOne(uid);
		return user;
	}
	@GetMapping
	public List<User> findAll(){
		List<User> list = us.findAll();
		return list;
	}
}

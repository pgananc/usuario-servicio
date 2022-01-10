package com.nisum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.dto.UserDTO;
import com.nisum.model.User;
import com.nisum.service.IUserService;

@RestController
@RequestMapping("user")
public class UserController {

	
	@Autowired
	private IUserService userService;

	@PostMapping("/create")
	public ResponseEntity<User> registrar(@Valid @RequestBody UserDTO user) {
		User userSave = userService.saveUser(user);
		return new ResponseEntity<User>(userSave, HttpStatus.CREATED);
	}
}

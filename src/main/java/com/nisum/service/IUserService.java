package com.nisum.service;

import com.nisum.dto.UserDTO;
import com.nisum.model.User;

public interface IUserService {

	User saveUser(UserDTO userDTO);

	User findByEmail(String email);
}

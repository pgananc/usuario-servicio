package com.nisum.service.impl;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nisum.dto.UserDTO;
import com.nisum.exception.ModelNotFoundException;
import com.nisum.model.User;
import com.nisum.repository.IUserRepo;
import com.nisum.service.IUserService;
import com.nisum.util.PasswordValidator;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepo userRepo;

	@Value("${password.pattern}")
	private String patternPassword;

	/**
	 * Metodo para guardar usuario.
	 */
	@Override
	public User saveUser(UserDTO userDTO) {
		User user = generarUsuario(userDTO);
		if (validateEmail(userDTO.getEmail())) {
			throw new ModelNotFoundException("El correo ya registrado ");
		}
		if (!validatePassword(user.getPassword())) {
			throw new ModelNotFoundException("El password no conicide con el patron.");
		}
		user.getPhones().forEach(p -> {
			p.setUser(user);
		});
		return userRepo.save(user);
	}

	/**
	 * Método para buscar usuario por mail.
	 */
	@Override
	public User findByEmail(String email) {
		return userRepo.findOneByEmail(email);

	}

	/**
	 * Método para validar email.
	 * 
	 * @param email Email
	 * @return Estado existe.
	 */
	private boolean validateEmail(String email) {
		User user = findByEmail(email);
		return Objects.nonNull(user);
	}

	/**
	 * Método para validar password.
	 * 
	 * @param password password.
	 * @return Estado de validación.
	 */
	private boolean validatePassword(String password) {
		return PasswordValidator.isValid(password, patternPassword);
	}

	/**
	 * Método para tranformar userDto a user.
	 * 
	 * @param userDTO Usuario dto.
	 * @return User.
	 */
	private User generarUsuario(UserDTO userDTO) {
		User user = new User();
		user.setPhones(new ArrayList<>());
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		user.setPhones(userDTO.getPhones());
		return user;
	}

}

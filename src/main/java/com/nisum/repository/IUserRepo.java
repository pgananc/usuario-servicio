package com.nisum.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nisum.model.User;

public interface IUserRepo extends JpaRepository<User, UUID> {
	User findOneByEmail(String email);
}

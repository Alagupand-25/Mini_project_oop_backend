package com.example.project.User;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.Student.model.Students;

import java.util.Optional;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);
	User getByEmail(String email);
}

package it.epicode.economicair.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.economicair.model.User;
import it.epicode.economicair.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

}

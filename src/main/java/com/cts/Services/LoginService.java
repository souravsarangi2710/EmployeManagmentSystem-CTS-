package com.cts.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.Entities.Login;
import com.cts.Repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;

	public Login login(String username, String password) {
		Login user = repo.findByUsernameAndPassword(username, password);
		return user;
	}

	public void save(Login user) {
		repo.save(user);
	}

}

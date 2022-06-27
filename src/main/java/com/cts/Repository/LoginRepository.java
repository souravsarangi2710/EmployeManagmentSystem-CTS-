package com.cts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.Entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{

	Login findByUsernameAndPassword(String username, String password);
	

}

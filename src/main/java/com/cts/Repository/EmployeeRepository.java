package com.cts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.Entities.*;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	

}

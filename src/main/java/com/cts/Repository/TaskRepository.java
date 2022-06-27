package com.cts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.Entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}

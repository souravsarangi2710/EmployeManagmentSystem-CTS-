package com.cts.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
	
	Long taskId;
	
	String taskName;
	
	String taskLead;
	
	int Duration;
	
	

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(Long taskId, String taskName, String taskLead, int duration) {
		super();
		this.taskId=taskId;
		this.taskName = taskName;
		this.taskLead = taskLead;
		Duration = duration;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskLead() {
		return taskLead;
	}

	public void setTaskLead(String taskLead) {
		this.taskLead = taskLead;
	}

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}
	
	

}

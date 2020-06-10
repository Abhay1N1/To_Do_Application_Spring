package com.abhay.springboot.todomanagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "listtodo")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String userName;

	@Size(min = 5, message = "Enter at least 5 Characters...")
	private String description;

	private Date targetDate;
	
	public Todo() {
		super();
	}

	public Todo(String user, String desc, Date targetDate, boolean isDone) {
		super();
		this.userName = user;
		this.description = desc;
		this.targetDate = targetDate;
	}
}
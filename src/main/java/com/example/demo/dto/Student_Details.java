package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Student_Details {
	@Id
	@GeneratedValue(generator = "x")
	@SequenceGenerator(initialValue = 1001, allocationSize = 1,name = "x")
	int id;
	private String name;
	private long mobile;
	private String gender;
	private int math;
	private int physics;
	private int chemistry;
	private int english;
	
	public double getPercentage() {
		return (math+physics+chemistry+english)/3.0;
	}
}

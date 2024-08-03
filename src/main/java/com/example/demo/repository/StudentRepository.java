package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Student_Details;

public interface StudentRepository extends JpaRepository<Student_Details, Integer>{

	List<Student_Details> findByName(String name);

	List<Student_Details> findByMobile(long mobile);

	List<Student_Details> findByGender(String mobile);

	List<Student_Details> findByMathGreaterThanAndPhysicsGreaterThanAndChemistryGreaterThanAndEnglishGreaterThan(
			int marks, int marks2, int marks3, int marks4);

//	List<Student_Details> findByPercentage(double percentage);

}

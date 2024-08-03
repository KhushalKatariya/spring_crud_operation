package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Student_Details;
import com.example.demo.repository.StudentRepository;

@Controller
public class MyController {

	@Autowired
	StudentRepository repository;

	@GetMapping("/")
	public String data(ModelMap map) {
		List<Student_Details> details = repository.findAll();
		if (details.isEmpty()) {
			map.put("failure", "No Records Found");
			return "data";
		} else {
			map.put("list", details);
			return "data";
		}
	}

	@GetMapping("/insert")
	public String insert(ModelMap map) {
		map.put("insert", "insert");
		return data(map);
	}

	@PostMapping("/insert")
	public String insertData(Student_Details details, ModelMap map) {
		repository.save(details);
		map.put("success", details.getName() + " Your Data Is Inserted ");
		return data(map);
	}

	@GetMapping("/delete/{id}")
	public String deleteData(@PathVariable int id, ModelMap map) {
		repository.deleteById(id);
		map.put("success", "Data is Deleted");
		return data(map);
	}

	@GetMapping("/edit/{id}")
	public String updateData(@PathVariable int id, ModelMap map) {
		Student_Details student = repository.findById(id).orElseThrow();
		map.put("student", student);
		map.put("update", "Data is Updated");
		return data(map);
	}

	@PostMapping("/update")
	public String updateData(ModelMap map, Student_Details details) {
		repository.save(details);
		map.put("success", "Records updated Successfully");
		return data(map);
	}

	@GetMapping("/fetch")
	public String fetch(ModelMap map) {
		map.put("fetch", "fetch");
		return data(map);
	}

	@GetMapping("/fetch/{field}")
	public String fetchByField(ModelMap map, @PathVariable String field) {
		map.put("fetch", "fetch");
		map.put("field", field);
		return data(map);
	}

	@PostMapping("/fetch/name")
	public String fetchByName(@RequestParam String name, ModelMap map) {
		List<Student_Details> list = repository.findByName(name);
		if (list.isEmpty()) {
			map.put("failure", "No Records Found");
			return "data";
		} else {
			map.put("success", "Records found successfully");
			map.put("list", list);
			return "data";
		}
	}

	@PostMapping("/fetch/mobile")
	public String fetchByMobile(@RequestParam long mobile, ModelMap map) {
		List<Student_Details> list = repository.findByMobile(mobile);
		if (list.isEmpty()) {
			map.put("failure", "No Records Found");
			return "data";
		} else {
			map.put("success", "Records found successfully");
			map.put("list", list);
			return "data";
		}
	}

	@PostMapping("/fetch/gender")
	public String fetchByGender(@RequestParam String gender, ModelMap map) {
		List<Student_Details> list = repository.findByGender(gender);
		if (list.isEmpty()) {
			map.put("failure", "No Records Found");
			return "data";
		} else {
			map.put("success", "Records found successfully");
			map.put("list", list);
			return "data";
		}
	}

	@PostMapping("/fetch/marks")
	public String fetchByMarks(@RequestParam int marks, ModelMap map) {
		List<Student_Details> list = repository
				.findByMathGreaterThanAndPhysicsGreaterThanAndChemistryGreaterThanAndEnglishGreaterThan(marks, marks,
						marks, marks);
		if (list.isEmpty()) {
			map.put("failure", "No Records Found");
			return "data";
		} else {
			map.put("success", "Records found successfully");
			map.put("list", list);
			return "data";
		}
	}
}

package com.andrei.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrei.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	//define @PostConstruct to load the student data....only once!
	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();
		
		students.add(new Student("Poornima", "Patel"));
		students.add(new Student("Mario", "Rossi"));
		students.add(new Student("Mary", "Smith"));
	}
	
	
	
	//define endpoint for "/students" - return list of students
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return students;
	}
	
	
	
	//define endpoint for "/students/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
					
			//check the student id against list size
		if((studentId >= students.size())||(studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		
		return students.get(studentId);
	}
	

	
}
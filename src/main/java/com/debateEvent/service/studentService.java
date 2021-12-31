package com.debateEvent.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.debateEvent.entity.Student;

@Service
public interface studentService {
	
	public void save(Student student);
	
	public List<Student> findAll();
	
	public Student findById(long id);
	
	public void deleteById(long id);
}
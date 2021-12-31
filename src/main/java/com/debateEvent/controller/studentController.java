package com.debateEvent.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.debateEvent.entity.Student;
import com.debateEvent.service.studentService;

@Controller
@RequestMapping("/")
public class studentController {

	@Autowired
	private studentService studentService;
	
	@RequestMapping("/")  
    public String display()  
    {  
        return "redirect:/list";  
    }     
	
	@RequestMapping("/list")
	public String listStudents(Model model) {
		
		List<Student> students = studentService.findAll();
		model.addAttribute("Students", students);
		return "student-list";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Student student = new Student();
		model.addAttribute("Student", student);
		return "student-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") long id, Model model) {
		
		Student student = studentService.findById(id);
		model.addAttribute("Student", student);
		return "student-form";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") long id) {
		
		studentService.deleteById(id);
		return "redirect:/list";
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") long id, @RequestParam("name") String name, 
			@RequestParam("department") String department, @RequestParam("country") String country) {
		
		System.out.println(id);
		Student student;
		
		if(id!=0) {
			
			student = studentService.findById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		}
		else {
			student = new Student(name, department, country);
		}
		studentService.save(student);
		return "redirect:/list";
	}
}
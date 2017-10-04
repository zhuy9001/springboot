package com.pgl.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pgl.demo.domain.Student;
import com.pgl.demo.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public List<Student> getStudentList(){
		return studentService.getStudentList();
	}
	
	@RequestMapping(value="/{sid}",method=RequestMethod.GET)
	public Student getStudent(@PathVariable("sid") int sid){
		return studentService.getStudentById(sid);
	}

	@RequestMapping(value = "/{sid}",method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("sid")int sid , @RequestParam(value = "name",required = true)String name,
    		@RequestParam(value = "age",required = true)int age,@RequestParam(value = "sex",required = true)String sex){
		Student student=new Student();
		student.setSsex(sex);
		student.setSname(name);
		student.setSid(sid);
		student.setSage(age);
        int t=studentService.updata(student);
        if(t==1){
            return student.toString();
        }else {
            return "fail";
        }
    }
}

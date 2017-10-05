package com.pgl.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgl.demo.dao.impl.StudentMapper;
import com.pgl.demo.domain.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentMapper studentMapper;
	
	public int add(String sname,String sex,int age) {
		return studentMapper.add(sname, sex, age);
	}

	public int update(String sname,String sex,int age,int sid) {
		return studentMapper.update(sname, sex, age, sid);
	}
	
	public int delete(int sid) {
		return studentMapper.delete(sid);
	}
	
	public Student findStudentById(int sid) {
		return (Student) studentMapper.findStudentById(sid);
	}
	
	public List<Student> getStudentList(){
		return studentMapper.getStudentList();
	}
}

package com.pgl.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgl.demo.dao.impl.StudentMapper;
import com.pgl.demo.domain.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Transactional
	public int add(String sname,String sex,int age) {
		int i=studentMapper.add(sname, sex, age);
		return i;
	}

	@Transactional
	public int update(Student student) {
		return studentMapper.update(student.getSname(), student.getSsex(), student.getSage(), student.getSid());
	}
	
	@Transactional
	public int delete(int sid) {
		return studentMapper.delete(sid);
	}
	
	@Cacheable("Student")
	public Student findStudentById(int sid) {
		return (Student) studentMapper.findStudentById(sid);
	}
	
	@Cacheable("Students")
	public List<Student> getStudentList(){
		return studentMapper.getStudentList();
	}
}

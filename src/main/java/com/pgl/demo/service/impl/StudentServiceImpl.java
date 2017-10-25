package com.pgl.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgl.demo.dao.impl.StudentMapper;
import com.pgl.demo.datasource.DataSource;
import com.pgl.demo.domain.Student;
import com.pgl.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService  {
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Transactional
	@Override
	public int add(String sname,String sex,int age) {
		int i=studentMapper.add(sname, sex, age);
		return i;
	}

	@Transactional
	@Override
	public int update(Student student) {
		return studentMapper.update(student.getSname(), student.getSsex(), student.getSage(), student.getSid());
	}
	
	@Transactional
	@Override
	public int delete(int sid) {
		return studentMapper.delete(sid);
	}
	
	@DataSource(name="sampledb")
	@Override
	public Student findStudentById(int sid) {
		return (Student) studentMapper.findStudentById(sid);
	}
	
	@DataSource(name="shiro")
	@Override
	public List<Student> getStudentList(){
		return studentMapper.getStudentList();
	}
}

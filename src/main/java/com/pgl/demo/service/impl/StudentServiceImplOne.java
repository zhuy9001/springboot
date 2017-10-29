package com.pgl.demo.service.impl;

import java.util.List;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgl.demo.dao.impl.StudentMapper;
import com.pgl.demo.domain.Student;
import com.pgl.demo.service.StudentService;

@Service
public class StudentServiceImplOne implements StudentService {
	
	@Autowired
	private StudentMapper studentMapperOne;

//	@Autowired
//	private StudentServiceImplOne studentServiceImplOne;
	
	@Transactional
	@Override
	public int addToFromDB(String ds,String sname, String sex, int age) {
		int i = studentMapperOne.add(sname, sex, age);
		//int m=1/0;
		System.out.println(ds);
		return i;
	}


	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int sid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student findStudentById(String ds, int sid) {
		// TODO Auto-generated method stub
		StudentServiceImplOne one=(StudentServiceImplOne)AopContext.currentProxy();
		return one.getStudentByIdFromDB(ds,sid);
	}

	protected Student getStudentByIdFromDB(String ds, int sid) {
		
		return studentMapperOne.findStudentById(sid);
	}


	@Override
	public List<Student> getStudentList(String ds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDataSource() {
		// TODO Auto-generated method stub

	}


	@Override
	public int add(String sname, String sex, int age) {
		// TODO Auto-generated method stub
		return 0;
	}

}

package com.pgl.demo.service;

import java.util.List;

import com.pgl.demo.domain.Student;



public interface StudentService {
	
	public int add(String sname,String sex,int age);
	public int update(Student student);
	public int delete(int sid);
	public Student findStudentById(String ds,int sid);
	public List<Student> getStudentList(String ds);
	
	public int addToFromDB(String ds,String sname,String sex,int age);
	public void updateDataSource() ;

}

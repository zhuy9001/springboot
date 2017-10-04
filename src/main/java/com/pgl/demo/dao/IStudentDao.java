package com.pgl.demo.dao;

import java.util.List;

import com.pgl.demo.domain.Student;

public interface IStudentDao {
	int add(Student student);
    int updata(Student student);
    int delete(int sid);
    Student getStudentById(int sid);
    List<Student> getStudentList();
	 
}

package com.pgl.demo.service;

import java.util.List;

import com.pgl.demo.domain.Student;

public interface IStudentService {

	int add(Student student);
    int updata(Student student);
    int delete(int sid);
    Student getStudentById(int sid);
    List<Student> getStudentList();
}

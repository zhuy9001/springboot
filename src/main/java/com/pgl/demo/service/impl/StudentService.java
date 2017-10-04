package com.pgl.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgl.demo.dao.IStudentDao;
import com.pgl.demo.domain.Student;
import com.pgl.demo.service.IStudentService;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	private IStudentDao studentDao;

	@Override
	public int add(Student student) {
		// TODO Auto-generated method stub
		return studentDao.add(student);
	}

	@Override
	public int updata(Student student) {
		return studentDao.updata(student);
	}

	@Override
	public int delete(int sid) {
		// TODO Auto-generated method stub
		return studentDao.delete(sid);
	}

	@Override
	public Student getStudentById(int sid) {
		// TODO Auto-generated method stub
		return studentDao.getStudentById(sid);
	}

	@Override
	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		return studentDao.getStudentList();
	}

}

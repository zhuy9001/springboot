package com.pgl.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pgl.demo.dao.IStudentDao;
import com.pgl.demo.domain.Student;

@Repository
public class StudentDaoImpl implements IStudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int add(Student student) {
		int m = jdbcTemplate.update("insert into student(sname,sage,ssex) values(?,?,?)", student.getSname(),
				student.getSage(), student.getSsex());
		return m;
	}

	@Override
	public int updata(Student student) {
		int m = jdbcTemplate.update("update student set sname=?,sage=?,ssex=? where sid=?", student.getSname(),
				student.getSage(), student.getSsex(),student.getSid());
		return m;
	}

	@Override
	public int delete(int sid) {
		int m=jdbcTemplate.update("delete from student where sid=?", sid);
		return m;
	}

	@Override
	public Student getStudentById(int sid) {
		List<Student> list=jdbcTemplate.query("select * from student where sid=?",new Object[]{sid},new BeanPropertyRowMapper<Student>(Student.class));
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Student> getStudentList() {
		List<Student> list=jdbcTemplate.query("select * from student",new BeanPropertyRowMapper<Student>(Student.class));
		return list;
	}

}

package com.pgl.demo.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pgl.demo.domain.Student;
/**
 * 
 * @author Administrator
 *
 */
@Mapper
public interface StudentMapper {

	@Insert("insert into student(sname,ssex,sage) values(#{name},#{sex},#{age})")
	int add(@Param("name") String name,@Param("sex") String sex,@Param("age") int age);
	
	
	@Update("update student set sname=#{name},sage=#{age},ssex=#{sex} where sid=#{sid}")
	int update(@Param("name")String name,@Param("sex") String sex,@Param("age") int age,@Param("sid") int sid); 
	
	@Delete("Delete from student where sid=#{sid}")
	int delete(@Param("sid") int sid);
	
	@Select("select sid,sname,sage,ssex from student ")
	List<Student> getStudentList();
	
	@Select("select sid,sname,sage,ssex from student where sid=#{sid} ")
	Student findStudentById(@Param("sid") int sid);
	

}

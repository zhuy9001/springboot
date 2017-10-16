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

	/**
	 * 新增学生信息
	 * @param name 学生姓名
	 * @param sex 学生性别
	 * @param age 学生年龄
	 * @return 返回新增成功数据条数
	 */
	@Insert("insert into student(sname,ssex,sage) values(#{name},#{sex},#{age})")
	int add(@Param("name") String name,@Param("sex") String sex,@Param("age") int age);
	
	/**
	 * 修改学生信息
	 * @param name 学生姓名
	 * @param sex 学生性别
	 * @param age 学生年龄
	 * @param sid 要修改的学生ID
	 * @return 修改成功条数
	 */
	@Update("update student set sname=#{name},sage=#{age},ssex=#{sex} where sid=#{sid}")
	int update(@Param("name")String name,@Param("sex") String sex,@Param("age") int age,@Param("sid") int sid); 
	
	/**
	 * 删除学生信息
	 * @param sid 学生ID
	 * @return 成功记录数
	 */
	@Delete("Delete from student where sid=#{sid}")
	int delete(@Param("sid") int sid);
	
	/**
	 * 查询所有学生信息
	 * @return 返回多条学生结果集
	 */
	@Select("select sid,sname,sage,ssex from student ")
	List<Student> getStudentList();
	
	/**
	 * 根据学生ID查询学生信息
	 * @param sid 学生ID
	 * @return 返回学生信息
	 */
	@Select("select sid,sname,sage,ssex from student where sid=#{sid} ")
	Student findStudentById(@Param("sid") int sid);
	

}

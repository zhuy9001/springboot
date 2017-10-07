package com.pgl.demo.controller;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgl.demo.domain.Student;
import com.pgl.demo.service.impl.StudentService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@ApiOperation(value="获取学生列表",notes="获取学生列表")
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Student> getStudentList(){
		return studentService.getStudentList();
	}
	
	@ApiOperation(value="获取某个学生详细信息",notes="获取某个学生详细信息")
	@ApiImplicitParam(name="sid",value="学生编号",required=true,dataType="int")
	@RequestMapping(value="/{sid}",method=RequestMethod.GET)
	public Student getStudent(@PathVariable("sid") int sid){
		
		return studentService.findStudentById(sid);
	}

	@ApiOperation(value="修改某个学生的信息",notes="修改某个学生的信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name="student",value="学生实体",required=true,dataType="Student"),
		@ApiImplicitParam(name="sid",value="学生编号",required=true,dataType="int")
	})
	@RequestMapping(value = "/{sid}",method = RequestMethod.PUT)
    public String updateStudent(@PathVariable("sid")int sid ,Student student){
		student.setSid(sid);
        int t=studentService.update(student.getSname(),student.getSsex(),student.getSage(),sid);
        if(t==1){
            return student.toString();
        }else {
            return "fail";
        }
    }
	
	@ApiOperation(value="新增学生的信息",notes="新增学生的信息")
	@ApiImplicitParam(name="student",value="学生实体",required=true,dataType="Student")
	@RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addStudent(Student student){
        int t=studentService.add(student.getSname(),student.getSsex(),student.getSage());
        if(t==1){
            return student.toString();
        }else {
            return "fail";
        }
    }
	@ApiOperation(value="删除学生信息",notes="根据学生编号删除学生信息")
	@ApiImplicitParam(name="sid",value="学生编号",required=true,dataType="int")
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public Student deleteStudent(@PathVariable("sid") int sid) {
		Student stu=studentService.findStudentById(sid);
		studentService.delete(sid);
		return stu;
	}
}

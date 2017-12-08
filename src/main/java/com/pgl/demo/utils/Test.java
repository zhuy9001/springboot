package com.pgl.demo.utils;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import com.pgl.demo.domain.Student;
import com.pgl.demo.domain.StudentVo;
import com.pgl.demo.domain.StudentVo1;

public class Test {

    public static void getObject() {
    	DozerBeanMapper beanMapper=new DozerBeanMapper();
    	Student student=new Student();
    	student.setSid(1);
    	student.setSname("张三");
    	student.setSage(23);
    	student.setSsex("女");
    	StudentVo svo=beanMapper.map(student, StudentVo.class);
    	System.out.println(svo.toString());
    	StudentVo1 svo1=beanMapper.map(student, StudentVo1.class);
    	System.out.println(svo1.toString());
    }
    
    
 
	
	public static void main(String[] args) {
		getObject();
	}
	
}

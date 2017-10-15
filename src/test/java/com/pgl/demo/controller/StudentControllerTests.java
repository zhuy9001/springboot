package com.pgl.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pgl.demo.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentControllerTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setupMockMvc() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	/**
	 * 测试新增学生
	 * @throws Exception
	 */
	@Test
	public void addStudent() throws Exception {
		Student student = new Student();
		student.setSname("胖头鱼");
		student.setSage(35);
		student.setSsex("男");
		ObjectMapper mapper = new ObjectMapper();
		mockMvc.perform(post("/student/add").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsString(student))).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.errcode", is(200)))  
        .andExpect(jsonPath("$.data", notNullValue()))  
        .andExpect(jsonPath("$.data.sage", is(35)))
        .andExpect(jsonPath("$.data.ssex", is("男")))  
        .andExpect(jsonPath("$.data.sname", is("胖头鱼")));

	}
	/**
	 * 测试修改学生信息
	 * @throws Exception
	 */
	@Test
	public void updateStudent() throws Exception {
		Student student = new Student();
		student.setSname("小白鸽");
		student.setSage(25);
		student.setSsex("女");
		student.setSid(25);
		ObjectMapper mapper = new ObjectMapper();
		mockMvc.perform(put("/student/update").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsString(student))).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.errcode", is(200)))  
        .andExpect(jsonPath("$.data", notNullValue()));

	}
	
	/**
	 * 测试删除学生信息
	 * @throws Exception
	 */
	@Test
	public void deleteStudent() throws Exception {
		mockMvc.perform(delete("/student/delete/10"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.errcode", is(200)))  
        .andExpect(jsonPath("$.data", notNullValue()));

	}
	
	  /*** 
     * 测试获取学生信息
     * @throws Exception 
     */  
    @Test  
    public void testStudent() throws Exception  
    {  
        mockMvc.perform(get("/student/24"))  
        .andExpect(status().isOk())  
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))  
        .andExpect(jsonPath("$.errcode", is(200)))  
        .andExpect(jsonPath("$.data", notNullValue()));  
    }  
	
    /*** 
     * 测试获取用户列表接口 
     * @throws Exception 
     */  
    @Test  
    public void testStudentList() throws Exception  
    {  
        mockMvc.perform(get("/student/list"))  
        .andExpect(status().isOk())  
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))  
        .andExpect(jsonPath("$.errcode", is(200)))  
        .andExpect(jsonPath("$.data", notNullValue()));  
    } 
}

package com.pgl.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgl.demo.domain.Student;
import com.pgl.demo.service.StudentService;
import com.pgl.demo.service.impl.StudentServiceImpl;
import com.pgl.demo.service.impl.StudentServiceImplOne;
import com.pgl.demo.utils.ResultMsg;
import com.pgl.demo.utils.ResultStatusCode;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentServiceImpl studentService;
	@Autowired
	private StudentServiceImplOne studentServiceImpl;

	@ApiOperation(value = "获取学生列表", notes = "获取学生列表")
	@RequestMapping(value = "/list/{dbname}", method = RequestMethod.GET)
	public ResultMsg getStudentList(@PathVariable String dbname) {
		List<Student> list=studentService.getStudentList(dbname);
		return new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), list);
	}

	@ApiOperation(value = "获取某个学生详细信息", notes = "获取某个学生详细信息")
	@ApiImplicitParam(name = "sid", value = "学生编号", required = true, dataType = "int")
	@RequestMapping(value = "/{sid}", method = RequestMethod.GET)
	public ResultMsg getStudent(@PathVariable("sid") int sid) {
        Student student=studentService.findStudentById("wold",sid);
		return new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), student);
	}

	@ApiOperation(value = "修改某个学生的信息", notes = "修改某个学生的信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "student", value = "学生实体", required = true, dataType = "Student"),
			@ApiImplicitParam(name = "sid", value = "学生编号", required = true, dataType = "int") })
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResultMsg updateStudent(@RequestBody Student student) {
		Student stu = studentService.findStudentById("wold",student.getSid());
		if (stu == null) {
			return new ResultMsg(ResultStatusCode.NULL_OBJ.getErrcode(), ResultStatusCode.NULL_OBJ.getErrmsg(),
					student);
		}
		stu.setSage(student.getSage());
		stu.setSname(student.getSname());
		stu.setSsex(student.getSsex());
		int n = studentService.update(stu);
		if (n > 0) {
			return new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), student);
		}
		return new ResultMsg(ResultStatusCode.DB_SERVICE_UNKNOWN_ERROR.getErrcode(),
				ResultStatusCode.DB_SERVICE_UNKNOWN_ERROR.getErrmsg(), student);

	}

	@ApiOperation(value = "新增学生的信息", notes = "新增学生的信息")
	@ApiImplicitParam(name = "student", value = "学生实体", required = true, dataType = "student")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultMsg addStudent(@RequestBody Student student) {
		studentService.add(student.getSname(), student.getSsex(), student.getSage());
		ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), student);
		return resultMsg;
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ResultMsg addStudentFromDB(@RequestBody Student student) {
		//studentServiceImpl.addToFromDB("shiro",student.getSname(), student.getSsex(), student.getSage());
		//List<Student> stu =studentService.getStudentList("sampledb");
		Student stu=studentServiceImpl.findStudentById("sampledb",1);
		ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), stu);
		return resultMsg;
	}


	@ApiOperation(value = "删除学生信息", notes = "根据学生编号删除学生信息")
	@ApiImplicitParam(name = "sid", value = "学生编号", required = true, dataType = "int")
	@RequestMapping(value = "/delete/{sid}", method = RequestMethod.DELETE)
	public ResultMsg deleteStudent(@PathVariable("sid") int sid) {
		Student stu = studentService.findStudentById("wold",sid);
		int m=studentService.delete(sid);
		if(m>0) {
			return new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), stu);
		}
		return new ResultMsg(ResultStatusCode.DB_SERVICE_UNKNOWN_ERROR.getErrcode(),
				ResultStatusCode.DB_SERVICE_UNKNOWN_ERROR.getErrmsg(), stu);
	}
}

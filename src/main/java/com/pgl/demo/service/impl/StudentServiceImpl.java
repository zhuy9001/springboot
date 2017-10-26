package com.pgl.demo.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgl.demo.dao.impl.StudentMapper;
import com.pgl.demo.datasource.DataSource;
import com.pgl.demo.datasource.DynamicDataSource;
import com.pgl.demo.domain.Student;
import com.pgl.demo.service.StudentService;
import com.pgl.demo.utils.SpringUtil;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	@Transactional
	@Override
	public int add(String sname, String sex, int age) {
		int i = studentMapper.add(sname, sex, age);
		return i;
	}

	@Transactional
	@Override
	public int update(Student student) {
		return studentMapper.update(student.getSname(), student.getSsex(), student.getSage(), student.getSid());
	}

	@Transactional
	@Override
	public int delete(int sid) {
		return studentMapper.delete(sid);
	}

	@DataSource(name = "sampledb")
	@Override
	public Student findStudentById(int sid) {
		return (Student) studentMapper.findStudentById(sid);
	}

	@Override
	public List<Student> getStudentList() {
		updateDataSource();
		return studentMapper.getStudentList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateDataSource() {
		ApplicationContext context = SpringUtil.getApplicationContext();
		DynamicDataSource ds = context.getBean(DynamicDataSource.class);
		Class<? extends DynamicDataSource> dsClass = ds.getClass();
		Map<String, Object> targetMap = null;
		Field[] fs = dsClass.getSuperclass().getDeclaredFields();
		try {
			for (int i = 0; i < fs.length; i++) {
				Field f = fs[i];
				f.setAccessible(true);
				if ("targetDataSources".equals(f.getName())) {
					targetMap = (Map<String, Object>) f.get(ds);
					break;
				}

			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String key : targetMap.keySet()) {
			System.out.println(key+"="+targetMap.get(key));
		}

		// GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		// beanDefinition.setBeanClass(DynamicDataSource.class);
		// beanDefinition.setSynthetic(true);
		// MutablePropertyValues mpv = beanDefinition.getPropertyValues();
		// mpv.addPropertyValue("defaultTargetDataSource", "");
		// mpv.addPropertyValue("targetDataSources", "");
		// registry.registerBeanDefinition("dataSource", beanDefinition);
	}
}

package com.heqing;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heqing.bean.Classes;
import com.heqing.bean.Teacher;
import com.heqing.service.ClassesService;
import com.heqing.service.TeacherService;

@RunWith(SpringJUnit4ClassRunner.class)		// 表示继承了 SpringJUnit4ClassRunner 类
@ContextConfiguration("classpath:spring-hibernate.xml")
public class TestHibernate {

	@Resource
	private SessionFactory sessionFactory;
	@Resource
	protected ClassesService classesService;
	@Resource
	protected TeacherService teacherService;
	
	@Test
	public void testSave() throws Exception {
		Classes classes1 = new Classes();
		classes1.setName("一班");
		Classes classes2 = new Classes();
		classes2.setName("二班");
		Teacher teacher1 = new Teacher();
		teacher1.setName("小贺");
		Teacher teacher2 = new Teacher();
		teacher2.setName("小刘");
		
		Set<Classes> classList = new HashSet<Classes>();
		classList.add(classes1);
		classList.add(classes2);
		Set<Teacher> teacherList = new HashSet<Teacher>();
		teacherList.add(teacher1);
		teacherList.add(teacher2);

		//一对一
		teacher1.setSuperviseClass(classes1);
		teacher2.setSuperviseClass(classes2);
		//一对多
		classes1.setClassDirector(teacher1);
		classes1.setHeadTeacher(teacher1);
		classes2.setClassDirector(teacher1);
		classes2.setHeadTeacher(teacher2);
		teacher1.setClassDirector(classList);
		//多对多
		teacher1.setTeachClasses(classList);
		teacher2.setTeachClasses(classList);
		
		teacherService.save(teacher1);
		teacherService.save(teacher2);
	}
	
//	@Test
	public void testOneToOne() throws Exception {
		Teacher teacher = teacherService.getById(1L);
		System.out.println(teacher.getSuperviseClass().getName());
		
		Classes classes = classesService.getById(1l);
		System.out.println(classes.getHeadTeacher().getName());
	}
	
//	@Test
	public void testManyToMany() throws Exception {
		Teacher teacher = teacherService.getById(1L);
		for(Classes c : teacher.getTeachClasses()) {
			System.out.println(c.getName());
		}
		
		Classes classes = classesService.getById(1l);
		for(Teacher t : classes.getTeachers()) {
			System.out.println(t.getName());
		}
	}
	
//	@Test
	public void testOneToMany() throws Exception {
		Teacher teacher = teacherService.getById(1L);
		for(Classes c : teacher.getTeachClasses()) {
			System.out.println(c.getName());
		}
		
		Classes classes = classesService.getById(1l);
		for(Teacher t : classes.getTeachers()) {
			System.out.println(t.getName());
		}
	}
}

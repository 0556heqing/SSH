package com.heqing.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heqing.base.BaseDaoImpl;
import com.heqing.bean.Teacher;
import com.heqing.dao.TeacherDao;
import com.heqing.service.TeacherService;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl  extends BaseDaoImpl<Teacher> implements TeacherService{

	@Resource
	private TeacherDao teacherDao;
	
}

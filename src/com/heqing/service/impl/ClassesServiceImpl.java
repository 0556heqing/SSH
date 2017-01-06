package com.heqing.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heqing.base.BaseDaoImpl;
import com.heqing.bean.Classes;
import com.heqing.dao.ClassesDao;
import com.heqing.service.ClassesService;

@Service("classesService")
@Transactional
public class ClassesServiceImpl  extends BaseDaoImpl<Classes> implements ClassesService{

	@Resource
	private ClassesDao classesDao;
	
}

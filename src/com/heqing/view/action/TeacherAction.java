package com.heqing.view.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heqing.base.BaseAction;
import com.heqing.bean.Classes;
import com.heqing.bean.Teacher;
import com.heqing.service.TeacherService;
import com.heqing.util.HqlHelper;

@Controller
@Scope("prototype")
public class TeacherAction extends BaseAction<Classes> {

	@Resource
	protected TeacherService teacherService;
	
	public String page() throws Exception {
		int pageSize =5;
	    new HqlHelper(Teacher.class).buildPageBeanForStruts2(pageNum, pageSize, teacherService);
		return "page";
	}
}

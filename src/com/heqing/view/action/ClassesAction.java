package com.heqing.view.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heqing.base.BaseAction;
import com.heqing.bean.Classes;
import com.heqing.service.ClassesService;
import com.heqing.util.HqlHelper;

@Controller
@Scope("prototype")
public class ClassesAction extends BaseAction<Classes> {

	@Resource
	protected ClassesService classesService;
	
	public String save() throws Exception {
		System.out.println("===save===");
		Classes classes = new Classes();
		classes.setName("新的班级");
		classesService.save(classes);
		return "save";
	}
	
	public String page() throws Exception {
		int pageSize =5;
	    new HqlHelper(Classes.class).buildPageBeanForStruts2(pageNum, pageSize, classesService);
		return "page";
	}
}

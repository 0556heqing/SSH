package com.heqing.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Teacher extends People {

	private String post;
	private Classes superviseClass;				//管理班级
	private Set<Classes> teachClasses;		//授课班级
	private Set<Classes> classDirector;		//班级主任

	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "superviseclass_Id")
	public Classes getSuperviseClass() {
		return superviseClass;
	}
	public void setSuperviseClass(Classes superviseClass) {
		this.superviseClass = superviseClass;
	}
	
	//fetch=FetchType.lLAZY 异常原因：由于延迟加载，之前的操作使session已经关闭
    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(
        name="teacher_classes",
        joinColumns=@JoinColumn(name="teacher_id"),
        inverseJoinColumns=@JoinColumn(name="classes_id")
    )
	public Set<Classes> getTeachClasses() {
		return teachClasses;
	}
	public void setTeachClasses(Set<Classes> teachClasses) {
		this.teachClasses = teachClasses;
	}
	
	@OneToMany( targetEntity = Classes.class, mappedBy = "classDirector",cascade = CascadeType.ALL,fetch=FetchType.EAGER)  
	public Set<Classes> getClassDirector() {
		return classDirector;
	}
	public void setClassDirector(Set<Classes> classDirector) {
		classDirector = classDirector;
	}
}

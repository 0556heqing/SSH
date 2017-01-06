package com.heqing.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public class People implements Serializable {

	private long id;
	private String name;
	private Date birthday;
	private int age;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Transient 
	public int getAge() {
		return getYear(new Date())-getYear(birthday);
	}
	private int getYear(Date date){
		Calendar cal=Calendar.getInstance();//使用日历类
		cal.setTime(date);
		return cal.get(Calendar.YEAR);//得到年
	}
}

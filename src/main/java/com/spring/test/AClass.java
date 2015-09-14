package com.spring.test;


/**
 * User: kingkong.wang
 * Date: 15-7-8
 */

public class AClass implements Holiday{
	private Integer id;
	private String name;

	private Student student;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public void holiday() {

	}

}

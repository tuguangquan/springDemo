package com.spring.test;

/**
 * User: kingkong.wang
 * Date: 15-7-7
 */
public class Student implements Holiday{
	private Integer id;
	private String name;

	public Student(){

	}
	public Student(Integer id,String name){
		this.id=id;
		this.name=name;
	}
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

	public void start(){
		System.out.println(123456789);
	}

	@Override
	public void holiday() {

	}
}

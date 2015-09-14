package com.spring.test;


/**
 * User: kingkong.wang
 * Date: 15-7-7
 */
public class School implements Holiday {
	private Integer id;
	private String name;
	private com.spring.test.AClass aClass;

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

	public AClass getaClass() {
		return aClass;
	}

	public void setaClass(AClass aClass) {
		this.aClass = aClass;
	}

	@Override
	public void holiday() {

	}
}

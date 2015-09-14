package com.spring.test;


import com.spring.context.ApplicationContext;
import com.spring.context.ClassPathXmlApplicationContext;




/**
 * User: kingkong.wang
 * Date: 15-7-7
 */

public class Main {
	public static void main(String[] args) throws Exception{
		ApplicationContext ac1 = new ClassPathXmlApplicationContext("config/appcontext.xml");

		School school=(School)ac1.getBean("school");
		System.out.println(school.getaClass().getName());

	}
}
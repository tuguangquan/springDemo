package com.spring.test;

/**
 * User: kingkong.wang
 * Date: 15-7-23
 */
public class LoggingWidget extends Widget {
	public synchronized void doSomestring(){
		System.out.println(Thread.currentThread().getName()+"321");
		super.doSomestring();
	}
}

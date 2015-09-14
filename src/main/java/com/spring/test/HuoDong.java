package com.spring.test;

import org.apache.log4j.Logger;

/**
 * User: kingkong.wang
 * Date: 15-7-13
 */
public class HuoDong {
	static Logger logger = Logger.getLogger(HuoDong.class.getName());

	public void before(){
		logger.info("before doing");
	}
	public void after(){
		logger.info("after doing");
	}
}

package com.spring.util.impl;

import com.spring.util.Converter;

/**
 * User: kingkong.wang
 * Date: 15-7-13
 */
public class StringToIntergerConverter implements Converter<String,Integer> {

	@Override
	public Integer convert(String source) {
		return Integer.parseInt(source);
	}
}

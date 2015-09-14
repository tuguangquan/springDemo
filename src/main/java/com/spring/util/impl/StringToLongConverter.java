package com.spring.util.impl;

import com.spring.util.Converter;

/**
 * User: kingkong.wang
 * Date: 15-7-13
 */
public class StringToLongConverter implements Converter<String,Long> {

	@Override
	public Long convert(String source) {
		return Long.parseLong(source);
	}
}

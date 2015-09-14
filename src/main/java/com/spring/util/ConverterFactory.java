package com.spring.util;

/**
 * User: kingkong.wang
 * Date: 15-7-14
 */
public interface ConverterFactory {
	public Converter getConverter(Class parameterType);
}

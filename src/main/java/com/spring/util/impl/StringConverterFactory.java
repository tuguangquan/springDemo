package com.spring.util.impl;

import com.spring.util.Converter;
import com.spring.util.ConverterFactory;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * User: kingkong.wang
 * Date: 15-7-14
 */
public class StringConverterFactory implements ConverterFactory {

	static Logger logger = Logger.getLogger(StringConverterFactory.class.getName());
	public static Map<Class, Converter> class2Converter = new HashMap<Class, Converter>();

	static {
		try {
			class2Converter.put(Integer.class, StringToIntergerConverter.class.newInstance());
			class2Converter.put(Boolean.class, StringToBooleanConverter.class.newInstance());
			class2Converter.put(Long.class, StringToLongConverter.class.newInstance());
		} catch (InstantiationException e) {
			throw new RuntimeException("");
		} catch (IllegalAccessException e) {
			logger.error("由于无法访问private函数，导致实例化失败");
			throw new RuntimeException("");
		}
	}

	@Override
	public Converter getConverter(Class parameterType) {
		if (class2Converter.get(parameterType) != null) {
			return class2Converter.get(parameterType);
		} else {
			return null;
		}

	}

}

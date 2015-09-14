package com.spring.util;

/**
 * User: kingkong.wang
 * Date: 15-7-13
 */
public interface Converter <S, T> {
	T convert(S source);
}

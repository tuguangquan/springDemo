package com.spring.beans;

/**
 * User: kingkong.wang
 * Date: 15-7-23
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}

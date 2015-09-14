package com.spring.beans.factory;

/**
 * User: kingkong.wang
 * Date: 15-7-23
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

}

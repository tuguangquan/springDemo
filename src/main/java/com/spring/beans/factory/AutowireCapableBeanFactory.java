package com.spring.beans.factory;

import com.spring.BeanReference;
import com.spring.beans.BeanDefinition;
import com.spring.beans.PropertyValue;
import com.spring.util.ConverterFactory;
import com.spring.util.impl.StringConverterFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * User: kingkong.wang
 * Date: 15-7-23
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

	protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
		for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
			Object value = propertyValue.getValue();
			if (value instanceof BeanReference) {
				BeanReference beanReference = (BeanReference) value;
				value = getBean(beanReference.getName());
				invokeSetValue(bean, propertyValue, value);
			} else {
				Method[] methods = bean.getClass().getDeclaredMethods();
				for (Method method : methods) {
					if (method.getName().equals("set" + propertyValue.getName().substring(0, 1).toUpperCase()
							+ propertyValue.getName().substring(1))) {
						Class<?>[] parameterTypes = method.getParameterTypes();
						if (parameterTypes.length == 1) {
							Class<?> parameterType = parameterTypes[0];
							try {
								invokeSetValue(bean, method, parameterType, value.toString());
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

	private void invokeSetValue(Object obj, Method method, Class parameterType,
								String propertyValue) throws IllegalAccessException, InvocationTargetException {
		ConverterFactory converterFactory = new StringConverterFactory();

		if (converterFactory.getConverter(parameterType) != null) {
			method.invoke(obj, converterFactory.getConverter(parameterType).convert(propertyValue));
		} else {
			method.invoke(obj, propertyValue);
		}

	}

	private void invokeSetValue(Object bean, PropertyValue propertyValue, Object value) throws Exception {
		try {
			Method declaredMethod = bean.getClass().getDeclaredMethod(
					"set" + propertyValue.getName().substring(0, 1).toUpperCase()
							+ propertyValue.getName().substring(1), value.getClass());
			declaredMethod.setAccessible(true);

			declaredMethod.invoke(bean, value);
		} catch (NoSuchMethodException e) {
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
			declaredField.setAccessible(true);
			declaredField.set(bean, value);
		}
	}
}

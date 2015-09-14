package com.spring.context;

import com.spring.beans.BeanDefinition;
import com.spring.beans.factory.AbstractBeanFactory;
import com.spring.beans.factory.AutowireCapableBeanFactory;
import com.spring.beans.io.ResourceLoader;
import com.spring.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * User: kingkong.wang
 * Date: 15-7-23
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

	private String configLocation;

	public ClassPathXmlApplicationContext(String configLocation) throws Exception {
		this(configLocation, new AutowireCapableBeanFactory());
	}

	public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
		super(beanFactory);
		this.configLocation = configLocation;
		refresh();
	}

	@Override
	protected void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}
	}

	public void refresh() throws Exception {
		loadBeanDefinitions(beanFactory);
	//	registerBeanPostProcessors(beanFactory);
		onRefresh();
	}

}

package com.ilegra.curriculos.spring;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

public class Application {
	
		
	public static void main(String[] args) {
	    PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
	    propertiesFactoryBean.setLocation(new ClassPathResource("/lucene.properties"));
	    Properties properties = null;
	    try {
	        propertiesFactoryBean.afterPropertiesSet();
	        properties = propertiesFactoryBean.getObject();

	    } catch (IOException e) {
	        System.out.println("Cannot load properties file.");
	    }
	    System.out.println(properties.getProperty("indexpath"));
	}
}
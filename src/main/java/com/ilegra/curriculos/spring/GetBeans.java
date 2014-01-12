package com.ilegra.curriculos.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ilegra.curriculos.search.Searcher;

public class GetBeans{
	
	public Searcher getSearcher() {
		 ApplicationContext context = new ClassPathXmlApplicationContext("spring-lucene-context-beans.xml");
         Searcher searcher = (Searcher) context.getBean("searcher");
         System.out.println(searcher.getIndexPath());
         return searcher;
	}
}
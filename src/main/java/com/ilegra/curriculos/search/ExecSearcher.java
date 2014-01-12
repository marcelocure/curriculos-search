package com.ilegra.curriculos.search;

import java.io.IOException;

import org.apache.lucene.queryparser.classic.ParseException;

import com.ilegra.curriculos.spring.GetBeans;

public class ExecSearcher {
	public static void main(String[] args) throws IOException, ParseException {
		Searcher searcher = new GetBeans().getSearcher();
		searcher.search("Oracle");
	}
}
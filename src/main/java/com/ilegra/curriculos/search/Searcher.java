package com.ilegra.curriculos.search;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class Searcher {
	private String indexPath;
	
	public List<String> search(String queryText) throws IOException, ParseException {
		IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(indexPath)));
		IndexSearcher searcher = new IndexSearcher(reader);
		QueryParser parser = new QueryParser(Version.LUCENE_45, "content",new StandardAnalyzer(Version.LUCENE_45));
		return getResults(searcher, parser.parse(queryText));
	}

	private List<String> getResults(IndexSearcher searcher, Query query) throws IOException {
		TopDocs results = searcher.search(query, 10);
		ScoreDoc[] hits = results.scoreDocs;

		List<String> urls = new ArrayList<String>();
		for (ScoreDoc hit : hits) {
			Document doc = searcher.doc(hit.doc);
			urls.add(doc.get("url"));
		}
		return urls;
	}

	public void setIndexPath(String indexPath) {
		this.indexPath = indexPath;
	}

	public String getIndexPath() {
		return indexPath;
	}
}
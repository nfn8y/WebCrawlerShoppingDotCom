package com.controller;

import java.io.IOException;

import com.util.Crawler;
import com.util.UrlProvider;

public class Searcher {
	/**
	 * Searches and returns count of Usable links containing the product name
	 * either on one page or on all pages.
	 */
	private int searchCount;
	
	public int getSearchCount(String searchKey) throws IOException {
		Crawler crawler = new Crawler(new UrlProvider(searchKey).getUrl());
		this.searchCount += crawler.searchAndCount().size();
		int pageCount = 2;
		while(true && this.searchCount>0) {
			crawler = new Crawler(new UrlProvider(searchKey, pageCount).getUrl());
			if(crawler.searchAndCount().size() == 0) {
				break;
			} else{
				this.searchCount += crawler.searchAndCount().size();
				pageCount++;
			}
		}
		return this.searchCount;
	}
	
	public int getSearchCount(String searchKey, int pageNum) throws IOException {
		Crawler crawler = new Crawler(new UrlProvider(searchKey, pageNum).getUrl());
		this.searchCount += crawler.searchAndCount().size();
		return this.searchCount;
	}

	public void setSearchCount(int searchCount) {
		this.searchCount = searchCount;
	}
}

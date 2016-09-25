package com.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	/**
	 * Searches the page for links containing name of the product being 
	 * searched and returns a list of links 
	 */
	private String url;
	public Crawler(String url) {
		this.url = url;
	}
	
	public List<String> searchAndCount() throws IOException {
		Elements links;
		List<String> foundUrls = new ArrayList<String>();
		Document document = Jsoup.connect(this.url).get();
		//Searching among links
		links = document.select("a[class*=productName]");
		for(Element link: links) {
			foundUrls.add(link.html());
		}
		return foundUrls;
	}
}

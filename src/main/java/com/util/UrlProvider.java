package com.util;

public class UrlProvider {
	/**
	 * Creates URL based on the product key being searched 
	 * and the page number on which it is being searched
	 */
	private String url;
	public UrlProvider(String product) {
		this.url = "http://www.shopping.com/products?KW="+product;
	}
	public UrlProvider(String product, int pageNum) {
		this.url = "http://www.shopping.com/products~PG-"+pageNum+"?KW="+product;
	}
	public String getUrl() {
		return this.url;
	}
}

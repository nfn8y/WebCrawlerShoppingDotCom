package com.test;

import java.io.IOException;
import java.util.Scanner;

import com.controller.Searcher;

public class WebCrawlerTest {

	public static void main(String[] args) {
		if(args.length == 2) {
			try {
				int pageNum;
				try {
					pageNum = Integer.parseInt(args[1]);
					System.out.println("");
					Searcher searcher = new Searcher();
					System.out.println();
					int count = searcher.getSearchCount(args[0], pageNum);
					System.out.println();
					System.out.println(count+" results found on page "+pageNum+" for "+args[0]);
				} catch(NumberFormatException e) {
					System.out.println("Invalid/ No page number found.");
					System.out.println("Searching for "+args[0]+" on all pages");
					System.out.println("");
					Searcher searcher = new Searcher();
					System.out.println();
					int count = searcher.getSearchCount(args[0]);
					System.out.println();
					System.out.println(count+" results found for ."+args[0]);
				} 
			} catch (IOException e) {
				System.out.println("Could not connect to www.shopping.com.\nPlease check your Internet connection");
			}
		} else if(args.length == 1) {
			try {
				System.out.println("Searching for "+args[0]+" on all pages");
				Searcher searcher = new Searcher();
				System.out.println();
				int count = searcher.getSearchCount(args[0]);
				System.out.println();
				System.out.println(count+" results found for ."+args[0]);
			} catch (IOException e) {
				System.out.println("Could not connect to www.shopping.com.\nPlease check your Internet connection");
			}
		} else {
			Scanner scanner = new Scanner(System.in);
			try {
				System.out.println("Please enter the keyword to search");
				String searchKey = scanner.nextLine();
				System.out.println("Please enter a page number to search on");
				int pageNum;
				try {
					pageNum = Integer.parseInt(scanner.nextLine());
					System.out.println("");
					Searcher searcher = new Searcher();
					System.out.println();
					int count = searcher.getSearchCount(searchKey, pageNum);
					System.out.println();
					System.out.println(count+" results found on page "+pageNum+" for "+searchKey);
				} catch(NumberFormatException e) {
					System.out.println("Invalid/ No page number found.");
					System.out.println("Searching for "+searchKey+" on all pages");
					System.out.println("");
					Searcher searcher = new Searcher();
					System.out.println();
					int count = searcher.getSearchCount(searchKey);
					System.out.println();
					System.out.println(count+" results found for ."+searchKey);
				} 
			} catch(NumberFormatException e) {
				System.out.println("Invalid page number found.\nKindly re-run the program.");
			} catch (IOException e) {
				System.out.println("Could not connect to www.shopping.com.\nPlease check your Internet connection");
				e.printStackTrace();
			} finally {
				scanner.close();
			}
		}
	}

}

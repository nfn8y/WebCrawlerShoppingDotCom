import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.controller.Searcher;

public class SearcherTest {
	/**
	 * All the test cases from CrawlTest are necessary
	 * for this class to be proven working nicely
	 */
	@Test
	public void testSearch() {
		Searcher searcher = new Searcher();
		try {
			if(searcher.getSearchCount("a", 1) == 0) {
				fail("The search failed because of an error");
			}
		} catch (IOException e) {
			fail("The search failed because of an IOException");
		}
	}

}

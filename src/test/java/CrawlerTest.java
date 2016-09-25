import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.util.Crawler;

public class CrawlerTest {

	@Test
	public void testingEmptyLink() {
		try {
			Crawler crawler = new Crawler("");
			crawler.searchAndCount();
			fail("An IllegalArgumentException was expected");
		} catch (IOException e) {

		} catch (IllegalArgumentException e) {
			
		}
	}
	@Test
	public void testingForEmptySearchUrl() {
		try {
			Crawler crawler = new Crawler("http://www.shopping.com/products?KW=");
			assertEquals(0, crawler.searchAndCount().size());
		} catch (IOException e) {
			fail("An IOException has occurred");
		}
	}
	@Test
	public void testingForNonEmptyUrl() {
		/**
		 * Assumes that the main page must have had 
		 * at least one product to display
		 * Exclude this test if the page is empty
		 */
		try {
			Crawler crawler = new Crawler("http://www.shopping.com/");
			if(crawler.searchAndCount().size() > 0) {
				return;
			}
			fail("At least one product was expected on the main page");
		} catch (IOException e) {
			fail("An IOException has occurred");
		}
	}

}

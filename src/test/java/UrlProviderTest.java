import static org.junit.Assert.*;

import org.junit.Test;

import com.util.UrlProvider;

public class UrlProviderTest {

	@Test
	public void testSingle() {
		UrlProvider urlProvider = new UrlProvider("abc");
		assertEquals("http://www.shopping.com/products?KW=abc", urlProvider.getUrl());
	}
	@Test
	public void test() {
		UrlProvider urlProvider = new UrlProvider("abc", 1);
		assertEquals("http://www.shopping.com/products~PG-1?KW=abc", urlProvider.getUrl());
	}

}

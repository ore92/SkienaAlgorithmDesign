package skienna.ch02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test for {@link StringMatcher.class}
 * 
 * @author ore
 *
 */
public class StringMatcherTest {

	@Test
	public void test() {
		String str = "The quick brown fox jumped over the lazy dog";
		String pattern = "azy";
		assertEquals(37, StringMatcher.match(str, pattern));
	}
}

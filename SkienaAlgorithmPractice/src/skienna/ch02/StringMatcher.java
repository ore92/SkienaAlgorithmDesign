package skienna.ch02;

/**
 * 
 * Brute Force algorithm for pattern matching.
 * 
 * @author ore
 *
 */
public class StringMatcher {
	
	public static int match(String str, String pattern) {
		for(int i=0; i <= str.length()-pattern.length(); i++) {
			int j = 0;
			
			while(j < pattern.length() && str.charAt(i+j) == pattern.charAt(j)) {
				j = j + 1;
			}
			
			if (j == pattern.length()) {
				return i;
			}
		}
		return -1;
	}
}

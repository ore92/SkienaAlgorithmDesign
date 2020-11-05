package skienna.ch01;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

/**
 * Insertion Sort implementation Test, Skiena page 1.
 * 
 * @author ore
 *
 */
public class InsertionSortTest {
	
	InsertionSort<Character> sorter = new InsertionSort<>();
	
	@Test
	public void test1() {
		String testWord = "insertionsort";
		
		Character[] str = testWord.chars().mapToObj(ch -> (char)ch).toArray(Character[]::new);
		sorter.sort(str, (a,b) -> Character.compare(a, b));
		
		char[] testWordAsChars = testWord.toCharArray();
		Arrays.sort(testWordAsChars);
		
		String tstSolution = new String(testWordAsChars);
	    String implSolution = new String(ArrayUtils.toPrimitive(str));	
		assertEquals("the sorted strings are not equivalent",tstSolution, implSolution);
	}

}

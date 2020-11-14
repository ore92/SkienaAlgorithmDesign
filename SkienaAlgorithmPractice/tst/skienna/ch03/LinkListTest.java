package skienna.ch03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/**
 * Test for {@link LinkList.class}
 * 
 * @author ore
 *
 */
public class LinkListTest {
	
	@Test
	public void testAdd() {
		LinkList<Integer> arr = new LinkList<>();
		for(int i=0; i<7; i++) {
			arr.add(i);
		}
		
		assertEquals(6, arr.get(6));
		assertEquals(7, arr.size());
	}
	
	@Test
	public void testRemove() {
		LinkList<Integer> arr = new LinkList<>();
		for(int i=0; i<7; i++) {
			arr.add(i);
		}
		
		arr.delete(3);		
		assertEquals(4, arr.get(3));
		assertEquals(6, arr.size());

		arr.delete(0);
		assertEquals(1, arr.get(0));
		assertEquals(5, arr.size());

		
		arr.delete(4);
		assertEquals(5, arr.get(3));
		assertEquals(4, arr.size());
		
		arr.delete();
		assertEquals(3, arr.size());
		
		arr.add(5);
		assertEquals(4, arr.size());
		assertEquals(5, arr.get(arr.size()-1));
	}	
}
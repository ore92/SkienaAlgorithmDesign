package skienna.ch03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/**
 * Test for {@link DynamicArray.class}
 * 
 * @author ore
 *
 */
public class DynamicArrayTest {

	@Test
	public void testArrayExpansion() {
		DynamicArray<Integer> arr = new DynamicArray<>(5);
		for(int i=0; i<7; i++) {
			arr.add(i);
		}
		
		assertEquals(6, arr.get(6));
		assertEquals(7, arr.size());
	}
	
	@Test
	public void testRemoveAtIndex() {
		DynamicArray<Integer> arr = new DynamicArray<>(5);
		for(int i=0; i<7; i++) {
			arr.add(i);
		}
		
		arr.delete(3);
		assertEquals(4, arr.get(3));
		assertEquals(6, arr.size());
	}
	
	@Test
	public void testRemove() {
		DynamicArray<Integer> arr = new DynamicArray<>(5);
		for(int i=0; i<7; i++) {
			arr.add(i);
		}
		arr.delete();
		
		arr.set(2, 45);
		
		assertEquals(45, arr.get(2));
		assertEquals(6, arr.size());
		assertEquals(5, arr.get(5));
	}
}

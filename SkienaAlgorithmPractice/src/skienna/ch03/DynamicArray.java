package skienna.ch03;

/**
 * A dynamic array backed collection, expanding as needed.
 * 
 * @author ore
 *
 * @param <T> array type
 */
public class DynamicArray<T> {
	private T[] arr;
	private int current;
	private int capacity;
	private static int DEFAULT_CAPACITY = 5;
	
	public DynamicArray(int n) {
		if (n < 1) n = DEFAULT_CAPACITY;
		arr = (T[]) new Object[n];
		current = 0;
		capacity = n;
	}
	
	public DynamicArray() {
		this(5);
	}
	
	public void add(T in) {
		if(current == capacity) {
			expandArray();
		}
		arr[current] = in;
		current++;
	}
	
	public void add(int index, T in) {
		if (index > capacity || index < 0) {
			throw new IndexOutOfBoundsException(index);
		}
		if (index == capacity) {
			add(in);
		} else {
			arr[index] = in;
		}	
	}
	
	public void delete() {
		current--;
	}
	
	public void delete(int index) {
		if(index < current && index > -1) {
			for(int j=index+1; j < current;j++) {
				arr[j-1] = arr[j];
			}
			current--;
		}
	}
	
	public T get(int index) {
		if(index >= current || index < 0) {
			throw new IndexOutOfBoundsException(index);
		}
		return arr[index];
	}
	
	private void expandArray() {
		capacity = 2*capacity;
		T[] temp = (T[]) new Object[capacity];
		for(int i=0; i<arr.length;i++) {
			temp[i] =  arr[i];
		}
		arr = temp;
	}
}

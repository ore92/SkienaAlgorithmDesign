package skienna.ch01;

import java.util.Comparator;

/**
 * Insertion Sort implementation, Skiena page 1.
 * 
 * @author ore
 *
 * @param <T> - The array type to be sorted
 */
public class InsertionSort<T> {

	public void sort(T[] arr, Comparator<T> comparator) {
		for (int i = 1; i < arr.length; i++) {
			int cur = i;
			while (cur-1 >= 0 && comparator.compare(arr[cur], arr[cur-1]) < 0) {
				swap(arr, cur, cur-1);
				cur--;
			}
		}
	}

	private void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

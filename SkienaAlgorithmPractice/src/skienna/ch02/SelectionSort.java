package skienna.ch02;

import java.util.Comparator;

/**
 * Implementation of the selection sort algorithm
 * 
 * @author ore
 *
 * @param <T> array type
 */
public class SelectionSort<T> {
	
	public void sort(T[] arr, Comparator<T> comparator) {
		for(int i=0; i < arr.length-1; i++) {
			int minIndx = i;
			for (int j=i+1 ; j < arr.length ; j++) {
				if (comparator.compare(arr[j], arr[minIndx]) < 0) {
					minIndx = j;
				}
			}
			swap(arr,i,minIndx);
		}
	}
	
	public void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

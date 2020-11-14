package skienna.ch03;

/**
 * A singly-linked data structure.
 * 
 * @author ore
 *
 * @param <T> type to store
 */
public class LinkList<T> {
	Node<T> root;
	Node<T> current;
	int size = 0;
	
	/**
	 * Adds in to the end of the list
	 * 
	 * @param in
	 */
	public void add(T in) {
		Node<T> cur = new Node<>(in);
		if(root == null) {
			root = cur;
		}else {
			current.next = cur;
		}
		current = cur;
		size++;
	}
	
	/**
	 * Sets object at index to in
	 * 
	 * @param index
	 * @param in
	 */
	public void set(int index,T in) {
		Node<T> cur = root;
		for(int i=0; i < index; i++) {
			cur = cur.next;
		}
		cur.data = in;
	}
	
	/**
	 * Deletes the last object
	 */
	public void delete() {
		if (size < 2) {
			root = null;
			current = null;
			size--;
		}else {
			Node<T> cur = getNode(size-2);
			cur.next = null;
			current = cur;
			size--;
		}
	}
	
	/**
	 * Deletes object at index
	 * 
	 * @param index
	 */
	public void delete(int index) {
		if(index == 0) {
			root = root.next;
			if (size == 1) {
				current = root;
			}
			size--;
		} else if(index == size-1) {
			delete();
		} else {
			Node<T> before = getNode(index-1);
			Node<T> after = getNode(index+1);
			before.next = after;
			size--;
		}
	}
	
	/**
	 * Returns T at index
	 * @param index
	 * @return T at index
	 */
	public T get(int index) {
		return getNode(index).data;
	}
	
	@Override
	public String toString() {
		Node<T> cur = root;
		String ret = "[";
		while(cur != null) {
			ret += " " + cur.data;
			cur = cur.next;
		}
		ret += " ]";
		return ret;
	}
	
	private Node<T> getNode(int index) {
		if(index == 0) {
			return root;
		} else {
			Node<T> cur = root;
			for (int i=1; i <= index; i++) {
				cur = cur.next;
			}
			return cur;
		}
	}
	
	/**
	 * the size of the list
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}
	
	private static class Node<T>{
		T data;
		Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return data.toString();
		}
	}
}

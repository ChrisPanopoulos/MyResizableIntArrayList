
/**
 * Class MyResisableIntArrayList is similar to the ArrayList class 
 * of the standard library. Minor differences 
 * include: 
 * a) the class stores integers (int) instead of Objects, 
 * b) the method "add(int index, Object elem)" returns void, 
 * c) the method "remove(int index)" returns void. 
 * The capacity is doubled when the array becomes full. 
 * The capacity is halfed when the size of the structure becomes 
 * less than or equal to the 1/4th of the capacity.
 *
 * @author Christos Panopoulos
 * @version 2020
 */
public class MyResizableIntArrayList {	
	private int[] data;
	private int capacity;
	private int size;
	
	/**
	 * Constructs a resizable array-list of integers.
	 */
	public MyResizableIntArrayList() {
		data = new int[1];
		capacity = 1;
		size=0;
		
	}
	/**
	 * Constructs a resizable array-list of integers.
	 */
	public MyResizableIntArrayList(int initialCapacity) {
		capacity = initialCapacity;
		data = new int[initialCapacity];
		size=0;
		
	}
	/**
	 * When array is full during the procedure of adding elements this method doubles its capacity by copying its elements
	 * to a new array with double capacity.
	 */
	private void ArrayIsFull() {
		int[] copy = new int[2 * capacity];
		
		for(int i = 0; i < capacity; i++)
			copy[i] = data[i];
		data = copy;
		capacity = capacity*2;
			
	}
	/**
	 * When array's capacity becomes 4 times greater than the number of elements it contains, while removing elements then
	 * the array's capacity becomes half.(I use the same procedure as in the ArrayIsFull method by copying elements 
	 * to a new array).
	 */
	private void ArrayShrink() {
		if(size==4*capacity) {
			int array[]=new int[capacity/2];
			for(int i = 0; i< size; i++)
				array[i]=data[i];
			data = array;
			capacity=capacity/2;
		}
	}
	/**
	 * Appends the specified element to the end of this resizable array-list.
	 * The size of the resizable array-list is increased by one.
	 * @param elem - The element to be appended.
	 */
	public void add(int elem) {
		if (size == capacity)
			this.ArrayIsFull();
		
		data[size] = elem;
		size++;
	}
	/** 
	 * Inserts the specified element at the specified position in this resizable array-list. 
	 * Shifts the element currently at that position (if any) and any subsequent 
	 * elements to the right (adds one to their indices). The size of the resizable array-list is increased by one. 
	 * It assumes that index has an appropriate value, that is, (index >= 0 && size() >=index)

	 * 
	 * @param index - The index of the new element after it is inserted. It MUST hold that (index >= 0 && size() >=index).
	 * @param elem - The element to be inserted.
	 */
	public void add(int index, int elem) {
		
		if(size == capacity)
			this.ArrayIsFull();
		
		for(int j = size-1; j >= index; j--)
			data[j+1] = data[j];
		data[index] = elem;
		size++;
		}	
	/**
	 * Removes all the elements of the array-list and resets its capacity to 1.
	 */
	public void clear()  {
		data=new int[1];
		size=0;
		capacity=1;
	}
	/**
	 * Checks whether this array-list contains a specific element.
	 * @return "true" if this array-list contains the specified element, "false" otherwise.
	 * @param elem - The element in question
	 * 
	 */
	public boolean contains(int elem) {
		return indexOf(elem) >= 0;
		
	}
	/**
	 * Returns the element at the specified position in this array-list. 
	 * It assumes that index has an appropriate value, that is, (index >= 0 && size() > index).
	 * @param index - The array-list position in question. It MUST hold that (index >= 0 && size() > index).
	 * @return The element stored in the specified position.
	 */
	public int get(int index) {
		
		return data[index];
		
	}
	/**
	 * Searches for the first occurence of the given argument. 
	 * Returns the index of the first occurrence of the argument in this array-list; returns -1 if the object is not found.
	 * @param elem - The element searched for.
	 * @return The position of the specified element; -1 if not found.

	 */
	 public int indexOf(int elem) {
		for(int i= 0; i < size; i++) {
			if(elem==data[i])
				return i;
		
		}
		return -1;
		
		
	}
	/**
	 * Tests if this array-list is empty.
	 * @return "true" if this array-list has no elements; "false" otherwise.
	 */ 
	public boolean isEmpty() {
		return size == 0;
		
	}
	/**
	 * Removes the element at the specified position in this array-list. 
	 * Shifts any subsequent elements to the left (subtracts one from their indices). 
	 * It assumes that index has an appropriate value, that is, (index >= 0 && size() > index).
	 * @param index - The position of the element to be removed. It MUST hold that (index >= 0 && size() > index).

	 */
	 public void remove(int index) {
		this.ArrayShrink();
		for(int i = index; i< size-1; i++)
			data[i]=data[i+1];
		data[size-1]=0;
		size--;
		
	}
	/**
	 * Replaces the element at the specified position in this array-list with the specified element. 
	 * It assumes that index has an appropriate value, that is, (index >= 0 && size() >index)
	 * @param index - The index of the element to be replaced. It MUST hold that (index >= 0 && size() >index).
	 * @param elem - The new element.

	 */
	public void set(int index, int elem) {
		data[index] = elem;
		size++;
		
	}
	/**
	 * The size of this array-list.
	 * @return The number of element in the array-list
	 */
	 public int size() {
		
		return size;
		
	}
	
}

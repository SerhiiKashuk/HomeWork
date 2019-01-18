package academy.mate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyCollection<SoftDrink> implements List {

	public SoftDrink[] array;
	public int size = 0;

	public MyCollection() {
		array = (SoftDrink[]) new Object[3];
	}

	@Override
	public boolean add(Object e) {
		if (e == null)
			return false;
		if (size == array.length) {
			ensureCapacity();
		}
		array[size++] = (SoftDrink) e;
		return true;
	}

	public void sort() {
		Arrays.sort(array, new Comparator<SoftDrink>() {

			@Override
			public int compare(SoftDrink s1, SoftDrink s2) {
				// TODO Auto-generated method stub
				if ((((academy.mate.SoftDrink) s1).getName().equals(((academy.mate.SoftDrink) s2).getName())))
					return 0;
				if (((academy.mate.SoftDrink) s1).getName() == null)
					return 1;
				if (((academy.mate.SoftDrink) s2).getName() == null)
					return -1;
				return ((academy.mate.SoftDrink) s1).getName().compareTo(((academy.mate.SoftDrink) s2).getName());

			}
		});
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (array[0] == null) {
			return true;
		}
		return false;
	}

	private void ensureCapacity() {
		int newSize = array.length / 2 + array.length;
		array = Arrays.copyOf(array, newSize);
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<SoftDrink> iterator() {
		Iterator<SoftDrink> it = new Iterator<SoftDrink>() {
			int currIndex = 0;

			@Override
			public boolean hasNext() {
				return (currIndex < size && array[currIndex] != null);
			}

			@Override
			public SoftDrink next() {
				return array[currIndex++];
			}
		};

		return it;
	}

	@Override
	public Object get(int index) {
		if (array[index] == null) {
			return null;
		}
		return array[index];
	}
	
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}



	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object remove(int index) {
		Object e = null;
		if (index < 0 || index >= size) {
			return e;
		} else {
			e = array[index];
			int count = 0;
			for (int i = 0; i < array.length; i++) {
				if (i == index) {
					continue;
				}
				array[count] = array[i];
				count++;
			}
			size--;
			return e;
		}
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}

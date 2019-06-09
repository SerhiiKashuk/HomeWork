package hashmap;

import java.util.Arrays;

public class HashTable {
	private HashEntry[] hashArray;
	private int arraySize;
	int size;

	public HashTable(int size) {
		arraySize = size;
		hashArray = new HashEntry[arraySize];

	}

	public int hashCode(int key) {
		return key % arraySize;
	}

	public int doubleHashCode(int key) {
		return 5 - key % 5;
	}

	public void put(int key, long value) {
		int hashcode = hashCode(key);
		int stepSize = doubleHashCode(key);
		if (hashArray[hashcode] != null && hashArray[hashcode].getKey() == key) {
			hashArray[hashcode].setValue(value);
		} else {
			while (hashArray[hashcode] != null && hashArray[hashcode].getKey() != -1
			    && hashCode(hashArray[hashcode].getKey()) == hashcode) {
				hashcode += stepSize;
				hashcode %= arraySize;
			}
			hashArray[hashcode] = new HashEntry(key, value);
			size++;
			if (size > arraySize * 0.75) {
				ensureCapacity();
			}
		}
	}

	public int size() {
		return size;
	}

	public Long get(int key) {
		int hashVal = hashCode(key);
		int stepSize = doubleHashCode(key);
		while (hashArray[hashVal] != null) {
			if (hashArray[hashVal].getKey() == key)
				return hashArray[hashVal].getValue();
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		return null;
	}

	private void ensureCapacity() {
		int newSize = hashArray.length*2;
		hashArray = Arrays.copyOf(hashArray, newSize);
	}

}

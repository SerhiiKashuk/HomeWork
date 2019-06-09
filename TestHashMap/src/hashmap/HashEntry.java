package hashmap;

public class HashEntry {
	private int key;
	private long value;

	public HashEntry(int key, long value) {

		this.key = key;
		this.value = value;
	}

	public int getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

}

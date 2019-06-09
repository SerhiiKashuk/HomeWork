package hashmap;


public class Main {

	public static void main(String[] args) {
		HashTable tab = new HashTable(127);
		tab.put(1, 11111111111111111L);
		System.out.println(tab.size());
		tab.put(1, 22222222222222222L);
		tab.put(128, 888888888888888L);
		tab.put(2, 100000000000000L);
		System.out.println(tab.size());
		System.out.println(tab.get(1));
	}
}

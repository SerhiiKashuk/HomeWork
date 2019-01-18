package academy.mate;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCollection<SoftDrink> list = new MyCollection<SoftDrink>();
		list.add(new SoftDrink("cola", "black"));
		list.add(new SoftDrink("tea", "blue"));
		list.add(new SoftDrink("sprite", "green"));
		list.add(new SoftDrink("juice", "pink"));
		System.out.println("list size " + list.size());
		list.sort();
		System.out.println(list.remove(2));
		System.out.println("list size " + list.size());
		System.out.println(list.isEmpty());
		Iterator<SoftDrink>it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next()); 
			
		}


	}

}

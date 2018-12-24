package academy.mate;

import java.util.Scanner;

public class Initials {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] initials = in.nextLine().split(" ");
		String str = "";
		String surname = initials[0].substring(0, 1).toUpperCase() + initials[0].substring(1);
		for (int i = 1; i < initials.length; i++) {
			str += (initials[i].substring(0, 1).toUpperCase() + ". ");
		}
		System.out.println(surname + " " + str);
		in.close();
	}

}

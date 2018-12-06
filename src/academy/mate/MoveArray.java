package academy.mate;

import java.util.Scanner;

public class MoveArray {
	public static void main(String[] args) {
		char[] array = { '@', ',', ',', ',', ',', ',', ',', ',', ',', ',' };
		int i = 0;
		Scanner in = new Scanner(System.in);
		do {
		  char temp = in.nextLine().charAt(0);
			if (temp == 'd') {
			  if (i == array.length - 1) {
				break;
			  }
				char ch = array[i];
				array[i] = array[i + 1];
				array[i + 1] = ch;
				i++;
			} else if (temp == 'a') {
			  if (i == 0) {
				break;
			  }
				char ch = array[i];
				array[i] = array[i - 1];
				array[i - 1] = ch;
				i--;
			} else {
			  System.out.println("Error");
			}
			for (char c : array) {
			  System.out.print(c);
			}

		} while (true);
		in.close();	

	}

}

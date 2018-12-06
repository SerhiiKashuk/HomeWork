package academy.mate;

import java.util.Scanner;

public class MoveArray2 {
  public static void main(String[] args) {
	  char[][] array = { { '@', ',', ',', ',', ',', ',', ',', ',', ',', ',' },
				{ ',', ',', ',', ',', ',', ',', ',', ',', ',', ',' },
				{ ',', ',', ',', ',', ',', ',', ',', ',', ',', ',' },
				{ ',', ',', ',', ',', ',', ',', ',', ',', ',', ',' },
				{ ',', ',', ',', ',', ',', ',', ',', ',', ',', ',' },
				{ ',', ',', ',', ',', ',', ',', ',', ',', ',', ',' },
				{ ',', ',', ',', ',', ',', ',', ',', ',', ',', ',' },
				{ ',', ',', ',', ',', ',', ',', ',', ',', ',', ',' },
				{ ',', ',', ',', ',', ',', ',', ',', ',', ',', ',' },
				{ ',', ',', ',', ',', ',', ',', ',', ',', ',', ',' } };
		int i = 0;
		int j = 0;
		Scanner in = new Scanner(System.in);
		do {
		  char temp = in.nextLine().charAt(0);
			if (temp == 'd') {
			  if (j == array[i].length - 1) {
				break;
			  }
			  char ch = array[i][j];
			  array[i][j] = array[i][j + 1];
			  array[i][j + 1] = ch;
			  j++;
			} else if (temp == 'a') {
			  if (j == 0) {
				break;
			  }
			  char ch = array[i][j];
			  array[i][j] = array[i][j - 1];
			  array[i][j - 1] = ch;
			  j--;
			} else if (temp == 'w') {
			  if (i == 0) {
				break;
			  }
			  char ch = array[i][j];
			  array[i][j] = array[i - 1][j];
			  array[i - 1][j] = ch;
			  i--;
			} else if (temp == 's') {
			  if (i == array.length - 1) {
				break;
			  }
			  char ch = array[i][j];
			  array[i][j] = array[i + 1][j];
			  array[i + 1][j] = ch;
			  i++;
			} else {
				System.out.println("Error");
			}
			for (int k = 0; k < 10; k++) {
		      for (int f = 0; f < 10; f++) {
				System.out.print(array[k][f]);
			  }
				System.out.println();
			}
		} while (true);
		in.close();	
  }

}

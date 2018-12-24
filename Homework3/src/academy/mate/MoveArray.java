package academy.mate;

import java.util.Arrays;
import java.util.Scanner;

public class MoveArray {

	public static void main(String[] args) {
		char[][] array = new char[10][10];
		int i = 0;
		int j = 0;
		int health = 100;
		char[] tempA = { 'a', 'A' };
		char[] tempB = { 'b', 'B' };

		for (int k = 0; k < array.length; k++) {
			for (int z = 0; z < array[k].length; z++) {
				array[k][z] = ',';
			}
		}
		array[0][0] = '@';

		for (int k = 0; k < array.length; k++) {
			int rndA = (int) (Math.random() * (tempA.length));
			int rndB = (int) (Math.random() * (tempB.length));
			int tA = (int) (Math.random() * array.length - 1);
			if (array[k][tA] == ',') {
				array[k][tA] = tempA[rndA];
			} else {
				array[k][array.length - 1 - tA] = tempA[rndA];
			}

			int tB = (int) (Math.random() * array.length - 1);
			if (array[k][tB] == ',') {
				array[k][tB] = tempB[rndB];
			} else {
				array[k][array.length - 1 - tB] = tempB[rndB];
			}

		}

		Scanner in = new Scanner(System.in);
		L: do {
			char temp = in.nextLine().charAt(0);
			switch (temp) {
			case 'd':
				if (j == array[i].length - 1) {
					break;
				}
				char d = array[i][j];
				array[i][j] = array[i][j + 1];
				if (array[i][j] != ',') {
					switch (array[i][j]) {
					case 'a':
						health += 20;
						array[i][j] = ',';
						break;
					case 'A':
						health += 40;
						array[i][j] = ',';
						break;
					case 'b':
						health -= 20;
						array[i][j] = ',';
						break;
					case 'B':
						health -= 40;
						array[i][j] = ',';
						break;
					default:
						break;
					}
				} else {
					health -= 5;
				}
				array[i][j + 1] = d;
				j++;
				break;

			case 'a':
				if (j == 0) {
					break;
				}
				char a = array[i][j];
				array[i][j] = array[i][j - 1];
				if (array[i][j] != ',') {
					switch (array[i][j]) {
					case 'a':
						health += 20;
						array[i][j] = ',';
						break;
					case 'A':
						health += 40;
						array[i][j] = ',';
						break;
					case 'b':
						health -= 20;
						array[i][j] = ',';
						break;
					case 'B':
						health -= 40;
						array[i][j] = ',';
						break;
					default:
						break;
					}
				} else {
					health -= 5;
				}
				array[i][j - 1] = a;
				j--;
				break;

			case 'w':
				if (i == 0) {
					break;
				}
				char ch = array[i][j];
				array[i][j] = array[i - 1][j];
				if (array[i][j] != ',') {
					switch (array[i][j]) {
					case 'a':
						health += 20;
						array[i][j] = ',';
						break;
					case 'A':
						health += 40;
						array[i][j] = ',';
						break;
					case 'b':
						health -= 20;
						array[i][j] = ',';
						break;
					case 'B':
						health -= 40;
						array[i][j] = ',';
						break;
					default:
						break;
					}
				} else {
					health -= 5;
				}
				array[i - 1][j] = ch;
				i--;
				break;

			case 's':
				if (i == array.length - 1) {
					break;
				}
				char s = array[i][j];
				array[i][j] = array[i + 1][j];
				if (array[i][j] != ',') {
					switch (array[i][j]) {
					case 'a':
						health += 20;
						array[i][j] = ',';
						break;
					case 'A':
						health += 40;
						array[i][j] = ',';
						break;
					case 'b':
						health -= 20;
						array[i][j] = ',';
						break;
					case 'B':
						health -= 40;
						array[i][j] = ',';
						break;
					default:
						break;
					}
				} else {
					health -= 5;
				}
				array[i + 1][j] = s;
				i++;
				break;
			default:
				System.out.println("Error");
			}

			for (int k = 0; k < array.length; k++) {

				System.out.println(Arrays.toString(array[k]));
			}
			System.out.println("Health : " + health);
			if (health < 0) {
				System.out.println("You lose");
				break L;
			}
			 in.close();
		} while (true);

	}

}
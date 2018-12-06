package academy.mate;

import java.util.Arrays;

public class Month {
  public static void main(String[] args) {
	int temp = 31;
	int[] months = new int[12];
	for (int i = 0; i < months.length; i++) {
	  months[i] = temp;
		if (i <= 6) {
		  if (i % 2 == 1) {
			 months[i] = temp - 1;
			   if (i == 1) {
				 months[i] = temp - 3;
			   }
		  }
		} else {
			if (i % 2 != 1) {
			  months[i] = temp - 1;
			}
		}
	}
	System.out.println(Arrays.toString(months));
  }
}

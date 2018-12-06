package academy.mate;

public class Palindrome {
  public static void main(String[] args) {
	char[] palindrome = { 'q', 'w', 'e', 'r', 'e', 'w', 'q' };
	int len = palindrome.length;
	boolean flag = true;
	for (int i = 0; i < palindrome.length / 2; i++) {
	  if (palindrome[i] != palindrome[len - i - 1]) {
		flag = false;
		break;
	  } 
	}
		if (flag == true) {
		  System.out.println("Yes,it's palindrome");
		} else {
			System.out.println("No,it isn't palindrome");
		}

  }

}

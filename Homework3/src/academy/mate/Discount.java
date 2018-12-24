package academy.mate;

public class Discount {
	public static void main(String[] args) {
		int total = 360;
		int discount;
		int temp = total / 100;
		
		switch (temp) {
		case 0:
		case 1:
		case 2:
			discount = 0;
			break;
		case 3:
		case 4:
			discount = 3;
			break;
		default:
			discount = 5;
		}
		System.out.println("Discount total " + (total - total / 100 * discount));

	}
}
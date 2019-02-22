package academy.mate.goldenMine;

public class GoldMine {
	int amount = 1000;
	int b = 3;

	public GoldMine() {

	}

	public void getGold() {
		if (amount < b) {
			b = amount;
		}
		amount -= b;
		System.out.println("Balance golden mine " + amount + "\n");
	}
}

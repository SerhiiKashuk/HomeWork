package academy.mate.goldenMine;

public class Miner implements Runnable {
	GoldMine gm;
	public String name;
	public int gold;
	int balance = 3;

	public Miner(GoldMine gm, String name, int gold) {
		super();
		this.gm = gm;
		this.name = name;
		this.gold = gold;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (gm.amount > 0) {
			if (gm.amount < 3) {
				balance = gm.amount;
			}
			synchronized (gm) {
				gold += balance;
				System.out.println(name + "; gold = " + gold);
				gm.getGold();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

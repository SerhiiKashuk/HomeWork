package academy.mate.goldenMine;

public class Barrack implements Runnable {
	GoldMine gm;
	int i = 4;

	public Barrack(GoldMine gm) {
		this.gm = gm;
		new Thread(this).start();
	}

	@Override
	public void run() {
	
		try {
			while(gm.amount>0) {
				Thread.sleep(10000);
				new Miner(gm, "Miner_" + i, 0);
				i++;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

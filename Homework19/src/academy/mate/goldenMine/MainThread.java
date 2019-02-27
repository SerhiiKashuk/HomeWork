package academy.mate.goldenMine;


public class MainThread {

	public static void main(String[] args) {

		GoldMine gm = new GoldMine();
		new Miner(gm, "Miner_1", 0);
		new Miner(gm, "Miner_2", 0);
		new Miner(gm, "Miner_3", 0);
		new Barrack(gm).run();;
	}

}

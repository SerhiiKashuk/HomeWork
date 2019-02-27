package academy.mate;

public class Unloader implements Runnable {
	Truck truck;

	public Unloader(Truck truck) {
		super();
		this.truck = truck;
		new Thread(this).start();
	}

	@Override
	public void run() {
		Heap heap = truck.getHeap();
		while (heap.amount > 0) {
			truck.unloadTruck();

		}
	}

}

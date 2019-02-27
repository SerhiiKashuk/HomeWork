package academy.mate;

public class Loader implements Runnable {
	Truck truck;

	public Loader(Truck truck) {
		super();
		this.truck = truck;
		new Thread(this).start();
	}

	@Override
	public void run() {
		Heap heap = truck.getHeap();
		while (heap.amount > 0) {
			truck.loadTruck();
		}
	}
}

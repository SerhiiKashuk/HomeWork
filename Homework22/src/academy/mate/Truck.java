package academy.mate;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Truck {
	private int volume;
	Heap heap;
	private int count = 0;
	private int weightLoad = 3;
	private int weightUnload = 2;
	Semaphore load = new Semaphore(1);
	Semaphore trans = new Semaphore(0);
	Semaphore unload = new Semaphore(0);

	public Truck(Heap heap) {
		super();
		this.heap = heap;
	}

	void loadTruck() {
		try {
			load.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Start load");
		System.out.print("Load ");
		while (volume < 6) {
			if (heap.amount < weightLoad) {
				weightLoad = heap.amount;
			}
			heap.amount -= weightLoad;
			volume += weightLoad;
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.print(".");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (heap.amount == 0) {
				break;
			}
		}
		System.out.println('\n' + "Balance heap = " + heap.amount);
		System.out.println("Finish load" + '\n');
		trans.release();
	}

	void transferTruck() {
		try {
			trans.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		int i = 0;
		if (count % 2 == 0) {
			System.out.print("Transfer forward ");

			while (i < 5) {
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.print(".");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;
			}
			System.out.println('\n');
			unload.release();
			i = 0;
			count++;
		} else {
			System.out.print("Transfer back ");
			while (i < 5) {
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.print(".");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;
			}
			System.out.println('\n');
			load.release();
			i = 0;
			count++;
		}
	}

	void unloadTruck() {
		try {
			unload.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Start unload");
		System.out.print("Unload ");
		while (volume > 0) {
			if (weightUnload > volume) {
				weightUnload = volume;
			}
			volume -= weightUnload;
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.print(".");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println('\n' + "Finish unload" + '\n');
		trans.release();
	}

	public Heap getHeap() {
		return heap;
	}

	public void setHeap(Heap heap) {
		this.heap = heap;
	}
}

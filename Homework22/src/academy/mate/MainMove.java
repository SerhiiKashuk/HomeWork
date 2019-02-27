package academy.mate;

public class MainMove {

	public static void main(String[] args) throws InterruptedException {
		Heap heap = new Heap();
		Truck truck = new Truck(heap);
		new Loader(truck);
		new Transporter(truck);
		new Unloader(truck);

	}

}

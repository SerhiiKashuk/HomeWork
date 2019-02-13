package academy.mate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class WorkerFiles implements Serializable{
	public static void write(Pudge pudge) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pudge.bin"))/*oos = convector*/) {
			oos.writeObject(pudge);
			 oos.flush();
       oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
	}

	public static Pudge read() {
		Pudge pudge = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pudge.bin"))/*ois = convector*/) {
			try {
				pudge = (Pudge) ois.readObject();
        ois.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pudge;
	}
}

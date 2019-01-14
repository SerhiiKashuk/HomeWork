package academy.mate;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Main {

	public static void main(String[] args) {

		View window = new View();
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation((screensize.width - window.getWidth()) / 2, (screensize.height - window.getHeight()) / 2);

	}

}

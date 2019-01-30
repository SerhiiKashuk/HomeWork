package academy.mate.figure;

import java.awt.EventQueue;

import academy.mate.jdbc.ConfigController;
import academy.mate.jdbc.ConfigData;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	//	ConfigData cd = new ConfigData("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/tetris", "root", "");
	//	ConfigController.write(cd);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShapeFrame frame = new ShapeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

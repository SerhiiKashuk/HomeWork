package academy.mate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame {

	private JPanel checkersBoard;
	private JButton newGameButton = new JButton("NEW GAME");
	private JLabel label;
	public JLabel message;

	public View() {
		super("Checkers");
		setVisible(true);
		setSize(400, 400);
		setResizable(false);
		checkersBoard = startNewGame();
		add(checkersBoard);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private JPanel startNewGame() {
		checkersBoard = new StartCover();
		checkersBoard.setLayout(null);
		ImageIcon icon = new ImageIcon("checkers.png");
		label = new JLabel(icon);
		label.setBounds(20, 50, 350, 200);
		checkersBoard.add(label);
		newGameButton.setBounds(100, 300, 200, 50);
		checkersBoard.add(newGameButton);
		initListeners();
		return checkersBoard;
	}

	private void initListeners() {
		// TODO Auto-generated method stub
		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				checkersBoard.setVisible(false);
				newGameButton.setVisible(false);
				label.setVisible(false);
				checkersBoard = addCheckersBoard();
				Object src = e.getSource();
				if (src == newGameButton) {
					((CheckersBoard) checkersBoard).doNewGame();
				}
				checkersBoard.setVisible(true);
				// add(checkersBoard);

			}
		});
	}

	private JPanel addCheckersBoard() {
		checkersBoard = new CheckersBoard();
		checkersBoard.setBounds(0, 0, 500, 500);
		add(checkersBoard);

		// message.setBounds(0, 200, 350, 30);
		return checkersBoard;
	}

}

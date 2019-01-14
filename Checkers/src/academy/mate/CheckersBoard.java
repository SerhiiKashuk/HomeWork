package academy.mate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CheckersBoard extends JPanel implements MouseListener {
	private Checkers board;
	boolean gameInProgress;
	int currentPlayer;
	int selectedRow, selectedCol;
	Move[] legalMoves;

	public CheckersBoard() {
		setLayout(null);
		setPreferredSize(new Dimension(500, 500));
		setBackground(Color.BLACK);
		addMouseListener(this);
		board = new Checkers();
		legalMoves = board.getLegalMoves(board.YELLOW);
	}

	void doNewGame() {
		board.setUpGame();
		currentPlayer = Checkers.YELLOW; // YELLOW moves first.
		legalMoves = board.getLegalMoves(Checkers.YELLOW);
		selectedRow = -1;
		gameInProgress = true;
		repaint();
	}

	void doClickSquare(int row, int col) {

		for (int i = 0; i < legalMoves.length; i++)
			if (legalMoves[i].currentY == row && legalMoves[i].currentX == col) {
				selectedRow = row;
				selectedCol = col;
				repaint();
			}

		for (int i = 0; i < legalMoves.length; i++) {
			if (legalMoves[i].currentY == selectedRow && legalMoves[i].currentX == selectedCol && legalMoves[i].nextX == row
			    && legalMoves[i].nextY == col) {
				doMakeMove(legalMoves[i]);
				return;
			}
		}
	}

	void doMakeMove(Move move) {
		board.makeMove(move);
		if (move.isJump()) {
			legalMoves = board.getLegalJumpsFrom(currentPlayer, move.nextX, move.nextY);
			if (legalMoves != null) {
				selectedRow = move.nextX;
				selectedCol = move.nextY;
				repaint();
			}
		}
		if (currentPlayer == Checkers.YELLOW) {
			currentPlayer = Checkers.BLUE;
			legalMoves = board.getLegalMoves(currentPlayer);
		} else {
			currentPlayer = Checkers.YELLOW;
			legalMoves = board.getLegalMoves(currentPlayer);
		}
		selectedRow = -1;

		if (legalMoves != null) {
			boolean sameStartSquare = true;
			for (int i = 1; i < legalMoves.length; i++)
				if (legalMoves[i].currentY != legalMoves[0].currentY || legalMoves[i].currentX != legalMoves[0].currentX) {
					sameStartSquare = false;
					break;
				}
			if (sameStartSquare) {
				selectedRow = legalMoves[0].currentY;
				selectedCol = legalMoves[0].currentX;
			}
		}
		repaint();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
		g.drawRect(1, 1, getSize().width - 3, getSize().height - 3);
		int w = getSize().width / 8;
		int h = getSize().height / 8;
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (row % 2 == col % 2) {
					g.setColor(Color.DARK_GRAY);
				} else {
					g.setColor(Color.WHITE);
				}
				g.fillRect(2 + col * w, 2 + row * h, getSize().width, getSize().height);
				switch (board.pieceAt(row, col)) {
				case Checkers.YELLOW:
					g.setColor(Color.YELLOW);
					g.fillOval(3 + col * w, 3 + row * h, getSize().width / 8 - 3, getSize().height / 8 - 3);
					break;
				case Checkers.BLUE:
					g.setColor(Color.BLUE);
					g.fillOval(3 + col * w, 3 + row * h, getSize().width / 8 - 3, getSize().height / 8 - 3);
					break;
				case Checkers.YELLOW_KING:
					g.setColor(Color.MAGENTA);
					g.fillOval(3 + col * w, 3 + row * h, getSize().width / 8 - 3, getSize().height / 8 - 3);
					break;
				case Checkers.BLUE_KING:
					g.setColor(Color.CYAN);
					g.fillOval(3 + col * w, 3 + row * h, getSize().width / 8 - 3, getSize().height / 8 - 3);
					break;
				}
			}
		}
		if (selectedRow >= 0) {
			g.setColor(Color.ORANGE);
			g.drawRect(1 + selectedCol * w, 1 + selectedRow * h, w - 1, h - 1);
			g.drawRect(2 + selectedCol * w, 2 + selectedRow * h, w - 2, h - 2);
			g.setColor(Color.GREEN);
			for (int i = 0; i < legalMoves.length; i++) {
				if (legalMoves[i].nextY == selectedCol && legalMoves[i].currentY == selectedRow) {
					g.drawRect(2 + legalMoves[i].currentX * w, 2 + legalMoves[i].nextX * h, w - 1, h - 1);
					g.drawRect(3 + legalMoves[i].currentX * w, 3 + legalMoves[i].nextX * h, w - 3, h - 3);
				}
			}
		}
		if (legalMoves == null) {
			if (currentPlayer == Checkers.BLUE) {
				g.drawImage(new ImageIcon("Yellow.png").getImage(), 18, 50, this);
			} else {
				g.drawImage(new ImageIcon("Blue.png").getImage(), 18, 50, this);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		int y = (e.getX() - 2) / (getWidth() / 8);
		int x = (e.getY() - 2) / (getHeight() / 8);
		System.out.println("y = " + y + " x = " + x);
		if (y >= 0 && y < 8 && x >= 0 && x < 8)
			doClickSquare(x, y);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

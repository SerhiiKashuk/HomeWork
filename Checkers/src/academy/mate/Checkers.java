package academy.mate;

import java.util.Arrays;

public class Checkers {

	static final int EMPTY = 0;
	static final int YELLOW = 1;
	static final int YELLOW_KING = 2;
	static final int BLUE = 3;
	static final int BLUE_KING = 4;
	int[][] board;

	Checkers() {
		board = new int[8][8];
		setUpGame();
	}

	void setUpGame() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (row % 2 == col % 2) {
					if (row < 3)
						board[row][col] = BLUE;
					else if (row > 4)
						board[row][col] = YELLOW;
					else
						board[row][col] = EMPTY;
				} else {
					board[row][col] = EMPTY;
				}
			}
		}
	}

	int pieceAt(int row, int col) {
		return board[row][col];
	}

	void makeMove(Move move) {
		makeMove(move.currentY, move.currentX, move.nextX, move.nextY);
	}

	void makeMove(int fromRow, int fromCol, int toRow, int toCol) {
		board[toRow][toCol] = board[fromRow][fromCol];
		board[fromRow][fromCol] = EMPTY;
		if (fromRow - toRow == 2 || fromRow - toRow == -2) {
			int jumpRow = (fromRow + toRow) / 2;
			int jumpCol = (fromCol + toCol) / 2;
			board[jumpRow][jumpCol] = EMPTY;
		}
		if (toRow == 0 && board[toRow][toCol] == YELLOW) {
			board[toRow][toCol] = YELLOW_KING;
		}
		if (toRow == 7 && board[toRow][toCol] == BLUE) {
			board[toRow][toCol] = BLUE_KING;
		}
	}

	Move[] getLegalMoves(int player) {

		if (player != YELLOW && player != BLUE) {
			return null;
		}
		int playerKing;
		if (player == YELLOW) {
			playerKing = YELLOW_KING;
		} else {
			playerKing = BLUE_KING;
		}

		Move[] moves = new Move[30];

		int i = 0;

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (board[row][col] == player || board[row][col] == playerKing) {
					if (canJumping(player, row, col, row + 1, col + 1, row + 2, col + 2)) {
						moves[i] = new Move(row, col, row + 2, col + 2);
						i++;
					}
					if (canJumping(player, row, col, row - 1, col + 1, row - 2, col + 2)) {
						moves[i] = new Move(row, col, row - 2, col + 2);
						i++;
					}

					if (canJumping(player, row, col, row + 1, col - 1, row + 2, col - 2)) {
						moves[i] = new Move(row, col, row + 2, col - 2);
						i++;
					}
					if (canJumping(player, row, col, row - 1, col - 1, row - 2, col - 2)) {
						moves[i] = new Move(row, col, row - 2, col - 2);
						i++;
					}
				}
			}
		}

		if (moves[0] == null) {

			for (int row = 0; row < 8; row++) {
				for (int col = 0; col < 8; col++) {
					if (board[row][col] == player || board[row][col] == playerKing) {
						if (canMove(player, row, col, row + 1, col + 1)) {
							moves[i] = new Move(row, col, row + 1, col + 1);
							i++;
						}
						if (canMove(player, row, col, row - 1, col + 1)) {
							moves[i] = new Move(row, col, row - 1, col + 1);
							i++;
						}

						if (canMove(player, row, col, row + 1, col - 1)) {
							moves[i] = new Move(row, col, row + 1, col - 1);
							i++;
						}
						if (canMove(player, row, col, row - 1, col - 1)) {
							moves[i] = new Move(row, col, row - 1, col - 1);
							i++;
						}
					}
				}
			}
		}

		if (moves[0] == null) {
			return null;
		} else {
			moves = Arrays.copyOf(moves, i);
			return moves;
		}
	}

	Move[] getLegalJumpsFrom(int player, int row, int col) {
		if (player != YELLOW && player != BLUE) {
			return null;
		}
		int playerKing;
		if (player == YELLOW) {
			playerKing = YELLOW_KING;
		} else {
			playerKing = BLUE_KING;
		}

		Move[] moves = new Move[30]; // The legal jumps will be stored in this
		int i = 0;
		if (board[row][col] == player || board[row][col] == playerKing) {
			if (canJumping(player, row, col, row + 1, col + 1, row + 2, col + 2)) {
				moves[i] = new Move(row, col, row + 2, col + 2);
				i++;
			}
			if (canJumping(player, row, col, row - 1, col + 1, row - 2, col + 2)) {
				moves[i] = new Move(row, col, row - 2, col + 2);
				i++;
			}
			if (canJumping(player, row, col, row + 1, col - 1, row + 2, col - 2)) {
				moves[i] = (new Move(row, col, row + 2, col - 2));
				i++;
			}
			if (canJumping(player, row, col, row - 1, col - 1, row - 2, col - 2)) {
				moves[i] = new Move(row, col, row - 2, col - 2);
				i++;
			}
		}

		if (moves[0] == null) {
			return null;
		} else {
			// moves = Arrays.copyOf(moves, i);
			return moves;
		}
	}

	private boolean canJumping(int player, int r1, int c1, int r2, int c2, int r3, int c3) {
		if (r3 < 0 || r3 >= 8 || c3 < 0 || c3 >= 8) {
			return false;
		}
		if (board[r3][c3] != EMPTY) {
			return false;
		}
		if (player == YELLOW) {
			if (board[r1][c1] == YELLOW && r3 > r1)
				return false; // Regular yellow piece can only move up.
			if (board[r2][c2] != BLUE && board[r2][c2] != BLUE_KING)
				return false;
			return true; // The jump is legal.
		} else {
			if (board[r1][c1] == BLUE && r3 < r1)
				return false; // Regular blue piece can only move down.
			if (board[r2][c2] != YELLOW && board[r2][c2] != YELLOW_KING)
				return false;
			return true; // The jump is legal.
		}
	}

	private boolean canMove(int player, int r1, int c1, int r2, int c2) {
		if (r2 < 0 || r2 >= 8 || c2 < 0 || c2 >= 8) {
			return false;
		}

		if (board[r2][c2] != EMPTY) {
			return false;
		}
		if (player == YELLOW) {
			if (board[r1][c1] == YELLOW && r2 > r1) {
				return false;
			} else {
				return true;
			}
		} else {
			if (board[r1][c1] == BLUE && r2 < r1) {
				return false;
			} else {
				return true;
			}
		}
	}
}

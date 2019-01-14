package academy.mate;

public class Move {
	int currentX;
	int currentY;
	int nextX;
	int nextY;

	Move(int currentY, int currentX, int nextX, int nextY) {
		this.currentY = currentY;
		this.currentX = currentX;
		this.nextX = nextX;
		this.nextY = nextY;
	}

	boolean isJump() {
		return (currentY - nextX == 2 || currentY - nextX == -2);
	}
}

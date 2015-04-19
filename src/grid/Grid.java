package grid;

public class Grid {
	private final boolean[][] grid;
	private final int size;

	public Grid(int size) {
		this.size = size;
		grid = new boolean[size][size];
	}

	public boolean isAlive(int x, int y) {
		return grid[x][y];
	}

	public boolean outOfBounds(int x, int y) {
		return outOfBounds(x) || outOfBounds(y);
	}

	public boolean outOfBounds(int m) {
		return m < 0 || m >= size;
	}

	public int numNeighbours(final int x, final int y) {
		int numNeighbours = 0;

		for (int dx = -1; dx <= 1; ++dx) {
			int currentX = x + dx;
			if (outOfBounds(currentX)) continue;
			else {
				for (int dy = -1; dy <= 1; ++dy) {
					int currentY = y + dy;
					if (outOfBounds(currentY)) continue;
					else if (isAlive(currentX, currentY)) ++numNeighbours;
				}
			}
		}

		return numNeighbours;
	}
}

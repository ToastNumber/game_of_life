package grid;

public class Grid implements IGrid {
	private final boolean[][] grid;
	private final int size;

	public Grid(int size) {
		this.size = size;
		grid = new boolean[size][size];
		resetGrid();
	}

	@Override
	public void resetGrid() {
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				grid[i][j] = false;
			}
		}
	}

	@Override
	public boolean isAlive(int x, int y) {
		return grid[x][y];
	}

	@Override
	public boolean outOfBounds(int x, int y) {
		return outOfBounds(x) || outOfBounds(y);
	}

	@Override
	public boolean outOfBounds(int m) {
		return m < 0 || m >= size;
	}

	@Override
	public int numNeighbours(final int x, final int y) {
		int numNeighbours = 0;

		for (int dx = -1; dx <= 1; ++dx) {
			int currentX = x + dx;
			if (outOfBounds(currentX)) continue;
			else {
				for (int dy = -1; dy <= 1; ++dy) {
					if (dx == 0 && dy == 0) continue;

					int currentY = y + dy;
					if (outOfBounds(currentY)) continue;
					else if (isAlive(currentX, currentY)) ++numNeighbours;
				}
			}
		}

		return numNeighbours;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void setState(int x, int y, boolean alive) {
		grid[x][y] = alive;
	}

	
	@Override
	public boolean isEmpty() {
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				if (grid[i][j]) return false;
			}
		}
		
		return true;
	}
}

package grid.model;

import grid.Grid;
import grid.IGrid;

public class GridModel implements IGrid {
	private final Grid grid;

	public GridModel(Grid grid) {
		this.grid = grid;
	}

	@Override
	public void resetGrid() {
		grid.resetGrid();
	}

	@Override
	public boolean isAlive(int x, int y) {
		return grid.isAlive(x, y);
	}

	@Override
	public boolean outOfBounds(int x, int y) {
		return grid.outOfBounds(x, y);
	}

	@Override
	public boolean outOfBounds(int m) {
		return grid.outOfBounds(m);
	}

	@Override
	public int numNeighbours(int x, int y) {
		return grid.numNeighbours(x, y);
	}

	@Override
	public int size() {
		return grid.size();
	}

	@Override
	public void setState(int x, int y, boolean alive) {
		grid.setState(x, y, alive);
	}
	
	@Override
	public boolean isEmpty() {
		return grid.isEmpty();
	}
}

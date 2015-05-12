package grid.utils;

import grid.model.GridModel;

import java.util.Observable;

public class GridController extends Observable implements Runnable {
	private final GridModel gridModel;
	private int rate;
	private boolean running;

	public GridController(GridModel grid, int rate) {
		this.gridModel = grid;
		this.rate = rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public void run() {
		do {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			while (running && !gridModel.isEmpty()) {
				try {
					Thread.sleep(rate);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				tick();
			}
		} while (true);
	}

	private void tick() {
		final int size = gridModel.size();
		final boolean[][] newGrid = new boolean[size][size];

		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				int numNeighbours = gridModel.numNeighbours(i, j);

				if (gridModel.isAlive(i, j)) {
					if (numNeighbours < 2) newGrid[i][j] = false;
					else if (numNeighbours == 2 || numNeighbours == 3) newGrid[i][j] = true;
					else newGrid[i][j] = false;
				} else {
					if (numNeighbours == 3) newGrid[i][j] = true;
				}
			}
		}

		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				gridModel.setState(i, j, newGrid[i][j]);
			}
		}

		setChanged();
		notifyObservers();
	}

	public void update() {
		setChanged();
		notifyObservers();
	}
}

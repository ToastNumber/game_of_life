package grid.utils;

import grid.model.GridModel;

import java.util.Random;

public class GridGenerator {
	public static void populate(GridModel gridModel, double r) {
		gridModel.resetGrid();
		int size = gridModel.size();
		Random rand = new Random();
		int num = (int) (r * size * size);
		
		for (int i = 0; i < num; ++i) {
			gridModel.setState(rand.nextInt(size), rand.nextInt(size), true);
		}
	}
}

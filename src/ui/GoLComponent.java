package ui;

import graphics.drawing.GridView;
import grid.Grid;
import grid.model.GridModel;
import grid.utils.GridController;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class GoLComponent extends JPanel {
	public GoLComponent(Grid grid, double popRatio, int rate) {
		GridModel gridModel = new GridModel(grid);
		
		GridController gridController = new GridController(gridModel, rate);
		GridView gridView = new GridView(gridModel);
		
		gridController.addObserver(gridView);

		ControlPanel controlPanel = new ControlPanel(gridController, gridModel);
		
		setLayout(new BorderLayout());
		add(gridView, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.SOUTH);
	}
}

package ui;

import grid.model.GridModel;
import grid.utils.GridController;
import grid.utils.GridGenerator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ControlPanel extends JPanel {
	private final GridController gridController;
	private final GridModel gridModel;

	public ControlPanel(GridController gridController, GridModel gridModel) {
		this.gridController = gridController;
		this.gridModel = gridModel;
		init();
	}

	private void init() {
		Thread thread = new Thread(gridController);

		JButton btnStart = new JButton("Start");
		btnStart.setFocusable(false);
		btnStart.addActionListener(e -> {
			if (!thread.isAlive()) thread.start();
			gridController.setRunning(true);
		});

		JButton btnStop = new JButton("Stop");
		btnStop.setFocusable(false);
		btnStop.addActionListener(e -> {
			gridController.setRunning(false);
		});

		JButton btnReset = new JButton("Reset");
		btnReset.setFocusable(false);
		btnReset.addActionListener(e -> {
			gridModel.resetGrid();
			gridController.update();
			gridController.setRunning(false);
		});

		JLabel lblRate = new JLabel("Rate (ms)");
		JSlider sldrRate = new JSlider(50, 1000, 150);
		sldrRate.setFocusable(false);
		sldrRate.setPaintTicks(true);
		sldrRate.setPaintLabels(true);
		sldrRate.setMajorTickSpacing(200);
		sldrRate.addChangeListener(e -> gridController.setRate(sldrRate.getValue()));

		JLabel lblPopRatio = new JLabel("Random Population Ratio (%)");
		JSlider sldrPopRatio = new JSlider(10, 90, 20);
		sldrPopRatio.setFocusable(false);
		sldrPopRatio.setPaintTicks(true);
		sldrPopRatio.setPaintLabels(true);
		sldrPopRatio.setMajorTickSpacing(20);

		JButton btnRandom = new JButton("Random");
		btnRandom.setFocusable(false);
		btnRandom.addActionListener(e -> {
			GridGenerator.populate(gridModel, sldrPopRatio.getValue() / 100.0);
			gridController.update();
			gridController.setRunning(false);
		});

		add(btnStart);
		add(btnStop);
		add(btnReset);
		add(btnRandom);
		add(lblRate);
		add(sldrRate);
		add(lblPopRatio);
		add(sldrPopRatio);
	}

}

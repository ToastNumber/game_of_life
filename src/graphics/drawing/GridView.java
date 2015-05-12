package graphics.drawing;

import grid.model.GridModel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class GridView extends JPanel implements Observer, MouseListener {
	private final GridModel gridModel;
	private final int CELL_COUNT;

	public GridView(GridModel gridModel) {
		this.gridModel = gridModel;
		this.CELL_COUNT = gridModel.size();
		addMouseListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		int width = getWidth();
		int height = getHeight();
		g2.clearRect(0, 0, width, height);

		int cellSize = (int) Math.min(width, height) / CELL_COUNT;

		for (int x = 0; x < CELL_COUNT; ++x) {
			int xPos = x * cellSize;
			for (int y = 0; y < CELL_COUNT; ++y) {
				g2.setColor(Color.BLACK);

				int yPos = y * cellSize;
				g2.drawRect(xPos, yPos, cellSize, cellSize);

				if (gridModel.isAlive(x, y)) g2.fillRect(xPos, yPos, cellSize, cellSize);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		int width = getWidth();
		int height = getHeight();
		int gridWidth = (int) Math.min(width, height);

		int gridX = (int) ((double) x / gridWidth * CELL_COUNT) + 1;
		int gridY = (int) ((double) y / gridWidth * CELL_COUNT) + 1;

		gridModel.setState(gridX, gridY, !gridModel.isAlive(gridX, gridY));
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}

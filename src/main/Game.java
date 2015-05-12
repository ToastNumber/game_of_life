package main;

import grid.Grid;

import java.awt.Dimension;

import javax.swing.JFrame;

import ui.GoLComponent;

public class Game {
	
	public static void main(String[] args) throws InterruptedException {
		final int size = 40;
		Grid grid = new Grid(size);
		
		GoLComponent comp = new GoLComponent(grid, 0.2, 100);
		
		JFrame frame = new JFrame("Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(1000, 828));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.add(comp);
		
		frame.setVisible(true);
	}
}

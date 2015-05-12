package grid;

public interface IGrid {
	public void resetGrid();

	public boolean isAlive(int x, int y);

	public boolean isEmpty();
	
	public boolean outOfBounds(int x, int y);

	public boolean outOfBounds(int m);

	public int numNeighbours(final int x, final int y);

	public int size();
	
	public void setState(int x, int y, boolean alive);
}

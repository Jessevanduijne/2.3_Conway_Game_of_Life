import java.util.Observable;
import java.util.Random;

public class LifeModel extends Observable {

	private boolean[][] grid;
	private final int rows = 30;
	private final int columns = 20;

	// Getters
	// Right-click --> Source --> Generate Getters and Setters
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public LifeModel() { // Vul grid met levende cellen
		grid = new boolean[rows][columns];
		Random rnd = new Random();

		for (int r = 1; r < rows - 1; r++) { // Sla eerste en laatste r & k over: dode cellen
			for (int k = 1; k < columns - 1; k++) {
				grid[r][k] = (rnd.nextInt(10) % 5 == 0); // 20% kans op leven
			}
		}
	}

	public boolean isLevend(int r, int k) {
		return grid[r][k];
	}

	public int getCount() { // Hoeveel levende cellen zijn er nog
		int count = 0;
		for (int r = 0; r < rows; r++) {
			for (int k = 0; k < columns; k++) {
				if (isLevend(r, k)) {
					count++;
				}
			}
		}
		return count;
	}

	// public void toon() { ... } ---------> LifeConsoleView

	private int telBuren(int row, int column) {

		int buren = 0;

		for (int r = -1; r <= 1; r++) {
			for (int k = -1; k <= 1; k++) {
				if ((r == 0) && (k == 0))
					continue; // Sla geselecteerde cel over

				int r2 = row + r;
				int k2 = column + k;

				if ((r2 < 0) || (k2 < 0) || (r2 >= 30) || (k2 >= 20)) // Geen connectie van cellen bij borders
					continue;

				if (grid[r2][k2])
					buren++;
			}
		}
		return buren;
	}

	private boolean evolueer(int row, int column) {

		boolean levendeCel = grid[row][column]; // Check of de huidige cel levend of dood is
		int buren = telBuren(row, column);

		if (buren == 3)
			return true;

		if (levendeCel && buren == 2) // Als levendeCel=true en 2 buren
			return true;

		return false; // Dode cel
	}

	public void volgendeGeneratie() {

		// Kopieer grid voor het testen van (nog niet aangepaste) cellen
		boolean[][] grid2 = new boolean[rows][columns];

		for (int r = 0; r < rows - 1; r++) {
			for (int k = 0; k < columns - 1; k++) {
				grid2[r][k] = evolueer(r, k);
			}
		}

		for (int r = 0; r < rows - 1; r++) {
			for (int k = 0; k < columns - 1; k++) {
				grid[r][k] = grid2[r][k]; // 'deep copy'
			}
		}		
		setChanged();
		notifyObservers();
	}

	public void toggle(int row, int column) {
		if(isLevend(row, column) == true) {
			grid[row][column] = false;
		} else grid[row][column] = true;		
		
		CellPosition cell = new CellPosition(row, column);
		setChanged();
		notifyObservers(cell);
	}
}

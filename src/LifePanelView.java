import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LifePanelView extends JPanel implements Observer {

	private LifeModel model;
	JButton[][] buttons = new JButton[30][20]; // Error bij model.getRows in jbutton[][]
	
	public LifePanelView(LifeModel model){
		this.model = model;
		model.addObserver(this);
		
		int rows = model.getRows();
		int columns = model.getColumns();
		
		// Gridlayout zorgt ervoor dat het grid gevult wordt over het panel
		this.setBackground(Color.RED);		
		GridLayout gridLayout = new GridLayout(rows, columns);
		this.setLayout(gridLayout); 
				
		for(int r = 0; r < rows; r++) {
			for(int k = 0; k < columns; k++) {
				buttons[r][k] = new JButton();
				buttons[r][k].setBackground(setColorCell(r, k));
				buttons[r][k].addActionListener(new LifeButtonListener(model, r, k));
				this.add(buttons[r][k]);				
			}
		}
	}
	
	private void toonCel(int rij, int kolom) {
		buttons[rij][kolom].setBackground(setColorCell(rij,kolom));
}

	private Color setColorCell(int rij, int kolom) {
		if (model.isLevend(rij, kolom)) {
			return Color.BLACK;
		} else {
			return Color.WHITE;
		}	
}
	
	private void refresh() {			
		for(int r = 0; r < model.getRows(); r++) {
			for(int k = 0; k < model.getColumns(); k++) {
				toonCel(r, k);			
			}	
		}
	}
	
	@Override
	public void update(Observable model, Object info) {
		refresh();		
	}	
}




















































//private LifeModel model;
//private int rows = model.getRows();
//private int columns = model.getColumns();
//JButton[][] buttons = new JButton[rows][columns];
//
//
//// Constructor
//public LifePanelView(LifeModel model) {
//	
//	this.model = model;
//	model.addObserver(this);
//	
//	// Grid layout & fill with buttons
//	this.setBackground(Color.RED);
//	GridLayout grid = new GridLayout(rows, columns);
//	this.setLayout(grid);		
//	
//	JButton[][] buttons = new JButton[rows][columns];
//	for(int r = 0; r < rows; r++) {
//		for(int k = 0; k < columns; k++) {
//			buttons[r][k] = new JButton();
//			buttons[r][k].setBackground(setColorCel(r, k));
//			//buttons[r][k].addActionListener(new LifeButtonListener(model));
//			add(buttons[r][k]);
//		}
//	}
//}	
//
//private void toonCel(int row, int column) {
//	buttons[row][column].setBackground(setColorCel(row, column));
//}
//
//private Color setColorCel(int row, int column) {
//	boolean cel = model.isLevend(row, column); // 20 is maximum, dus die telt niet mee.
//	
//	if(cel == true)
//		return Color.BLACK;
//		
//	else return Color.WHITE;
//}
//
//private void refresh() {			
//	for(int r = 0; r < model.getRows(); r++) {
//		for(int k = 0; k < model.getColumns(); k++) {
//			toonCel(r, k);
//		}	
//	}
//}

//@Override
//public void update(Observable arg0, Object arg1) {
//	refresh();		
//}
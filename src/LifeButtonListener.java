import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LifeButtonListener implements ActionListener {

	private LifeModel model;
	private int column;
	private int row;
	
	public LifeButtonListener(LifeModel model, int row, int column) {
		this.model = model;
		this.row = row;
		this.column = column;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.toggle(row, column);				
//		System.out.println("klik");
	}
}

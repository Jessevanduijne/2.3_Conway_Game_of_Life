import java.util.Observable;
import java.util.Observer;

public class LifeConsoleView implements Observer {

	private LifeModel model;
	
	public LifeConsoleView(LifeModel model) {		
		this.model = model;
		model.addObserver(this);
	}
	
	private void toonCel(int rij, int kolom) {	
		boolean cel = model.isLevend(rij, kolom); // 20 is maximum, dus die telt niet mee.
				
		if(cel == true)
			System.out.print(" X ");		
		else System.out.print(" . ");		
	}
	
	private void refresh() {			
		for(int r = 0; r < model.getRows(); r++) {
			System.out.printf("%2d", r + 1);
			for(int k = 0; k < model.getColumns(); k++) {
				toonCel(r, k);
			}	
			System.out.println();
		}
		System.out.println();
	}

	@Override
	public void update(Observable model, Object info) {
		refresh();	// Dit gebeurt vanzelf
	}
}

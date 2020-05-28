import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifeController implements ActionListener {

	private LifeModel model;
	
	public LifeController(LifeModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.volgendeGeneratie();
//		System.out.println("Bericht van timer");		
	}
}

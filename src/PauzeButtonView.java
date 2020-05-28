import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class PauzeButtonView extends JPanel {

	private Timer timer;
	
	public PauzeButtonView(Timer timer) {
		
		this.timer = timer;		
		JButton pauzeKnop = new JButton("Pauzeer");
		pauzeKnop.addActionListener(new TimerController(timer));	
		add(pauzeKnop);
	}

}

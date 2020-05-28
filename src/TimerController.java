import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TimerController implements ActionListener {

	private Timer timer;
	
	public TimerController(Timer timer) {
		this.timer = timer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {		
		if(timer.isRunning()) {
			timer.stop();
		} else timer.start();		
	}

}

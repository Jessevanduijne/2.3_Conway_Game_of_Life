import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class LifeFrame extends JFrame{

	private LifeModel model;
	
	public LifeFrame(String title) {
		model = new LifeModel();
		
		this.setBounds(500, 200, 600, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(title);
		this.setVisible(true);
		
		LifePanelView panelView = new LifePanelView(model);	 // Panel
		LifeConsoleView consoleView = new LifeConsoleView(model); // Console
		
		add(panelView, BorderLayout.CENTER);		
		Timer timer = new Timer(1000, new LifeController(model));
		timer.start();
		
		PauzeButtonView pauzeKnop = new PauzeButtonView(timer);
		add(pauzeKnop, BorderLayout.SOUTH);
	}
}

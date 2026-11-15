package studyCase;
import java.awt.Color;

import java.awt.Container;

import javax.swing.JFrame;


public class AnimacionParabola extends JFrame{
	private Lienzo ball = new Lienzo();
	public AnimacionParabola() {
		super("Tiro parabolico");
		setSize(844,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Container c = getContentPane();
		c.add(ball);
		setVisible(true);
	}
	public static void main(String[] args) {
		new AnimacionParabola();
	}
}

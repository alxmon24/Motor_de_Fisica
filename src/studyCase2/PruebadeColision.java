package studyCase2;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;


public class PruebadeColision extends JFrame{
	private Lienzo2 lienzo = new Lienzo2();
	public PruebadeColision() {
		super("Colision");
		setSize(800,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Container c = getContentPane();
		c.add(lienzo);
		setVisible(true);
		lienzo.startAnimation();
	}
	public static void main(String[] args) {
		new PruebadeColision();
	}
}

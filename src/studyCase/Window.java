package studyCase;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame{
	private GD Lienzo = new GD();
	public Window() {
		super("Geometry Dash");
		setSize(1200,650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Container c = getContentPane();
		c.add(Lienzo);
		setVisible(true);
		Lienzo.startAnimation();
		Musica musica = new Musica();
		musica.reproducir();
		
		Lienzo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(Lienzo.cube.Vy == 0) {Lienzo.cube.saltar();}
				else if(Lienzo.animando == false) {
					Lienzo.reiniciar();
				}
			}
		});
		

	}
	public static void main(String[] args) {
		new Window();
	}
}

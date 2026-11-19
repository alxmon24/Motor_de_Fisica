package studyCase;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
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

		//Iniciar la musica del videojuego
		Musica musica = new Musica();
		Lienzo.musica = musica;
		musica.reproducir();

		Lienzo.startAnimation();
		
		Lienzo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(Lienzo.cube.Vy == 0) {Lienzo.cube.saltar();}
				else if(Lienzo.animando == false) {
					Lienzo.reiniciar();
				}
			}
		});
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if(code == KeyEvent.VK_SPACE && Lienzo.cube.Vy == 0) {
					Lienzo.cube.saltar();
					}
				else if(Lienzo.animando == false) Lienzo.reiniciar();
				}
		});
		

	}
	public static void main(String[] args) {
		new Window();
	}
}

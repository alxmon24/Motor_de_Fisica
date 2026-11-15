package studyCase;
import java.awt.Color;
import motor_de_fisica.ObjetoTiroParabolico;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Lienzo extends JPanel{
	ObjetoTiroParabolico jugador = new ObjetoTiroParabolico(50,390);
	double gravedad = 980;
	private int diametro = 40;
	protected double dt = 1.0;	
	protected boolean animando = true;
	public Lienzo() {
		jugador.Vx = 50;
		jugador.Vy = -60;
		startAnimation();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.GREEN);
		g.fillRect(0, 400, 844, 50);
		g.setColor(Color.YELLOW);
		g.fillOval((int)jugador.x, (int)jugador.y, diametro, diametro);
		
	}
	public void startAnimation() {
		Thread animation = new Thread() {
				public void run() {
					while(animando) {
						update();
						repaint();
						try {Thread.sleep(100); }catch(Exception e){}
					}
				}
		};
		animation.start();
	}
	public void update() {
		jugador.aceleracion(1.5, 9.8*jugador.masa);
		jugador.actualizarFisica(dt);
		if(jugador.y >= 391) {
			animando = false;
		}
	}
}

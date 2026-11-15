package studyCase2;
import java.awt.Color;
import motor_de_fisica.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Lienzo2 extends JPanel{
	ObjetoTiroParabolico jugador = new ObjetoTiroParabolico(50,370,20);
	Pared muro = new Pared(500,100,100,300);
	Pared suelo = new Pared(0,400,844,50);
	double gravedad = 980;
	private int diametro = 40;
	protected double dt = 0.25;	
	protected boolean animando = true;
	public Lienzo2() {
		jugador.Vx = 50;
		jugador.Vy = -60;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.GREEN);
		g.fillRect(0, 400, 844, 50);
		g.setColor(Color.YELLOW);
		g.fillOval((int)jugador.x, (int)jugador.y, diametro, diametro);
		Color cafe = new Color(135, 39, 19);
		g.setColor(cafe);
		g.fillRect(500, 100, 100, 300);
		
	}
	public void startAnimation() {
		Thread animation = new Thread() {
				public void run() {
					while(animando) {
						update();
						repaint();
						try {Thread.sleep(50); }catch(Exception e){}
					}
				}
		};
		animation.start();
	}
	public void update() {
		jugador.aceleracion(1.5, 9.8*jugador.masa);
		jugador.actualizarFisica(dt);
		if(Colision.estadoColision(jugador, muro)) {
			jugador.Vx = 0;
		}
		if(jugador.Vy > 0 && Colision.estadoColision(jugador, suelo)) {
			jugador.y = suelo.getArriba() - diametro;
			animando = false;
		}
	}
}

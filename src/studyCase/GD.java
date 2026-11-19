package studyCase;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import motor_de_fisica.*;


public class GD extends JPanel{
	private BufferedImage imgFondo,imgCubo,imgPiso, imgPincho;
	protected Jugador cube = new Jugador(250,350,80);
	private Obstaculo piso[] = {
			new Obstaculo(0,410,1200,2)
	};
	private Obstaculo pincho[] = {
			new Obstaculo(800, 390, 2,2),
			new Obstaculo(840,390,2,2)
	};
	public boolean animando = true;
	private Formas forma = Formas.CUBO;
	private int fondoX = 0;
	private int velocidadFondo = 6;
	
	public GD() {
		try {
			System.out.println("Cargando Imagenes");
			imgFondo = ImageIO.read(new File("src/images/background.png"));
			imgCubo = ImageIO.read(new File("src/images/cubo.png"));
			imgPiso = ImageIO.read(new File("src/images/difuminado.png"));
			imgPincho = ImageIO.read(new File("src/images/pincho.png"));
		}
		catch(Exception e) {
			System.out.println("Error al cargar imagenes");
			e.printStackTrace();
		}
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(imgCubo != null && imgFondo != null) {
			
		g.drawImage(imgFondo, fondoX,0,1200,650,null);
		g.drawImage(imgFondo, fondoX + 1200,0,1200,650,null);
		g.drawImage(imgCubo, (int)cube.x,(int)cube.y,80,80,null);
		for(Objeto p : pincho) {
			g.drawImage(imgPincho, (int)p.x-15, (int)p.y-20, 40,40,null );

		}
		
		if(forma == Formas.CUBO || forma == Formas.ROBOT) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 410, 1200, 1);
			g.drawImage(imgPiso, 0,410,1200,240,null);
		}
		}
		else {
			g.setColor(Color.YELLOW);
			g.fillRect(0, 0, 1020, 1020);
		}
	}
	//Efecto de desplazamiento
	public void desplazarMundo() {
		fondoX -= velocidadFondo;
		if(fondoX <= -1200) {
			fondoX = 0;
		}
		for(Objeto p : pincho) {
			p.x -= velocidadFondo;
		}
	}
	//Aqui va la fisica del juego
	public void update() {
		cube.actualizarFisica(0.50);
		for(Objeto p : piso) {
			if(Colision.estadoColision(cube, p) && cube.Vy > 0) {
				cube.Vy = 0;
				cube.y = p.getArriba() - 60;
				break;
			}
		}
		for(Objeto p: pincho) {
			if(Colision.estadoColision(cube, p)) {
				animando = false;
			}
		}
		
	}
	
	public void startAnimation() {
		Thread animation = new Thread() {
			public void run() {
				while(animando) {
					update();
					desplazarMundo();
					repaint();
					try {Thread.sleep(16);}catch(Exception e) {}
				}
			}
		};
		animation.start();
	}
	public void reiniciar() {
		cube.y = 350;
		fondoX = 0;
		animando = true;
		pincho = new Obstaculo[] {
				new Obstaculo(800, 390, 2,10),
				new Obstaculo(840,390,2,10)
		};
		startAnimation();
	}
}

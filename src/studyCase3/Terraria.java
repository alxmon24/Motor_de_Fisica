package studyCase3;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import motor_de_fisica.Colision;
import motor_de_fisica.Jugador;
import motor_de_fisica.Obstaculo;

public class Terraria extends JPanel {

    protected Jugador jugador = new Jugador(100, 100, 40);
    private Obstaculo piso = new Obstaculo(0, 480, 1000, 120);

    public boolean moviendoIzquierda = false;
    public boolean moviendoDerecha = false;
    private double velocidadCaminar = 10;

    public Terraria() {
        jugador.alto = 70;
        setBackground(new Color(135, 206, 235)); // Azul cielo
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(110, 75, 40)); // Café tierra
        g.fillRect((int) piso.x, (int) piso.y, (int) piso.ancho, (int) piso.alto);

        g.setColor(Color.RED);
        g.fillRect((int) jugador.x, (int) jugador.y, (int) jugador.ancho, (int) jugador.alto);
    }

    public void update() {
        // Controlar velocidad horizontal
        if (moviendoDerecha) {
            jugador.Vx = velocidadCaminar;
        } else if (moviendoIzquierda) {
            jugador.Vx = -velocidadCaminar;
        } else {
            jugador.Vx = 0;
        }
        jugador.actualizarFisica(0.5);

        // Colisión con el piso
        if (Colision.estadoColision(jugador, piso) && jugador.Vy > 0) {
            jugador.Vy = 0;
            jugador.y = piso.getArriba() - jugador.alto;
        }
    }

    public void startAnimation() {
        Thread animation = new Thread() {
            @Override
            public void run() {
                while (true) {
                    update();
                    repaint();
                    try {
                        Thread.sleep(16); // ~60 FPS
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        animation.start();
    }
}
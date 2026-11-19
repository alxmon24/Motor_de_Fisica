package studyCase3;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Window extends JFrame {

    private Terraria lienzo = new Terraria();

    public Window() {
        super("Terraria");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Container c = getContentPane();
        c.add(lienzo);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_RIGHT) {
                    lienzo.moviendoDerecha = true;
                } else if (code == KeyEvent.VK_LEFT) {
                    lienzo.moviendoIzquierda = true;
                } else if (code == KeyEvent.VK_UP) {
                    if (lienzo.jugador.Vy == 0) {
                        lienzo.jugador.saltar();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_RIGHT) {
                    lienzo.moviendoDerecha = false;
                } else if (code == KeyEvent.VK_LEFT) {
                    lienzo.moviendoIzquierda = false;
                }
            }
        });

        setVisible(true);
        lienzo.startAnimation();
    }

    public static void main(String[] args) {
        new Window();
    }
}
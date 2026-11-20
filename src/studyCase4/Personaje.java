package studyCase4;
import motor_de_fisica.Objeto;

public class Personaje extends Objeto {
    public int life;

    public Personaje(double x, double y, double ancho, double alto) {
        super(x, y, ancho, alto);
        life = 100;
    }

    public void getHurt(int damage) {
        life = life - damage;

        if (life < 0) {
            life = 0;
        }
    }

    public boolean isAlive() {
        return life > 0;
    }
}

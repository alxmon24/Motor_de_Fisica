package motor_de_fisica;

public class Jugador extends ObjetoTiroParabolico{ //nos vamos a basar en la forma en la que salta y cae por gravedad para el cubo
	public Jugador(double x, double y, double width) {
		super(x,y,width);
	}
	public void saltar() {
		super.Vy = -25;
	}
	@Override
	public void actualizarFisica(double dt) {
		super.aceleracion(0, 3); //la aceleracion nos generara la gravedad en la caida y Vy nos permitira dar el salto
		super.actualizarFisica(dt);
	}
}

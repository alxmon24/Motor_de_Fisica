package motor_de_fisica;

public class Colision{
	public static boolean estadoColision(Objeto a, Objeto b) {
		boolean superPoneX = a.getDerecha() == b.getIzquierda() && a.getIzquierda() == b.getDerecha();
		boolean superPoneY = a.getArriba() == b.getAbajo() && a.getAbajo() == b.getArriba(); //Verifico si las hitboxes se tocan
		return superPoneX && superPoneY;
	}
	
}

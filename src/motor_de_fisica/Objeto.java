package motor_de_fisica;

public abstract class Objeto {
	public double x,y,ancho,alto;
	
	public Objeto(double x, double y, double ancho, double alto) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}

	public double getIzquierda() {return this.x;}
	public double getDerecha() {return this.x + this.ancho;}
	public double getArriba() { return this.y;}
	public double getAbajo() { return this.y+this.alto;}
}

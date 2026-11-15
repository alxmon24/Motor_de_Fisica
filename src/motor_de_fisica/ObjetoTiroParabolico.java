package motor_de_fisica;

public class ObjetoTiroParabolico {
	//posicion
	public double x, y;
	public double Vx, Vy; //Velocidad
	public double accX,accY;
	public double masa = 1;
	
	public ObjetoTiroParabolico(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void aceleracion(double fuerzaX, double fuerzaY) {
		this.accX += fuerzaX/this.masa;
		this.accY += fuerzaY/this.masa;
		
	}
	
	public void actualizarFisica(double dt) {
		this.Vx += this.accX * dt;
		this.Vy += this.accY * dt;
		this.x += this.Vx * dt;
		this.y += this.Vy * dt;
		this.accX = 0;
		this.accY = 0;
	}
}

package motor_de_fisica;

public class ObjetoTiroParabolico extends Objeto{
	//posicion
	public double Vx, Vy; //Velocidad
	public double accX,accY;
	protected double radio = 20;
	public double masa = 1;
	
	public ObjetoTiroParabolico(double x, double y, double radio) {
		super(x,y, radio, radio);
		if(radio>0) {
			this.radio = radio;
		}
	}
	public void aceleracion(double fuerzaX, double fuerzaY) {
		this.accX += fuerzaX/this.masa; // a = F/m
		this.accY += fuerzaY/this.masa;
		
	}
	
	public void actualizarFisica(double dt) {
		this.Vx += this.accX * dt; // (Vf-Vi) = a*t
		this.Vy += this.accY * dt;
		this.x += this.Vx * dt; //x = V*t
		this.y += this.Vy * dt;
		this.accX = 0;
		this.accY = 0;
	}
	public double area() {
		double a = Math.PI * this.radio*this.radio;
		return a;
	}
}

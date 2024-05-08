package modelo;

public class Empleado extends Persona{
	
	private float sueldo;

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public Empleado(String nombre, int edad, float sueldo) {
		super(nombre, edad);
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return super.toString() +"Empleado [sueldo=" + sueldo + "]";
	} 
	
	
	public void funcion1() {
		
		System.out.println("SOY EL HIJO");
		
	}
	

}

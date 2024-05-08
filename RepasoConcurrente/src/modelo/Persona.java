package modelo;

public class Persona implements IVivir, IMorir{
		
	//Public persona.variable
	//Private persona.getVariable
	//protected 
	private String nombre;
	private int edad; 

	public static int numero;//Variable compartida
	
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}

	

	
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void funcion1() {
		
		System.out.println("SOY EL PADRE");
		
	}




	@Override
	public void estoyViviendo() {
		// TODO Auto-generated method stub
		System.out.println("Esta viviendo!!!");
	}
	
	

}

package modelo;

public class Persona {
	
	
	private String nombre;
	private int edad; 
	private float peso;
	
	public static int buenosMomentos;
	
	
	
	
	public Persona(String nombre, int edad, float peso) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + "]";
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
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	 public void funcion1() {
	    	
	    	System.out.println("Soy la función del padre!!!");
	    }
	 
	 public void funcion2() {
	    	
	    	System.out.println("Soy la función del padre y qué!!!!!");
	    }
	
	
	

}

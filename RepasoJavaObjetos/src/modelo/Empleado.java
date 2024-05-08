package modelo;

public class Empleado extends Persona {
	
	
    private double salario;
    
    public Empleado(String nombre, int edad,float peso, double salario) {
    	
        super(nombre, edad, peso); // Llama al constructor de la clase padre (Persona)
        this.salario = salario;
    }

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return super.toString() +"Empleado [salario=" + salario + "]";
	}

	
    public void funcion1() {
    	
    	System.out.println("Soy la función del hijo!!!");
    }
    
 
    
    
    
    
}

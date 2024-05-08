package test;

import modelo.Empleado;
import modelo.Persona;

public class TestPersona1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Polimorfismo: Padre: int suma(int a)
		//Hijos int suma(int a)
		
		//Sobrecarga de método:
		//int suma(int a, int b)
		//int suma(int a, float b);
		
		
		Persona persona1 = new Persona("Nico", 11);
		Persona persona2 = new Persona("Brenda", 22);
		
		
		System.out.println(persona1);
		
		persona1.numero = 3;
		
		System.out.println(persona1.numero);
		
		System.out.println(persona2.numero);
		
		System.out.println(Persona.numero);
		
		Empleado e1 = new Empleado("Lopez", 23, 15.36f);
		
		System.out.println(e1);
		
		e1.funcion1();
		

	}

}

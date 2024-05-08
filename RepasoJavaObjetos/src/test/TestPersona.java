package test;

import modelo.Empleado;
import modelo.Persona;

public class TestPersona {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Persona p1 = new Persona("Nico", 34, 1.89f);
		
		Persona p2 = new Persona("Brenda", 34, 1.89f);
		
		p1.buenosMomentos = 12;
		
		System.out.println(p2.buenosMomentos);
		
		System.out.println(p1);
		
		Empleado e1 = new Empleado("Ruben", 11, 1.66f, 35000);
		
		System.out.println(e1);
		
		p1.funcion1();
		
		e1.funcion1();
		
		e1.funcion2();

	}

}

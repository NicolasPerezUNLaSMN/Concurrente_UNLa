package solucion_indeterminismo;

import java.util.Random;

//Multiplicar todos los elementos de un array por 10


public class Solucion1 extends Thread{
	
	private static int tam = 10;
	
	private static int[] vector = new int[tam];
	
	private int inicio; 
	private int fin;
	
	public Solucion1 (int i, int f) {
		this.fin = f; 
		this.inicio = i; 
	}
	
	public Solucion1 () {
		
	}
	
	public void run() {
		//SOLUCIÓN 1: Evitamos acceso a RC, es la más eficiente
		
		for (int i = inicio; i< fin; i++) {
			
			vector[i]*=10;
		}
		
	}
	
	public static void main(String[] args) {
		
		Random rand = new Random(System.nanoTime());
		
		//Cargo el vector
		for (int i = 0; i<vector.length; i++) {
			
			vector[i] = rand.nextInt(100);
			
		}
		
		

		
		//Muestro el vector!!!!
		System.out.print("\n");
		for (int i = 0; i<vector.length; i++) {
			
			System.out.print(" " +vector [i]);
			
		}
		
		//Voy a multiplicar cada elemento por 2, pero usando dos Hilos
		
		Solucion1 h1 =new  Solucion1(0, (int) tam/2);
		Solucion1 h2 =new  Solucion1((int) tam/2,tam);
		
		h1.start();
		h2.start();	
		
		
		try {
			
			//Hacemos que el hilo principal espere
			h1.join();
			h2.join();
			
		}catch (Exception ex) {}
		
		
		//Muestro el vector!!!!
		System.out.print("\n");
		for (int i = 0; i<vector.length; i++) {
					
			System.out.print(" " +vector [i]);
					
		}
		
		
		//Ejercicio hacerlo con un tamaño impar.
		//Ejercicio hacerlo con más hilos. 
		//Hacerlo con el maximo de hilos que pueda soportar tu pc.Hilos = nucleos lógicos?
		
		
		
		
	}
	

}

package solucion_indeterminismo;

import java.util.Random;

public class Solucion2 extends Thread{
	
	//Lo mismo que antes pero con matrices
	
	private static int col = 10; 
	private static int ren = 10;
	
	private int inicio;
	private int fin;
			
	private static int[][] matriz = new int[col][ren];

	public Solucion2(int inicio, int fin) {
		
		this.inicio = inicio; 
		this.fin = fin;
		
	}
	
	public void run() {
		
		for ( int c = 0 ; c <col; c++) {
			
			for ( int r = inicio ; r<fin; r++) {
		
				matriz[c][r] *= 10; 
				
			}	}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		///Información de la PC
		Runtime runtime = Runtime.getRuntime();
		
		int numeroNucleos = runtime.availableProcessors();
		
		System.out.print("Número de procesadores lógicos:"+numeroNucleos +"\n\n");
		
		
		Random rand = new Random(System.nanoTime());
		
		//Calcular el tiempo
		double tiempoInicial, tiempoFinal;
		
		
		//cargo la matriz
		for ( int c = 0 ; c <col; c++) {
			
			for ( int r = 0 ; r<ren; r++) {
				
				matriz[c][r] = rand.nextInt(10,99);
				
			}
			
		}
		
		tiempoInicial = System.nanoTime(); //Qué hora es? 
		
		Solucion2 h1 = new Solucion2(0,ren/2);
		Solucion2 h2 = new Solucion2(ren/2, ren);
		
		h1.start();
		h2.start();
		
		try {
			
			h1.join();
			h2.join();
			
		}catch (Exception e) {}
		
		tiempoFinal = System.nanoTime()-tiempoInicial;
		
		
		//mostrar la matriz
		for ( int c = 0 ; c <col; c++) {
			
			for ( int r = 0 ; r<ren; r++) {
				
				System.out.print(" "+matriz[c][r]);
				
			}
			System.out.print("\n");
			
		}
		
		System.out.print("El programa concurrente, memoro: "+ tiempoFinal +" nanoSegundos");
		
		//Verificar cuanto tardaria con 4 hilos. Siempre a más hilos menos tiempo?

	}

}

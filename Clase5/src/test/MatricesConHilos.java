package test;

import java.util.Random;

public class MatricesConHilos extends Thread{
	
	//Lo mismo que antes pero con matrices
	
	private static int col = 15; 
	private static int ren = 15;
	
	private int inicio;
	private int fin;
			
	private static int[][] matriz = new int[col][ren];

	public MatricesConHilos(int inicio, int fin) {
		
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
		
		//Multiplico cada elemento por 10 secuencial
		tiempoInicial = System.nanoTime(); //Qué hora es? 
		for ( int c = 0 ; c <col; c++) {
			
			for ( int r = 0 ; r<ren; r++) {
				
				matriz[c][r] *= 10;
				
			}
			
		}
		tiempoFinal = System.nanoTime()-tiempoInicial;
		
		//mostrar la matriz
				for ( int c = 0 ; c <col; c++) {
					
					for ( int r = 0 ; r<ren; r++) {
						
						System.out.print(" "+matriz[c][r]);
						
					}
					System.out.print("\n");
					
				}
				
		System.out.print("El programa secuencial, demoró: "+ tiempoFinal +" nanoSegundos\n\n");
		
		
		
		
		tiempoInicial = System.nanoTime(); //Qué hora es? 
		
		///Hilos como procesadores logicos
		Thread[] hilos = new Thread[numeroNucleos];
		
		int rango = ren/numeroNucleos;
		int arranca = 0 ; 
		int termina = rango; 
		
		
		
		for (int i = 0 ; i<numeroNucleos; i++) {
			
			if ( i != numeroNucleos-1) { //Si no es el ultimo hilo
				hilos[i] = new MatricesConHilos(arranca,termina); //Hija de Thread
				hilos[i].start();
				
				arranca = termina;
				termina = termina + rango ;
			}else { //En caso que sea el ultimo hilo
				
				hilos[i] = new MatricesConHilos(arranca,ren); //Hija de Thread
				hilos[i].start();
		
				
			}
			
		}
		
		
		
		try {
			
			for (int i = 0 ; i<numeroNucleos; i++) {
				
				hilos[i].join();
				
			}
			
		}catch (Exception e) {}
		
		tiempoFinal = System.nanoTime()-tiempoInicial;
		
		
		//mostrar la matriz
		for ( int c = 0 ; c <col; c++) {
			
			for ( int r = 0 ; r<ren; r++) {
				
				System.out.print(" "+matriz[c][r]);
				
			}
			System.out.print("\n");
			
		}
		
		System.out.print("El programa concurrente, demoro: "+ tiempoFinal +" nanoSegundos");
		
		

	}

}

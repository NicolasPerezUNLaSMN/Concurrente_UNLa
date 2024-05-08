package test;

public class Planteos extends Thread {
	
	//Atributos:

	private static int cantElementos = 1000;

	private static int[] vector = new int[cantElementos];

	private static int impares = 0;

	private int inicio; 
	private int fin; 
	private int id;
	
	private int contadorHilo = 0; 
	
	//Constructor:
	public Planteos(int id, int inicio, int fin) {
		super();
		this.id = id; 
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public void run() {
		
			
			for(int i = inicio; i < fin; i++) {
				
				try {
					sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if ( vector[i]%2 != 0) {
					
					this.contadorHilo++;
					}
					
				
				
			}
			
		
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		///Información de la PC
				Runtime runtime = Runtime.getRuntime();
				
				int numeroNucleos = runtime.availableProcessors();
				
				System.out.print("Número de procesadores lógicos:"+numeroNucleos +"\n\n");
		double inicio, fin; 
		
		int cantHilos = 2; 
		
		Planteos[] hilos = new Planteos[cantHilos];
		
		///Cargo el array
		for ( int i = 0 ; i<1000; i++) {
			
			vector[i] = i; 
			
		}
		
		
		inicio = System.nanoTime();
		///Lo voy a hacer secuencial
		for ( int i = 0 ; i<1000; i++) {
			
			try {
				sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if ( vector[i]%2!=0) {
				
				impares++;
			}
			
		}
		fin = System.nanoTime() - inicio;
		System.out.println("Cantidad de impares Sec:\n" +impares +" Demore: miliSeg "+fin/1000000);
		impares = 0 ; 
		
		
		//creamos los hilos
		inicio = System.nanoTime();
		hilos[0] = new Planteos(0,0,500);
		hilos[1] = new Planteos(1,500,1000);
		
		
		hilos[0].start();
		hilos[1].start();
		
		
		try {
			hilos[0].join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			hilos[1].join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		impares = hilos[0].contadorHilo + hilos[0].contadorHilo;
		fin = System.nanoTime() - inicio;
		
		System.out.println("Cantidad de impares Con:\n" +impares +" Demore: miliSeg "+fin/1000000);
		
		
		
		

	}



}

package test;

public class ArreglosConHilos  extends Thread{
	
	private static int[] vector = new int[1000];
	
	private static int contadorImpares = 0 ; 
	
	
	private int inicio; 
	private int fin;
	private int idHilo; 
	
	///Solucion contadores RC
	private int contadorDelHilo = 0; 
	
	
	
	public ArreglosConHilos(int inicio, int fin, int idHilo) {
		super();
		this.inicio = inicio;
		this.fin = fin;
		this.idHilo = idHilo;
	}


	public void run() {
		
		
			for ( int i = inicio ; i<fin; i++) {
				
				try {
					sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if ( vector[i] % 2 != 0) {
					
						this.contadorDelHilo++;
					
				}
					
			}
		
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double arranco, fin; 
		
		Runtime r = Runtime.getRuntime();
		int numeroNucleos = r.availableProcessors();
		
		System.out.println("\n----> NUCLEOS: "+numeroNucleos);
		
		int cantHilos = numeroNucleos;
		
		ArreglosConHilos[] hilos = new ArreglosConHilos[cantHilos];
		
		//Cargar el arreglo
		for ( int i = 0 ; i<1000; i++) {
		
			vector[i] = i; 
				
		}
		
		arranco = System.nanoTime();
		///Problema pero secuencial!!!
		for ( int i = 0 ; i<1000; i++) {
			try {
				sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if ( vector[i] % 2 != 0) {
				
				contadorImpares++;
			}
				
		}
		
		
			fin = System.nanoTime() - arranco;
			
			System.out.println("\n-----Sec----");
			System.out.println("\nCONTADOR: "+contadorImpares);
			System.out.println("\nTIEMPO: [microSeg] "+fin/1000);
			
			contadorImpares = 0 ; 
			
			//Crear los hilos
			arranco = System.nanoTime();
			
			
			int salto = 1000/cantHilos; //Ojo son divisibles en mi caso
			
			for ( int i = 0; i<cantHilos; i++) {
				
				if(i!=cantHilos-1) {
				hilos[i] = new ArreglosConHilos(0+(i*salto), salto+(i*salto), i+1);
				}else {
					hilos[i] = new ArreglosConHilos(0+(i*salto), 1000, i+1);
				}
			}
			
			for ( int i = 0; i<cantHilos; i++) {
			
				hilos[i].start();
			}
		
			
			try {
				for ( int i = 0; i<cantHilos; i++) {
					hilos[i].join();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for ( int i = 0; i<cantHilos; i++) {
				
				contadorImpares+=hilos[i].contadorDelHilo;
			}
		
		
			fin = System.nanoTime() - arranco;
			
			System.out.println("\n-----Con----");
			System.out.println("\nCONTADOR: "+contadorImpares);
			System.out.println("\nTIEMPO: [microSeg] "+fin/1000);
			
		}

	

}

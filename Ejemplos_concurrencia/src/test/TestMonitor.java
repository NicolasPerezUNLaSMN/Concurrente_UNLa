package test;

import monitor.Monitor;

public class TestMonitor implements Runnable {
	
	//Cuando los hilos van a usar todos algo, ese algo 
	//debe ser estatico
	private static Monitor m = new Monitor(); 
	
	@Override
	/*public void run() {
		// TODO Auto-generated method stub
		
		m.incrementar();
		
		//El get tambien está sincronizado, los hilos se encolan 
		//para ejecturarlo
		System.out.println("Valor: ---> "+m.getContador() );
		//Que pasa así? El resultado es correcto, pero los parciales?
		//Los monitores garantizan resultado correcto, pero no garantiza el orden
		
		//Se aconseja no llamar a dos metodos diferentes del monitor
	}*/
	
	public void run() {
	
	System.out.println("Valor: ---> "+m.incrementar());
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runtime r = Runtime.getRuntime();
		int cantidadNucleos = r.availableProcessors();
		
		Thread[] hilos = new Thread[cantidadNucleos];
		
		System.out.println("Tengo "+ cantidadNucleos +" hilos");
		
		for ( int i = 0; i<cantidadNucleos; i++) {
			
			Runnable runnable = new TestMonitor();
			hilos[i] = new Thread(runnable);
			
			hilos[i].start();
		}
		
		
		for ( int i = 0; i<cantidadNucleos; i++) {
			
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

	

}

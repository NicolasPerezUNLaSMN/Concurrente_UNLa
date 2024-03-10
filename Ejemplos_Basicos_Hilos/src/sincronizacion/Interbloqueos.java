package sincronizacion;

import java.util.Random;

public class Interbloqueos implements Runnable {
	
	private int hiloId;
	
	//cerrojos
	private static Random cerrojo1 = new Random();
	private static Random cerrojo2 = new Random();
	
	public Interbloqueos(int i ) {
		this.hiloId = i;
	}
	
	@Override
	public void run() {
		//Vamos a generar interbloqueo con dos cerrojos
		
	
		
		//definimos la estrategia de espera!!!
		if(hiloId % 2 ==0) {
			//Si el hilo es par
			synchronized(cerrojo1) {
				
				synchronized(cerrojo2) {
					//Un hilo par activa los dos cerrojos
					System.out.println("SOY EL HILO:"+hiloId);
				}
				
			};
			
		}
		else {
			//Si es impar
			synchronized(cerrojo2) {
				
				synchronized(cerrojo1) {
					System.out.println("SOY EL HILO:"+hiloId);
				}
				
			};
			
		}
		
		//IDeal, evitar cerrojos dentro de cerrojos!!!
		
	}//CIERRA EL RUN

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numeroHilos = 10; 
		Thread[] hilos = new Thread[numeroHilos];
		
		for (int i = 0 ; i<numeroHilos; i++) {
			
			Runnable r = new Interbloqueos(i);
			hilos[i] = new Thread(r);
			hilos[i].start();
			
			
		}
		
		
		for (int i = 0 ; i<numeroHilos; i++) {
		
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("HILO PRINCIPAL");

	}

	

}

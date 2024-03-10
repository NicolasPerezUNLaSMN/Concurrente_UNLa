package sincronizacion;

import java.util.Random;

public class Interbloqueos2 implements Runnable {
	
	private int hiloId;
	
	//cerrojos
	private static Random cerrojo1 = new Random();
	private static Random cerrojo2 = new Random();
	
	private int contPrivado = 0 ;  //Buffer, contador local
	private static int cont = 0;  //Esta es la critica y compartida
	
	public Interbloqueos2(int i ) {
		this.hiloId = i;
	}
	
	@Override
	public void run() {
		
		//Evitar el interbloqueo con Buffers
		
		for (int i = 0; i<30000; i++) {
			
			contPrivado++;
			
		} //La mayor carga de trabajo la hacen todos los hilos
		
		//La espera es solo para la asignación
		synchronized(cerrojo1) {
			
			cont +=contPrivado; 
			
		}
		
		
	}//CIERRA EL RUN

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numeroHilos = 10; 
		Thread[] hilos = new Thread[numeroHilos];
		
		for (int i = 0 ; i<numeroHilos; i++) {
			
			Runnable r = new Interbloqueos2(i);
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
		
		System.out.println("HILO PRINCIPAL, conteo: "+cont);

	}

	

}

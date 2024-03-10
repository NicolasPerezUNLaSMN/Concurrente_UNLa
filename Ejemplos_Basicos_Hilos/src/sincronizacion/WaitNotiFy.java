package sincronizacion;

import java.util.Random;

//No heredo, sino que implemento una IF
public class WaitNotiFy implements Runnable {
	
	private int hiloId;
	private static int cont = 0; 
	
	private static Random r= new Random();
	
	
	
	@Override
	public void run() {
		
		//Ejemplo para que los hilos se ejectuen en orden
		//esto no suele ser util, para eso lo hago secuencial
		//es solo para explciar
		synchronized(r){
			//Sin el while y el notify quedaria interbloqueado
			while( hiloId != cont) {
				
				try {
					r.wait(); //duerme a los hilos
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("RUN... HILO: "+ hiloId);
			cont++;
			r.notifyAll(); //Despertar hilos.
			
		}
		
		
		
	}
	
	public WaitNotiFy(int i ) {
		this.hiloId = i;
	};

	
	
	public static void main(String[] args) {
		
		int tam = 8;
		Thread[] hilos = new Thread[tam];
		
		for (int i = 0 ; i<tam; i++) {
			
			hilos[i] = new Thread(new WaitNotiFy(i));
			hilos[i].start();
		}
		
		

		
		
			
		for (int i = 0 ; i<tam; i++) {
			try {
				hilos[i].join();
			}catch (Exception e) {};
				
		}
		
		
		System.out.println("--> CONT: "+ cont);
		
	}

	
}

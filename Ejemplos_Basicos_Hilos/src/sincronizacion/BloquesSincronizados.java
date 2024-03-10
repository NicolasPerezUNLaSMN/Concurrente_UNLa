package sincronizacion;

//No heredo, sino que implemento una IF
public class BloquesSincronizados implements Runnable {
	
	//Para qué? Para poder heredar de otra clase, 
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("RUN...");
		
	}

	
	
	public static void main(String[] args) {
		
		//Nueva forma de lanzar hilos
		Runnable r = new BloquesSincronizados();
		
		//r.start(); Esto no se puede, runnable tiene solo un metodo, run
		//Hay que  crear un hilo con el constructor de Trhead que tiene parametro r
		
		Thread hilo = new Thread(r);
		hilo.start();
		
		try {hilo.join();
		}catch (Exception e) {};
		
		
		
	}

	
}

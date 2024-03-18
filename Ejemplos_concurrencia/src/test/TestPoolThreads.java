package test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Es para reciclar hilos que ya no están un uso

//https://miro.medium.com/v2/resize:fit:1200/1*4K-ZkOSPtu_z2qpWWdgYfQ.gif

//Por ejemplo lanzo 12 hilos (tantos como nucleos del procesador), pero quiero 20000
//Esos 2000 iran reciclando los 12 hilos 



public class TestPoolThreads implements Runnable {
		
	private static int tam = 20000;  //Ojo el limite del heap para la cantidad de hilos
	private static int[][] matriz = new int[tam][tam];
	
	private int fila;
	
	public TestPoolThreads(int fila) {
		this.fila = fila;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i<matriz.length; i++) {
			
			matriz[fila][i] *= 10; 
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		Random rand = new Random(System.nanoTime());
		
		double tiempoInicio, tiempoFinal;
		
		//Cargo la matriz con un digito
		for (int i = 0 ; i<matriz.length; i++) {
			for ( int j = 0; j<matriz.length; j++) {
				
				matriz[i][j] = rand.nextInt(10);	
				
			}
		}
		
		tiempoInicio = System.nanoTime();
		
		Thread[] hilos = new Thread[tam];
		
		ExecutorService pool = Executors.newFixedThreadPool(12); //Cantidad en la pileta
		//12 son los nucleos logicos
	
		//Otra opción 
		//ExecutorService pool = Executors.newCachedThreadPool();
		//ExecutorService pool = Executors.newSingleThreadExecutor();
		//Cuando es mejor cada uno?
		
		//Inicio los tam hilos
		for ( int i = 0 ; i<hilos.length; i++) {
			
			Runnable runnable = new TestPoolThreads(i);//Con i indicaré
			//de que fila me encargaré
			
			pool.execute(runnable);
		
			//hilos[i] = new Thread(runnable); //Antes
			
			//hilos[i].start();
			
			
		}
		
		//Espero que terminen los hilos
		/*//En los pools no hay join - awaitTerminated y isTerminated
		for ( int i = 0 ; i<hilos.length; i++) {
			
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}*/
		
		pool.shutdown(); //No permite más hilos nuevos
		while(!pool.isTerminated());
		
		tiempoFinal = System.nanoTime();
		
		System.out.println("Tiempo: "+(tiempoFinal-tiempoInicio)/1000 +" milisegundos");
		
		///Tardó 4 veces menos en mi pc.
		//Utilizar estó cuando hay muchos hilos MUCHOS
	
		
		
		
	}
	
	
	
	
	
}

package barrera;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Carrera implements Runnable{
	
	private int id; 
	
	
	private double inicio, total;
	
	//Matriz de tiempos para cada participante
	private static double[][] matrizTiempos;
	
	private static CyclicBarrier barrera;
	
	private Random rand = new Random(System.nanoTime());
	
	public static double[][] getMatrizTiempos() {
		return matrizTiempos;
	}


	
	
	public static void setCarrera(int participantes) {
		matrizTiempos  = new double[participantes][4];
		//Declaro la barrera
		barrera = new CyclicBarrier(participantes);
		//Esperar todos los hilos
	}
	
	public Carrera(int id) {
		this.id = id; 
	
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		etapa(0);
		etapa(1);
		etapa(2);
			
		matrizTiempos[id][3] = matrizTiempos[id][0]+matrizTiempos[id][1]+matrizTiempos[id][2];
		
	}
	
	private void etapa(int numeroEtapa) {
		
		inicio = System.nanoTime();
		
		try {
			Thread.sleep(rand.nextInt(100)+1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		total = (System.nanoTime() - inicio)/1000; //Muy poco tiempo demora
		
		matrizTiempos[id][numeroEtapa] = total;
		
		
		try {
			barrera.await(); //Ojo hay que resetear la barrera una vez que termian
			barrera.reset();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	public void mostrarTiempos(int participantes) {
		
		
		for ( int i = 0; i<participantes; i++) {
			for ( int j = 0; j<4; j++) {
				
				System.out.print(" "+matrizTiempos[i][j]+" ");
				
			}
			System.out.println();
		}
		
		
		
	}
	
	

}

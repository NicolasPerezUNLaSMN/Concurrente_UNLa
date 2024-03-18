package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import barrera.Carrera;

public class TestBarrera {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int participantes =24; 
		Carrera.setCarrera(participantes);
		
		Runtime runtime = Runtime.getRuntime();
		int numeroNucleos = runtime.availableProcessors();
		
		//ExecutorService pool = Executors.newFixedThreadPool(numeroNucleos);
		//100 hilos en una pileta de 12
		ExecutorService pool = Executors.newCachedThreadPool();
		
		for (int i = 0 ; i<participantes; i++) {
			
			//Hilo en otra clase pero ejecutado en otro
			Runnable runnable = new Carrera(i);
			
			pool.execute(runnable);
			
		}
		pool.shutdown();
		while(!pool.isTerminated());
		
		double[][] tiempos = Carrera.getMatrizTiempos();
		
	
		
		
		int idGanador1 = 0; 
		double ganadorTiempoEtapa1 = tiempos[0][0];
		
		int idGanador2 = 0; 
		double ganadorTiempoEtapa2 = tiempos[0][1];
		
		int idGanador3 = 0; 
		double ganadorTiempoEtapa3 = tiempos[0][2];
		
		int idGanadorT = 0; 
		double ganadorTiempoEtapaT = tiempos[0][3];
		
		//busco el minimo
		for ( int i = 0; i<participantes; i++) {
				
			if (tiempos[i][0] < ganadorTiempoEtapa1) {
				ganadorTiempoEtapa1 = tiempos[i][0];
				idGanador1 = i;
			}
			
			if (tiempos[i][1] < ganadorTiempoEtapa2) {
				ganadorTiempoEtapa2 = tiempos[i][1];
				idGanador2 = i;
			}
			
			if (tiempos[i][2] < ganadorTiempoEtapa3) {
				ganadorTiempoEtapa3 = tiempos[i][2];
				idGanador3 = i;
			}
			
			if (tiempos[i][3] < ganadorTiempoEtapaT) {
				ganadorTiempoEtapaT = tiempos[i][3];
				idGanadorT = i;
			}
			
			
			
		}
		
		System.out.println("Ganador 1: " +idGanador1 +" - - " +ganadorTiempoEtapa1);
		System.out.println("Ganador 2: " +idGanador2 +" - - " +ganadorTiempoEtapa2);
		System.out.println("Ganador 3: " +idGanador3 +" - - " +ganadorTiempoEtapa3);
		System.out.println("Ganador T: " +idGanadorT +" - - " +ganadorTiempoEtapaT);
		
		
		

	}

}

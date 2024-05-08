package test;



public class TestGenerales {
	
	
	 public static void main(String[] args) {
		 
	        int numProcesadores = Runtime.getRuntime().availableProcessors();
	        System.out.println("Cantidad de procesadores disponibles: " + numProcesadores);
	        
	        
	     // Obtener el tiempo inicial
	        long tiempoInicial = System.nanoTime();
	        
	        // Ejecutar el bucle
	        for (int i = 0; i < 1000000; i++) {
	            // Aquí va el código que deseas medir
	        	int n = i*2 -1;
	        }
	        
	        // Obtener el tiempo final
	        long tiempoFinal = System.nanoTime();
	        
	        // Calcular la diferencia de tiempo en milisegundos
	        long diferenciaTiempo = tiempoFinal - tiempoInicial;
	        double segundos = (double) diferenciaTiempo / 1_000_000_000.0;
	        
	        // Imprimir el tiempo transcurrido
	        System.out.println("Tiempo transcurrido: " + segundos + " segundos");
	      
	 }

}

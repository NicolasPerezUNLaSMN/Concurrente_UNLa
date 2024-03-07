package ejemplos;

public class Indeterminacion extends Thread {
	
	private static int contador = 0; 
	
	
	public void run() {
		
		///voy a incremetar mucho el contador
		for ( int i = 0; i<1000; i++) {
			contador++;
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tam = 1000;
		Indeterminacion[] vector = new Indeterminacion[tam];
		
		for ( int i  = 0 ; i<tam; i++) {
			
			vector[i]= new Indeterminacion();
			
			vector[i].start();
			
		}
		
		
		try {
			for ( int i =0; i<tam; i++) {
				
				
					vector[i].join();
			}
		} catch (Exception e) {
			
		}
		
		//Qué está pasando?
		//Hay muchos hilos escribiendo en la misma variable
		//por eso el valor es indeterminado - No hay EM, muchos Hilos acceden
		//a una sección crítica!!!
		System.out.println(contador);
		
		//Ejercicio: Realizar un grafico que explique lo que está ocurriendo
		

	}

}

package sincronizacion;

//No heredo, sino que implemento una IF
public class BloquesSincronizados2 implements Runnable {
	
	private int hiloInt;
	private static int cont = 0; 
	
	private static Object object = new Object();
	
	//Para qué? Para poder heredar de otra clase, 
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("RUN... HILO: "+ hiloInt);
		for (int i =0; i<100000; i++) {
			//Si o si hay que enviarle un elemtno Object
			synchronized(object){
				//El hilo que llega pregunta al synchronized si hay otro hilo 
				//en esta región critica
				//En caso que ese ocupado el hilo pasa a estar en la cola.
				//Cuando se libera la RC entra cualquiera de los hilos en espera
				//cual ingresa? Cualquiera, el más rápido.
				//CONCURSO - Este proceso lleva tiempo, como se mejoraria?
				cont++;
			}
			
			
		}
		
	}
	
	public BloquesSincronizados2(int i ) {
		this.hiloInt = i;
	};

	
	
	public static void main(String[] args) {
		
		int tam = 2;
		Thread[] hilos = new Thread[tam];
		for (int i = 0 ; i<tam; i++) {
			
			hilos[i] = new Thread(new BloquesSincronizados2(i));
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

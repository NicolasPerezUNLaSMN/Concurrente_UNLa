package ejemplos;

///Primero heredar la clase Hilos2 Thread
public class Hilos2  extends Thread{
	
	//Lea grego un atributo cualquiera a mi clase Hilos2
	public int numero; //identificador del hilo
	
	public void run() {
		System.out.println("Soy el hilo: " +numero);
	}
	
	
	
	//Obviamente genero su contructor, hasta acá todo igual
	public Hilos2(int numero) {
		this.numero = numero;
	}
	
	
	@Override
	public String toString() {
		return "Hilos2 [numero=" + numero + "]";
	}



	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Lo mismo de antes pero para un array
		Hilos2[]  vectorDeHilos= new Hilos2[5];
		
		///Instancio cada posición del array
		for ( int i =0 ; i<vectorDeHilos.length; i++) {
			
			vectorDeHilos[i] = new Hilos2(i); 
			//Instancio cada elemento del array
			
		}
		
		///Corro hilos para cara pos del vector, OBvio que se podria hacer en 
		//el mismo for
		for ( int i =0 ; i<vectorDeHilos.length; i++) {
			
			vectorDeHilos[i].start();
			
		}
		
		
		System.out.println("Soy el main!!!");
		

	}

}

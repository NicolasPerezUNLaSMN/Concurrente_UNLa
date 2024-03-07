package ejemplos;

///Primero heredar la clase Hilos2 Thread
public class Hilos3  extends Thread{
	
	//Lea grego un atributo cualquiera a mi clase Hilos2
	public int numero; //identificador del hilo
	
	public void run() {
		System.out.println("Soy el hilo: " +numero);
	}
	
	
	
	//Obviamente genero su contructor, hasta acá todo igual
	public Hilos3(int numero) {
		this.numero = numero;
	}
	
	
	@Override
	public String toString() {
		return "Hilos3 [numero=" + numero + "]";
	}



	
	
	public static void main(String[] args) {
		// HAREMOS Que el hilo principal MAIN no termine 
		//hasta que no terminen todos los hilos
		//es decir va a esperar!!!
		//USAREMOS EL JOIN
		
		//Lo mismo de antes pero para un array
		Hilos3[]  vectorDeHilos= new Hilos3[5];
		
		///Instancio cada posición del array
		for ( int i =0 ; i<vectorDeHilos.length; i++) {
			
			vectorDeHilos[i] = new Hilos3(i); 
			//Instancio cada elemento del array
			
		}
		
		///Corro hilos para cara pos del vector, OBvio que se podria hacer en 
		//el mismo for
		for ( int i =0 ; i<vectorDeHilos.length; i++) {
			
			vectorDeHilos[i].start();
			
		}
		
		///Metodo join, necesita el try y catch, haremos que el main
		//se ejecute siempre, despues del hilo 0
		
		try {
			vectorDeHilos[0].join(); //Esperar hasta que termine el run del hilo
		}catch(Exception ex){} //Como no sabemos cuando se ejecuta el 0, tampoco
		//sabemos cuando se ejetuca el main O___O
		
		//Ejercicio: Hacer que el main se ejecute despues de TODOS!!!
		
		//Ejercicio: Qué pasaria si hago el join en el for que hace el start?
		
		System.out.println("Soy el main!!!");
		

	}

}

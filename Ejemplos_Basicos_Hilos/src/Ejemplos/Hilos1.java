package ejemplos;

///Primero heredar la clase Hilos Thread
public class Hilos1  extends Thread{
	
	//Lea grego un atributo cualquiera a mi clase Hilos1
	public int numero; 
	
	//Obviamente genero su contructor
	public Hilos1(int numero) {
		this.numero = numero;
	}
	
	
	@Override
	public String toString() {
		return "Hilos1 [numero=" + numero + "]";
	}



	////Luego sobreescribir el procedimiento run
	//Este método es el que se lanza al inicar un nuevo hilo
	public void run() {
		System.out.println(toString());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hilos1 h1 = new Hilos1(1);
		Hilos1 h2 = new Hilos1(2);
		Hilos1 h3 = new Hilos1(3);
		
		///Lanzamos el primer hilo, es decir inicia
		//una instancia de la clase que hereda de Thread
		h1.start();///Esto inicia lo que está en run O__O
		h2.start();///Al crearse demora un tiempo
		h3.start();
		
		///!No sabemos en que orden se ejecutaran los hilos
		///el print no puede superponer texto por eso se ve
		///un mensaje u otro aleatoreamente
		
		System.out.println("Soy el main!!!");
		

	}

}

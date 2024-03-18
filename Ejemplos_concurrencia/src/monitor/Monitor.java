package monitor;

public class Monitor { //Es una clase como cualquier otra
	
	private int contador =0; //ahora no la hice estatica O__O
	private int orden = 0;
	
	//Da EM a cada método. Es decir genera metodos del tipo synchronized
	//Cada metodo evita que se ejecute cualquier otro metodo de ese tipo
	
	public synchronized int incrementar() {
		
		for (int i =0 ; i<1000000; i++) {
			
			contador++; 
		}
		return contador;
	}
	
	public synchronized void ordenar(int id) {
		
		while(id != orden) {//Compara el hilo con el esperado
			
			try {
				wait(); //Duerme el hilo que no corresponde
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
		}
		
		System.out.println("SOY EL HILO: "+id);
		orden++;
		notifyAll(); //Despertar hilos dormidos
	}


	public int getContador() {
		return contador;
	}


	public void setContador(int contador) {
		this.contador = contador;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}
	
	
}

//Los monitores simplifican mucho el codigo, PERO dan EM siempre, es decir
//que se ejecuta casi que de forma secuencial con las esperas :( 

//La concurrencia queda delegada a una sola clase, el Monitor

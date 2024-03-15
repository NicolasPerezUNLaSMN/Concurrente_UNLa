package producto_consumidor;

public class ProductoConsumidor implements Runnable {
	
	//Casos
	//Hay producto - Se resta 1 al producto
	//No hay producto, despierto al producto y se duermen los clientes
	//Productor siempre dormido - hasta que lo llamen
	
	
	private boolean consumidor;
	private static int stock = 0 ; 
	private static Object lock = new Object(); //no importa la clase

	public ProductoConsumidor(boolean consumidor) {
		this.consumidor = consumidor;
	}
	
	public void run() {
		
		while(true) { 
			
			if(consumidor) {
				consumir();
			}else {
				//Productor
				producir();
				
				
			}
			
			
		}
		
	}
	
	
	
	private void consumir() {
		// TODO Auto-generated method stub
		
		synchronized(lock) {
			
			if(stock>0) {
				stock--;
				System.out.println("Quedan: "+ stock +"elementos");
				//descansamos para que no sea tan rapido
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else {
				
				//NO hay stock - despierto a los hilos
				lock.notifyAll(); //Por qué no al productor??
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		}
		
	}

	private void producir() {
		// TODO Auto-generated method stub
		synchronized(lock){
			
			if(stock == 0) {
				stock = 10;
				System.out.println("Soy el producto: -> "+ stock);
				//despierta a todo el mundo 
				lock.notifyAll();
			}try {
				lock.wait();
			}catch(Exception e) {}
			
		}
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int cantHilos = 11; //10 consumidor y un productor
		
		Thread[] hilos = new Thread[cantHilos];
		
		for ( int i = 0 ; i<cantHilos; i++) {
			
			Runnable r = null;
			
			if (i!=0) {
				//10 consumidores
				r = new ProductoConsumidor(true);
			}else {
				
				r = new ProductoConsumidor(false);
				
			}
			
			hilos[i] = new Thread(r);
			hilos[i].start();
			
		}
		
		for ( int i = 0; i<cantHilos;i++) {
			
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		

	}

}

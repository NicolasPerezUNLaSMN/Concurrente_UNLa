package ejemplos;

import java.util.Random;

public class EficienciaEnTiempos extends Thread{
	
	
	private static double[] vec = new double[80000000];
	
	
	private int inicio, fin;
	
	public EficienciaEnTiempos(int inicio, int fin){
		this.inicio = inicio;
		this.fin = fin;
	}
	
	
	
	public static void main(String[] args){
		iniciavec();
		
		//opcion NO concurrente:
		vec_NOconcurrente();
		
		//opcion concurrente:
		vec_concurrente_muchos_hilos();
		
	
	}
	
	//Metodo que inicia el vector estatico con valores aleatorios
	private static void iniciavec(){
		Random rand = new Random(System.nanoTime());
		
		for(int i = 0; i < vec.length; i++){
			vec[i] = rand.nextInt();
		}
	}
	
	//Metodo que NO utiliza el paralelismo y por tanto se ejecuta de forma secuencial
	private static void vec_NOconcurrente(){
		double tiempo = System.nanoTime();
		for(int i = 0; i < vec.length; i++){
			vec[i] /= 10;
			vec[i] *= 10;
			vec[i] /= 10;
		}
		System.out.println("Version NO concurrente: "+ ((System.nanoTime() - tiempo) / 1000000) + " milisegundos");
	}
	
	
	
	//Metodo que ejecuta los hilos que que se lanzan
	public void run(){
		for(int i = inicio; i < fin; i++){
			vec[i] /= 10;
			vec[i] *= 10;
			vec[i] /= 10;
		}
	}
	
	//Metodo que ejecuta nproc hilos en paralelo y que llaman al metodo run para realizar la multiplicacion del
	//vector de forma paralela
	private static void vec_concurrente_muchos_hilos(){
		int nproc = Runtime.getRuntime().availableProcessors(); //Devuelve cuantos nucleos tiene la CPU
		int inicio = 0, fin = 0;
		EficienciaEnTiempos[] prin = new EficienciaEnTiempos[nproc];
		
	
		
		double tiempo = System.nanoTime(); 	//Comienzo para capturar el tiempo que tarda en ejecutarse 
											//este metodo
		
		for(int i = 0; i < nproc; i++){//Multiplicacion del vector por los nproc hilos
			inicio = fin;
			fin += vec.length/nproc;
			prin[i] = new EficienciaEnTiempos(inicio, fin);
			prin[i].start();
		}
		
		for(int i = 0; i < nproc; i++){
			try{
				prin[i].join();
			}catch(Exception e){}
		}
		System.out.println("Version Concurrente "+nproc +"Hilos:"+ ((System.nanoTime() - tiempo) / 1000000) + " milisegundos");
	}	
	
	

	
}
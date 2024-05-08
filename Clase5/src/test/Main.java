package test;



import java.util.Random;



public class Main extends Thread{


	private static int nHilos = 0;


	private static int nElementos = 100;

	private static int[] vector = new int[nElementos];

	private static int impares = 0;


	private static final Object lock = new Object();



	private int hID; // ID del Hilo



	public Main(int hID) {

		super();

		this.hID = hID;

	}



	// MANEJO DEL HILO

	@Override

	public void run() {

		super.run();


		int imparesEncontrados = 0, revisados = 0;

		for (int i = hID; i < nElementos; i+=nHilos) { // Recorriendo de esta forma nunca se va a acceder desde diferentes hilos al mismo elemento

			if(vector[i] % 2 == 0) {

				imparesEncontrados++;

			}

			revisados++;

		}

		//System.out.println("#" + this.hID + " - Impares encontrados: " + imparesEncontrados + "/" + revisados);

		System.out.println("#" + this.hID + "\t" + imparesEncontrados + "\t" + revisados);



		// Utilizo el bloqueo porque si o si en algun momento se tiene que juntar los resultados de cada hilo

		// Podría evitarlo teniendo un atributo propio por cada instancia que guarde una cantidad parcial y que luego en el MAIN con un FOR que recorra el array de Hilos y los sume uno por uno

		synchronized(lock) {

			impares += imparesEncontrados;

		}

	}



	// MOSTRAR

	private static void mostrarVector() {

		System.out.print("[");

		for (int i = 0; i < nElementos; i++) {

			System.out.print(vector[i]);

			if (i < nElementos -1) {

				System.out.print(",");

			}

		}

		System.out.println("]");

	}


	// VER CANTIDAD DE IMPARES REALES

	private static void mostrarCantidadImparesReales() {

		int imparesReales = 0;

		for (int i = 0; i < nElementos; i++) {

			if(vector[i] % 2 == 0) {

				imparesReales++;

			}

		}

		System.out.println("Total real de Impares: " + imparesReales);

	}




	// MAIN

	public static void main(String[] args) {


		// CREACIÓN DEL VECTOR

		Random rand = new Random();

		for (int i = 0; i < nElementos; i++) {

			vector[i] = rand.nextInt(10);

		}


		// DETALLES DEL VECTOR

		mostrarVector();

		mostrarCantidadImparesReales();



		// CALCULO DE CANTIDAD DE HILOS

		int min = 5, max = 10;

		nHilos = rand.nextInt(max - min + 1) + min; // ASIGNO LA CANTIDAD DE HILOS DE FORMA ESTATICA (ASI TENGO EL VALOR EN CUALQUIER LADO QUE SE USE LA CLASE O SU INSTANCIA)

		//nHilos = 2;

		System.out.println("\nCantidad de Hilos: " + Main.nHilos);



		// CREACION DE LOS HILOS

		Main[] hilos = new Main[nHilos];

		for (int i = 0; i < nHilos; i++) {

			hilos[i] = new Main(i);

		}


		System.out.println("Hilo\tImpares\tRevisados");


		// INICIO DE EJECUCION DE HILOS

		for (int i = 0; i < nHilos; i++) {

			hilos[i].start();

		}


		// ESTABLECER QUE EL MAIN SE EJECUTE DESPUES DE LOS HILOS

		for (int i = 0; i < nHilos; i++) {

			try {

				hilos[i].join();

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}


		// CANTIDAD DE IMPARES ENCONTRADOS EN TODOS LOS HILOS

		System.out.println("Total de impares: " + Main.impares);



	}



}


package modelo;

//Clase que implementa la interfaz Volador
public class Avion implements Volador, Destruido {
 @Override
 public void volar() {
     System.out.println("El avión está volando...");
 }

@Override
public void destruido() {
	// TODO Auto-generated method stub
	 System.out.println("El avión exploto, muerio mucha gente...");
}
}

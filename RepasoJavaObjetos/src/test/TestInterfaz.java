package test;
import modelo.Avion;
import modelo.Pajaro;

public class TestInterfaz {
	
	 public static void main(String[] args) {
		 
	        // Crear un objeto de tipo Pajaro
	        Pajaro pajaro = new Pajaro();
	        pajaro.volar(); // Llama al método volar() de la clase Pajaro

	        // Crear un objeto de tipo Avion
	        Avion avion = new Avion();
	        avion.volar(); // Llama al método volar() de la clase Avion
	        
	        
	        avion.destruido();
	 }
	
	
	

}

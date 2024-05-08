package modelo;


	
public class Pajaro implements Volador, Destruido {
	
		
	
	    @Override
	    public void volar() {
	        System.out.println("El pájaro está volando...");
	    }

		@Override
		public void destruido() {
			// TODO Auto-generated method stub 
			System.out.println("El pájaro ha muerto...");
			
		}

}




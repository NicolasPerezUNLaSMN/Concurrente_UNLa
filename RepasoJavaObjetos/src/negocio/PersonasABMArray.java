package negocio;

import modelo.Persona;

public class PersonasABMArray {
	
	private Persona[] personas; // Arreglo para almacenar objetos Persona
    private int cantidadPersonas; // Variable para rastrear la cantidad actual de personas en el arreglo
    
    // Constructor que inicializa el arreglo de personas con un tamaño específico
    public PersonasABMArray(int capacidad) {
        personas = new Persona[capacidad];
        cantidadPersonas = 0; // Al inicio no hay ninguna persona en el arreglo
    }
    
    // Método para agregar una nueva persona al arreglo
    public void agregarPersona(Persona persona) {
        if (cantidadPersonas < personas.length) {
            personas[cantidadPersonas] = persona;
            cantidadPersonas++;
            System.out.println("Persona agregada correctamente.");
        } else {
            System.out.println("No se puede agregar más personas. El arreglo está lleno.");
        }
    }
    
    // Método para mostrar la información de todas las personas en el arreglo
    public void mostrarPersonas() {
        System.out.println("Lista de personas:");
        for (int i = 0; i < cantidadPersonas; i++) {
            System.out.println(personas[i]);
        }
    }
    
    // Otros métodos para manipular el arreglo de personas según sea necesario

}

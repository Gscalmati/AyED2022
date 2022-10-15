package tp02.ejercicio2;

public class ColaGenericaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ColaGenerica <Integer> cola = new ColaGenerica <Integer> ();
		
		cola.encolar(15);
		cola.encolar(0);
		
		System.out.println(cola.tope());
		System.out.println(cola.desencolar());
		
		cola.encolar(25);
		System.out.println(cola.tope());
		System.out.println(cola.desencolar());
	}

}

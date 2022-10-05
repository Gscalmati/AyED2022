package tp02.ejercicio2;

public class PilaGenericaTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PilaGenerica <Integer> cola = new PilaGenerica <Integer> ();
		
		cola.apilar(15);
		cola.apilar(0);
		
		System.out.println(cola.tope());
		System.out.println(cola.desapilar());
		
		cola.apilar(25);
		System.out.println(cola.tope());
		System.out.println(cola.desapilar());
		System.out.println(cola.desapilar());
		System.out.println(cola.desapilar());
	}

}

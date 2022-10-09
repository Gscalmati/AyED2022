package tp04.ejercicio1;

public class TestArbolGeneral {

	public static void main(String[] args) {
		//TEST ANCHO
		//testAncho();
		//TEST ALTO
		testAlto();
		
	}
	
	public static void testAncho () {
				ArbolGeneral<Integer> ag = new ArbolGeneral<Integer> (20);
				ArbolGeneral<Integer> hag1 = new ArbolGeneral<Integer> (30);
				ArbolGeneral<Integer> hag2 = new ArbolGeneral<Integer> (31);
				ArbolGeneral<Integer> hag3 = new ArbolGeneral<Integer> (32);
				
				ag.agregarHijo(hag1);
				ag.agregarHijo(hag2);
				ag.agregarHijo(hag3);
				
				ArbolGeneral<Integer> hhag1 = new ArbolGeneral<Integer> (40);
				
				hag3.agregarHijo(hhag1);
				
				ArbolGeneral<Integer> hhhag1 = new ArbolGeneral<Integer> (30);
				ArbolGeneral<Integer> hhhag2 = new ArbolGeneral<Integer> (31);
				ArbolGeneral<Integer> hhhag3 = new ArbolGeneral<Integer> (32);
				ArbolGeneral<Integer> hhhag4 = new ArbolGeneral<Integer> (30);
				ArbolGeneral<Integer> hhhag5 = new ArbolGeneral<Integer> (31);
				
				hhag1.agregarHijo(hhhag1);
				hhag1.agregarHijo(hhhag2);
				hhag1.agregarHijo(hhhag3);
				hhag1.agregarHijo(hhhag4);
				hhag1.agregarHijo(hhhag5);
				
				Integer resultado = ag.ancho();
				System.out.println(resultado);
	}
	
	public static void testAlto () {
		ArbolGeneral<Integer> ag = new ArbolGeneral<Integer> (20);
		ArbolGeneral<Integer> hag1 = new ArbolGeneral<Integer> (30);
		ArbolGeneral<Integer> hag2 = new ArbolGeneral<Integer> (31);
		ArbolGeneral<Integer> hag3 = new ArbolGeneral<Integer> (32);
		
		ag.agregarHijo(hag1);
		ag.agregarHijo(hag2);
		ag.agregarHijo(hag3);
		
		ArbolGeneral<Integer> hhag1 = new ArbolGeneral<Integer> (40);
		
		hag3.agregarHijo(hhag1);
		
		ArbolGeneral<Integer> hhhag1 = new ArbolGeneral<Integer> (30);
		ArbolGeneral<Integer> hhhag2 = new ArbolGeneral<Integer> (31);
		ArbolGeneral<Integer> hhhag3 = new ArbolGeneral<Integer> (32);
		ArbolGeneral<Integer> hhhag4 = new ArbolGeneral<Integer> (30);
		ArbolGeneral<Integer> hhhag5 = new ArbolGeneral<Integer> (31);
		
		hhag1.agregarHijo(hhhag1);
		hhag1.agregarHijo(hhhag2);
		hhag1.agregarHijo(hhhag3);
		hhag1.agregarHijo(hhhag4);
		hhag1.agregarHijo(hhhag5);
		
		Integer resultado = ag.altura();
		System.out.println(resultado);
}

}

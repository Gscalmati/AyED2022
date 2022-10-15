package tp04.ejercicio7;

import tp04.ejercicio1.ArbolGeneral;

public class TestRedAguaPotable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolGeneral<String> ag = new ArbolGeneral<String> ("A");
		ArbolGeneral<String> hag1 = new ArbolGeneral<String> ("B");
		ArbolGeneral<String> hag2 = new ArbolGeneral<String> ("C");
		ArbolGeneral<String> hag3 = new ArbolGeneral<String> ("D");
		ArbolGeneral<String> hag4 = new ArbolGeneral<String> ("E");
		
		ag.agregarHijo(hag1);
		ag.agregarHijo(hag2);
		ag.agregarHijo(hag3);
		ag.agregarHijo(hag4);
		
		ArbolGeneral<String> hagc1 = new ArbolGeneral<String> ("F");
		ArbolGeneral<String> hagc2 = new ArbolGeneral<String> ("G");
		
		hag2.agregarHijo(hagc1);
		hag2.agregarHijo(hagc2);
		
		ArbolGeneral<String> hagd1 = new ArbolGeneral<String> ("H");
		ArbolGeneral<String> hagd2 = new ArbolGeneral<String> ("I");
		ArbolGeneral<String> hagd3 = new ArbolGeneral<String> ("J");
		ArbolGeneral<String> hagd4 = new ArbolGeneral<String> ("K");
		ArbolGeneral<String> hagd5 = new ArbolGeneral<String> ("W");
		
		hag3.agregarHijo(hagd1);
		hag3.agregarHijo(hagd2);
		hag3.agregarHijo(hagd3);
		hag3.agregarHijo(hagd4);
		hag3.agregarHijo(hagd5);
		
		ArbolGeneral<String> hagg1 = new ArbolGeneral<String> ("L");
		
		hagc2.agregarHijo(hagg1);
	
		ArbolGeneral<String> hagj1 = new ArbolGeneral<String> ("M");
		ArbolGeneral<String> hagj2 = new ArbolGeneral<String> ("N");
		
		hagd3.agregarHijo(hagj1);
		hagd3.agregarHijo(hagj2);
		
		RedAguaPotable red = new RedAguaPotable ();
		
		red.setRed(ag);
		
		System.out.println (red.minimoCaudal(1000.0));
	}

}

package tp03.ejercicio2;

import tp04.ejercicio2.RecorridosGeneral;

public class TestEjs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArbolBinario <Integer> ab = new ArbolBinario <Integer>(10);
		
		ArbolBinario <Integer> hi = new ArbolBinario <Integer>(5);
		ArbolBinario <Integer> hd = new ArbolBinario <Integer>(20);
		
		ArbolBinario <Integer> hid = new ArbolBinario <Integer>(8);
		ArbolBinario <Integer> hdi = new ArbolBinario <Integer>(18);
		
		ab.agregarHijoIzquierdo(hi);
		ab.agregarHijoDerecho(hd);
		
		hi.agregarHijoDerecho(hid);
		hd.agregarHijoIzquierdo(hdi);
		
		
		RecorridosGeneral recorrer = new RecorridosGeneral();
		/*
		recorrer.preOrder(ab);
		
		System.out.println();
		
		ArbolBinario<Integer> arbolEspejo = new ArbolBinario <Integer>();
		
		arbolEspejo = ab.espejo();
		
		recorrer.preOrder(arbolEspejo);
		*/
		
		//recorrer.porNiveles(ab);
		
		ab.entreNiveles(1, 2);
		

	}

}

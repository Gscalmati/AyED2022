package tp03.ejercicio5;

import tp03.ejercicio2.ArbolBinario;

public class TestProfundidadDeArbolBinario {

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

		ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario();
		prof.setAb(ab);
		System.out.println(prof.sumaElementosProfundidad(4));
	}

}

package parcial1210;

import tp03.ejercicio2.ArbolBinario;
import tp03.ejercicio4.RedBinariaLlena;

public class TestParcial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolBinario <Integer> ab = new ArbolBinario <Integer>(7);
		
		ArbolBinario <Integer> hi = new ArbolBinario <Integer>(56);
		ArbolBinario <Integer> hd = new ArbolBinario <Integer>(25);
		
		ArbolBinario <Integer> hii = new ArbolBinario <Integer>(38);
		ArbolBinario <Integer> hid = new ArbolBinario <Integer>(31);
		
		ArbolBinario <Integer> hdi = new ArbolBinario <Integer>(5);
		ArbolBinario <Integer> hdd = new ArbolBinario <Integer>(6);

		
		ab.agregarHijoIzquierdo(hi);
		ab.agregarHijoDerecho(hd);
		
		
		hi.agregarHijoIzquierdo(hii);
		hi.agregarHijoDerecho(hid);
		
		hd.agregarHijoIzquierdo(hdi);
		hd.agregarHijoDerecho(hdd);
		
		
		System.out.println("-------------------------------------------");
		
		
		Parcial p = new Parcial ();
		
		Integer result = p.resolver(ab);
		
		System.out.println(result);
	}

}

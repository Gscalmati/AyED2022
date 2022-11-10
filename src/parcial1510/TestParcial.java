package parcial1510;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio2.ArbolBinario;

public class TestParcial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolBinario <Integer> ab = new ArbolBinario <Integer>(10);
		
		ArbolBinario <Integer> hi = new ArbolBinario <Integer>(5);
		ArbolBinario <Integer> hd = new ArbolBinario <Integer>(20);
		
		ArbolBinario <Integer> hii = new ArbolBinario <Integer>(8);
		ArbolBinario <Integer> hid = new ArbolBinario <Integer>(18);
		
		ArbolBinario <Integer> hdi = new ArbolBinario <Integer>(8);
		ArbolBinario <Integer> hdd = new ArbolBinario <Integer>(18);
		
		ArbolBinario <Integer> hddd = new ArbolBinario <Integer>(40);
		
		ab.agregarHijoIzquierdo(hi);
		ab.agregarHijoDerecho(hd);
		
		hi.agregarHijoDerecho(hid);
		hi.agregarHijoIzquierdo(hii);
		
		hd.agregarHijoDerecho(hdd);
		hd.agregarHijoIzquierdo(hdi);
		
		hdd.agregarHijoDerecho(hddd);
		
		Parcial parcial = new Parcial();
		
		ListaGenerica <Integer> lista = parcial.resolver(ab, 4);
		lista.comenzar();
		while (!lista.fin()) {
			System.out.println(lista.proximo());
		}
		
		
		
	}

}

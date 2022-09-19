package tp03.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp03.ejercicio2.ArbolBinario;

public class TestContadorArbol {
	
	public static void main(String[] args) {
		
		ArbolBinario <Integer> ab = new ArbolBinario <Integer>(10);
		
		ArbolBinario <Integer> hi = new ArbolBinario <Integer>(5);
		ArbolBinario <Integer> hd = new ArbolBinario <Integer>(20);
		
		ArbolBinario <Integer> hid = new ArbolBinario <Integer>(8);
		ArbolBinario <Integer> hdi = new ArbolBinario <Integer>(18);
		
		ab.agregarHijoIzquierdo(hi);
		ab.agregarHijoDerecho(hd);
		
		hi.agregarHijoDerecho(hid);
		hd.agregarHijoIzquierdo(hdi);
		
		
		ContadorArbol contador = new ContadorArbol ();
		
		contador.setArbol(ab);
		
		ListaEnlazadaGenerica <Integer> lista = new ListaEnlazadaGenerica <Integer>();
	
		
		lista = contador.numerosPares();
		
		lista.comenzar();
		
		lista.agregarFinal(13);
		
		while (!lista.fin()){
			System.out.println(lista.proximo());
		}

	}

}

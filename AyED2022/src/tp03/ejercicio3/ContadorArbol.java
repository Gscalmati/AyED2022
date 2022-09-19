package tp03.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp03.ejercicio2.*;

public class ContadorArbol {
	
	private ArbolBinario<Integer> arbol;
	
	public ContadorArbol () {
		this.arbol = new ArbolBinario<Integer> ();
	}
	
	

	
	public ArbolBinario<Integer> getArbol() {
		return arbol;
	}




	public void setArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}




	public ListaEnlazadaGenerica <Integer> numerosPares () {
		
		ListaEnlazadaGenerica <Integer> lista = new ListaEnlazadaGenerica <Integer>();
		
		//this.inOrder(arbol, lista);
		
		this.postOrder(arbol, lista);
		
		
		return lista;
		
	}
	
	private void inOrder (ArbolBinario <Integer> arbol, ListaEnlazadaGenerica <Integer> lista) {

		if (!arbol.esVacio()) {
			
			
			
			if (arbol.tieneHijoIzquierdo()) {
				inOrder(arbol.getHijoIzquierdo(), lista);
			}
			
			
			if (this.arbol.getDato() / 2 == 0) {
				lista.agregarFinal(this.arbol.getDato());
			}
			
			if (arbol.tieneHijoDerecho()) {
				inOrder(arbol.getHijoDerecho(), lista);
			}
		}
	}
	
	private void postOrder (ArbolBinario <Integer> arbol, ListaEnlazadaGenerica <Integer> lista) {
		
		if (!arbol.esVacio()) {
			
			
			if (arbol.tieneHijoIzquierdo()) {
				postOrder(arbol.getHijoIzquierdo(), lista);
			}
			
			
			
			if (arbol.tieneHijoDerecho()) {
				postOrder(arbol.getHijoDerecho(), lista);
			}
			
			if (this.arbol.getDato() >  0) {
				lista.agregarFinal(this.arbol.getDato());
			}
		}
	}
}


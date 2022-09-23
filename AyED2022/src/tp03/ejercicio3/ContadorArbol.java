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
		
		this.inOrder(this.arbol, lista);
		
		//this.postOrder(this.arbol, lista);
		
		
		return lista;
		
	}
	
	private void inOrder (ArbolBinario <Integer> arbol, ListaEnlazadaGenerica <Integer> lista) {

		if (!arbol.esVacio()) {
			
			
			
			if (arbol.tieneHijoIzquierdo()) {
				inOrder(arbol.getHijoIzquierdo(), lista);
			}
			
			
			if (arbol.getDato() % 2 == 0) {
				lista.agregarFinal(arbol.getDato());
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
			//Aca deberia ir THIS.ARBOL o el ARBOL del metodo actual? Con THIS imprime todo, Y con solo ARBOL, lo correcto. QUÉ PASA?
			if ((arbol.getDato() % 2) ==  0) {
				lista.agregarFinal(arbol.getDato());
			}
		}
	}
}


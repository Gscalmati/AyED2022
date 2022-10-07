package tp04.ejercicio3;

import tp02.ejercicio2.*;
import tp04.ejercicio1.ArbolGeneral;

public class RecorridosAG {

		
	public ListaGenerica<Integer> numerosImparesMayorQuePreOrden (ArbolGeneral <Integer> arbol, Integer m) {
		
		ListaGenerica <Integer> lista = new ListaEnlazadaGenerica <Integer>();
		
		this.recursionPreOrden (arbol, m, lista);
		
		return lista;
			
	}

	private void recursionPreOrden(ArbolGeneral<Integer> arbol, Integer m, ListaGenerica<Integer> lista) {
		
		if (!arbol.esVacio()) {
			
			if (arbol.getDato() % 2 == 1) {
				lista.agregarFinal(arbol.getDato());
			}
			
			ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
			
			hijos.comenzar();
			
			while (!hijos.fin()) {
				this.recursionPreOrden(hijos.proximo(), m, lista);
			}
		}
		
	}
	
	
}

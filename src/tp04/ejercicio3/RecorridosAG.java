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
	
	//------------------------------------------------------------------------------------------------------------//
	
	public ListaGenerica<Integer> numerosImparesMayorQueInOrden (ArbolGeneral <Integer> arbol, Integer m) {
		
		ListaGenerica <Integer> lista = new ListaEnlazadaGenerica <Integer>();
		
		this.recursionInOrden (arbol, m, lista);
		
		return lista;
			
	}

	private void recursionInOrden(ArbolGeneral<Integer> arbol, Integer m, ListaGenerica<Integer> lista) {
		
		if (!arbol.esVacio()) {
			
			ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
			
			hijos.comenzar();
			
			if (!hijos.esVacia())
				this.recursionInOrden(hijos.proximo(), m, lista);
			
			
			if (arbol.getDato() % 2 == 1) {
				lista.agregarFinal(arbol.getDato());
			}
			
			
			while (!hijos.fin()) {
				this.recursionPreOrden(hijos.proximo(), m, lista);
			}
		}
		
	}
	
	//------------------------------------------------------------------------------------------------------------//
	
		public ListaGenerica<Integer> numerosImparesMayorQuePostOrden (ArbolGeneral <Integer> arbol, Integer m) {
			
			ListaGenerica <Integer> lista = new ListaEnlazadaGenerica <Integer>();
			
			this.recursionPostOrden (arbol, m, lista);
			
			return lista;
				
		}

		private void recursionPostOrden(ArbolGeneral<Integer> arbol, Integer m, ListaGenerica<Integer> lista) {
			
			if (!arbol.esVacio()) {
				
				ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
				
				hijos.comenzar();
				
				while (!hijos.fin()) {
					this.recursionPostOrden(hijos.proximo(), m, lista);
				}
				
				if (arbol.getDato() % 2 == 1) {
					lista.agregarFinal(arbol.getDato());
				}
				
			}
			
		}
		
	//------------------------------------------------------------------------------------------------------------//
	
		public ListaGenerica<Integer> numerosImparesMayorQuePorNiveles (ArbolGeneral <Integer> arbol, Integer m) {
			
			ListaGenerica<Integer> listaImpares = new ListaEnlazadaGenerica<Integer> ();
			
			ColaGenerica <ArbolGeneral <Integer>> cola = new ColaGenerica <ArbolGeneral <Integer>>();
			cola.encolar(arbol);
			cola.encolar(null);
			int nivel = 1;
			System.out.println("Nivel " + nivel);
			
			while (!cola.esVacia()) {
				ArbolGeneral<Integer> subArbol = cola.desencolar();
				
				// Si el SUBARBOL no es Null, imprimimos dato y recorremos hijos
				if (subArbol != null) {
					if (subArbol.getDato() % 2 == 1) {
						listaImpares.agregarFinal(subArbol.getDato());
					}
					
					// Si tiene hijos, los encolamos
					if (subArbol.tieneHijos()) {
						ListaGenerica <ArbolGeneral<Integer>> hijos = subArbol.getHijos();
						hijos.comenzar();
						while (!hijos.fin()) {
							cola.encolar(hijos.proximo());
						}
					}

				}  else { //Si el SUBARBOL es Null, encolamos otro Null si quedan elementos en la COLA y subimos de Nivel

					if (!cola.esVacia()) {
						cola.encolar(null);		
						nivel++;
						System.out.println("Nivel " + nivel);
					}
				}
			}
			
			return listaImpares;
		}
}

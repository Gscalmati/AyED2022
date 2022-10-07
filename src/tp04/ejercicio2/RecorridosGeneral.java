package tp04.ejercicio2;

import tp02.ejercicio2.*;
import tp03.ejercicio2.ArbolBinario;
import tp04.ejercicio1.ArbolGeneral;


public class RecorridosGeneral {
	
	public void preOrder (ArbolGeneral <Integer> arbol) {
		if (!arbol.esVacio()) {
			
			
			System.out.println(arbol.getDato());
			
			ListaGenerica <ArbolGeneral<Integer>> hijos = arbol.getHijos();
			
			hijos.comenzar();
			while (!hijos.fin()) {
				postOrden(hijos.proximo());
			}
			
			
		}
	}
	
	public void inOrder (ArbolGeneral <Integer> arbol) {
		if (!arbol.esVacio()) {
			
			ListaGenerica <ArbolGeneral<Integer>> hijos = arbol.getHijos();
			
			if (!hijos.esVacia())
				inOrder(hijos.proximo());
			
			System.out.println(arbol.getDato());
			
			hijos.comenzar();
			while (!hijos.fin()) {
				inOrder(hijos.proximo());
			}
		}
	}
	
	public void postOrden (ArbolGeneral <Integer> arbol) {
		if (!arbol.esVacio()) {
			
			ListaGenerica <ArbolGeneral<Integer>> hijos = arbol.getHijos();
			
			hijos.comenzar();
			
			while (!hijos.fin()) {
				postOrden(hijos.proximo());
			}
			
			System.out.println(arbol.getDato());
		}
	}
	
	public void porNiveles (ArbolGeneral <Integer> ab) {
		//Usando una COLA, Encolo Arbol entero -> Primer Elemento
		ColaGenerica <ArbolGeneral <Integer>> cola = new ColaGenerica <ArbolGeneral <Integer>>();
		cola.encolar(ab);
		cola.encolar(null);
		int nivel = 1;
		System.out.println("Nivel " + nivel);
		
		while (!cola.esVacia()) {
			ArbolGeneral<Integer> subArbol = cola.desencolar();
			
			// Si el SUBARBOL no es Null, imprimimos dato y recorremos hijos
			if (subArbol != null) {
				System.out.println(subArbol.getDato());
				
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
		//	FIN MIENTRAS
	}

//----------------------------------------------------------------------------------------------------------
	
}
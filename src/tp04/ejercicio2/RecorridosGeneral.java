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
			
			
			inOrder(arbol.get)
			
			System.out.println(arbol.getDato());
			
			if (arbol.tieneHijoDerecho()) {
				inOrder(arbol.getHijoDerecho());
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
		//Usando una COLA, Encolo Arbol entero
		ColaGenerica <ArbolGeneral <Integer>> cola = new ColaGenerica <ArbolGeneral <Integer>>();
		cola.encolar(ab);
		cola.encolar(null);
		int nivel = 1;
		System.out.println("Nivel " + nivel);
		
		
		//	MIENTRAS HAYA COSAS EN LA COLA
		while (!cola.esVacia()) {
			ArbolGeneral<Integer> subArbol = cola.desencolar();
			
			if (subArbol != null) {
			
				System.out.println(subArbol.getDato());
				
				if (subArbol.tieneHijos()) {
					ListaGenerica <ArbolGeneral<Integer>> hijos = subArbol.getHijos();
					
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}

			}  else { 

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
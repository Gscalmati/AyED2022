package tp03.ejercicio5;

import tp02.ejercicio2.ColaGenerica;
import tp03.ejercicio2.ArbolBinario;

public class ProfundidadDeArbolBinario {
	
	private ArbolBinario<Integer> ab;
	
	public ProfundidadDeArbolBinario () {
		this.ab = new ArbolBinario<Integer> ();
	}
	
	
	public void setAb(ArbolBinario<Integer> ab) {
		this.ab = ab;
	}


	public int sumaElementosProfundidad (int p) {
		
		return procesoSuma (p);
		
	}
	
	public int procesoSuma (int p){
		
		int sumaTotal = 0;
		ColaGenerica <ArbolBinario <Integer>> cola = new ColaGenerica <ArbolBinario <Integer>>();
		cola.encolar(this.ab);
		cola.encolar(null);
		
		int nivel = 1;
		
		// SI LLEGO AL NIVEL P, NO TIENE SENTIDO SEGUIR RECORRIENDO EL ARBOL. Quedaria vaciar la cola.
		while (!cola.esVacia()) {			
				ArbolBinario<Integer> subArbol = cola.desencolar();
			if (subArbol != null) {
				if (p == nivel) {
					sumaTotal += subArbol.getDato();
					//While 
				} else {
					if (subArbol.tieneHijoIzquierdo()) {
						cola.encolar(subArbol.getHijoIzquierdo());
					}
					if (subArbol.tieneHijoDerecho()) {
						cola.encolar(subArbol.getHijoDerecho());
					}
				}
			}  else {
				if (!cola.esVacia()) {
					cola.encolar(null);
					nivel++;
				}
			}
		}
		return sumaTotal;
	}

}

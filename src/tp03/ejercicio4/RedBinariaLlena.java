package tp03.ejercicio4;

import tp03.ejercicio2.ArbolBinario;

public class RedBinariaLlena {
	
	private ArbolBinario<Integer> ab;
	
	public RedBinariaLlena (ArbolBinario<Integer> unArbol){
		this.ab = unArbol;
	}
	
	public RedBinariaLlena (){
		
	}

	
	public ArbolBinario<Integer> getAb() {
		return ab;
	}



	public void setAb(ArbolBinario<Integer> ab) {
		this.ab = ab;
	}



	public int retardoReenvio () {

		//Que cada nodo mande el maximo
		//Me quedo con el maximo de los 2
		//
		
		
	}
	
	public int postOrden (ArbolBinario <Integer> arbol) {
		int suma = 0;
		if (!arbol.esVacio()) {
			if (arbol.tieneHijoIzquierdo()) {
				suma += postOrden(arbol.getHijoIzquierdo());
			}
			
			if (arbol.tieneHijoDerecho()) {
				suma+= postOrden(arbol.getHijoDerecho());
			}
			
			
		}
		return suma;
	}

}

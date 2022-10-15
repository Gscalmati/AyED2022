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
		return (conseguirMaximo(this.ab));
		
	}

	private int conseguirMaximo(ArbolBinario<Integer> unArbol) {
		int max = 0;
		int m1 = 0;
		int m2 = 0;
		if (!unArbol.esVacio()) {
			if (unArbol.tieneHijoIzquierdo()) {
				m1 = conseguirMaximo(unArbol.getHijoIzquierdo());
			}
			if (unArbol.tieneHijoDerecho()) {
				m2 = conseguirMaximo(unArbol.getHijoDerecho());
			}
			max = Math.max(m1, m2) + unArbol.getDato();
		}
		return max;
	}

}

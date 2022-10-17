package parcial1510;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio2.ArbolBinario;

public class Parcial {

	public ListaGenerica<Integer> resolver (ArbolBinario<Integer> ab, int min){
		ListaGenerica<Integer> actual = new ListaEnlazadaGenerica <Integer>();
		Integer pares = 0;
		Resultado resul = new Resultado();
		
		this.recursion (ab, resul, actual, min, pares);
		return resul.getMejorCamino();
	}

	private boolean recursion(ArbolBinario<Integer> ab, Resultado resul, ListaGenerica<Integer> actual, int min, Integer pares) {
		// TODO Auto-generated method stub
		boolean encontrado = false;
		
		if (!ab.esVacio()) {
			
			actual.agregarFinal(ab.getDato());
			if (ab.getDato() % 2 == 0) {
				pares++;
			}
			
			if (!ab.esHoja()) {
				if (ab.tieneHijoIzquierdo() && !encontrado) {
					encontrado = this.recursion(ab.getHijoIzquierdo(), resul, actual, min, pares);
				}
				if (ab.tieneHijoDerecho() && !encontrado) {
					encontrado = this.recursion(ab.getHijoDerecho(), resul, actual, min, pares);
				}
			} else {
				if (pares >= min) {
					encontrado = true;
					resul.setMejorCamino(actual.clonar());
				}
			}
		}
		actual.eliminarEn(actual.tamanio());
		
		return encontrado;
	}
}

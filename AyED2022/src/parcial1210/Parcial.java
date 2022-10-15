package parcial1210;

import tp03.ejercicio2.ArbolBinario;

public class Parcial {
	
	
	public Integer resolver (ArbolBinario <Integer> ab) {
		Integer suma = 0;
		//Solo opero si el Ab NO esVacio
		if (!ab.esVacio()) {			
			//Reviso hijos primero al ser Post-Orden, y le asigno el valor a Suma
			// así voy guardando lo que viene de los niveles inferiores del arbol
			if (ab.tieneHijoIzquierdo()) {
				suma = suma + resolver(ab.getHijoIzquierdo());
			}
			if (ab.tieneHijoDerecho()) {
				suma = suma + resolver(ab.getHijoDerecho());
			}
			// El nodo si es Hoja y es Impar, se resta, sino, si no es Hoja y es Par se suma a "SUMA"
			if (ab.esHoja() && ab.getDato() % 2 == 1) {
				suma = suma - ab.getDato();
			} else {
				if (!ab.esHoja() && ab.getDato() % 2 == 0) {
					suma = suma + ab.getDato();
				}
			}
		}
		//Devuelvo suma
		return suma;
	}
}

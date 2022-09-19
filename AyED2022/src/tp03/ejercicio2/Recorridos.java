package tp03.ejercicio2;

import tp02.ejercicio2.*;


public class Recorridos {
	
	public void preOrder (ArbolBinario <Integer> arbol) {
		if (!arbol.esVacio()) {
			
			System.out.print(arbol.getDato() + " ");
			
			if (arbol.tieneHijoIzquierdo()) {
				preOrder(arbol.getHijoIzquierdo());
			}
			
			if (arbol.tieneHijoDerecho()) {
				preOrder(arbol.getHijoDerecho());
			}
		}
	}
	
	public void inOrder (ArbolBinario <Integer> arbol) {
		if (!arbol.esVacio()) {
			
			
			
			if (arbol.tieneHijoIzquierdo()) {
				inOrder(arbol.getHijoIzquierdo());
			}
			
			System.out.println(arbol.getDato());
			
			if (arbol.tieneHijoDerecho()) {
				inOrder(arbol.getHijoDerecho());
			}
		}
	}
	
	public void postOrden (ArbolBinario <Integer> arbol) {
		if (!arbol.esVacio()) {
			if (arbol.tieneHijoIzquierdo()) {
				postOrden(arbol.getHijoIzquierdo());
			}
			
			if (arbol.tieneHijoDerecho()) {
				postOrden(arbol.getHijoDerecho());
			}
			
			System.out.println(arbol.getDato());
		}
	}
	
	public void porNiveles (ArbolBinario <Integer> ab) {
		//Usando una COLA, Encolo Arbol entero
		ColaGenerica <ArbolBinario <Integer>> cola = new ColaGenerica <ArbolBinario <Integer>>();
		cola.encolar(ab);
		// Encolamos un NULL para CAMBIO DE NIVEL
		cola.encolar(null);
		int nivel = 1;
		System.out.println("Nivel " + nivel);
		
		
		//	MIENTRAS HAYA COSAS EN LA COLA
		while (!cola.esVacia()) {
			//Saco de la cola en var SUBARBOL, proceso
			ArbolBinario<Integer> subArbol = cola.desencolar();
			
			// Reviso si es NULL o OBJETO, si es OBJETO, proceso
			if (subArbol != null) {
			
				System.out.println(subArbol.getDato());
				//Tiene HI, lo encolo
				if (subArbol.tieneHijoIzquierdo()) {
					cola.encolar(subArbol.getHijoIzquierdo());
				}
				//Tiene HD, lo encolo
				if (subArbol.tieneHijoDerecho()) {
					cola.encolar(subArbol.getHijoDerecho());
				}
			}  else { // en cambio si es NULL
				// Pregunto si ESTA VACIA, para que no itere con nulls infinitamente
				if (!cola.esVacia()) {	//Si NO esta vacia, le encolamos null
					cola.encolar(null);		
					//NO ES LO MISMO VACIA, QUE TENER NULLS
					nivel++;
					System.out.println("Nivel " + nivel);
				}
			}
		}
		//	FIN MIENTRAS
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	// Ejercicios de SubArboles...podemos tratar los nodos como "Subarboles" y los subarboles pueden tener 0,1 o 2 hijos, de ahi vemos que devolvemos

}

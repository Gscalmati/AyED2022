package tp04.ejercicio1;

import tp02.ejercicio2.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos == null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos == null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}

	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}

	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo))
				hijos.eliminar(hijo);
		}
	}

	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}

	//Recursivo, lo mas util
	public Integer altura() {

		return this.extraerAltura(this);
	}

	private Integer extraerAltura(ArbolGeneral<T> ag) {
		Integer alturaAct = 0;
		// Si el arbol es Vacio, la altura es 0;
		if (this.esVacio()) {
			return alturaAct;
		} else {
			//Si NO está vacío, recorro sus hijos, de tenerlos
			if (ag.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> hijos = ag.getHijos();
				hijos.comenzar();

				//Me quedo con la altura maxima entre todos los hijos
				Integer altAux = 0;
				while (!hijos.fin()) {
					altAux = Math.max(altAux, hijos.proximo().altura());
				}
				//Sumo 1 a la altura actual, y le sumo la altura Max de los hijos
				alturaAct++;
				alturaAct = alturaAct + altAux;
			}
		}
		return alturaAct;
	}

	//Recursivo es mas dificil, por niveles rinde mas, pq si o si tenes que buscar en tooooodo el arbol
	public Integer nivel(T dato) {
		if (this.esVacio()) {
			return -1;
		}
		return this.buscarDato (this, dato);
	}
	
	private Integer buscarDato (ArbolGeneral<T> ag, T dato) {
		
		Integer nivel = 0;
		
		if (!ag.esVacio()) {
			
			if (ag.tieneHijos() && nivel == 0) {
				ListaGenerica <ArbolGeneral<T>> hijos = ag.getHijos();
				hijos.comenzar();
				nivel = this.buscarDato(hijos.proximo(), dato);
			}
			
			
			if (ag.getDato() == dato) {
				nivel = 1;
			} else {
				if (nivel >= 1) {
					nivel ++;
				}
			}
		}
		return nivel;
	}

	//Por niveles es mas comodo
	public Integer ancho() {
		Integer anchoArbol = 0;
		Integer alturaAux = 0;
		if (!this.esVacio()) {
			// Si el arbol tiene hijos, me quedo con su ancho
			if (this.tieneHijos()) {
				alturaAux = this.hijos.tamanio();
				// Recorro sus hijos comparando el Maximo entre el anchoArbol y sus hijos, y me
				// quedo con el mayor
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					alturaAux += hijos.proximo().ancho();
				}
			}
			if (alturaAux > anchoArbol) {
				anchoArbol = alturaAux;
			}

		}
		return anchoArbol;
	}

	// --------------------------------------------------------------------------------//

	public ListaGenerica<T> numerosImparesMayorQuePreOrden(ArbolGeneral<T> arbol, Integer m) {

		ListaGenerica<T> lista = new ListaEnlazadaGenerica<T>();

		this.recursionPreOrden(arbol, m, lista);

		return lista;

	}

	private void recursionPreOrden(ArbolGeneral<T> arbol, Integer m, ListaGenerica<T> lista) {

		if (!arbol.esVacio()) {

			if (arbol.getDato() % 2 == 1) {
				lista.agregarFinal(arbol.getDato());
			}

			ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();

			hijos.comenzar();

			while (!hijos.fin()) {
				this.recursionPreOrden(hijos.proximo(), m, lista);
			}
		}

	}

	// ------------------------------------------------------------------------------------------------------------//

	public ListaGenerica<T> numerosImparesMayorQueInOrden(ArbolGeneral<T> arbol, Integer m) {

		ListaGenerica<T> lista = new ListaEnlazadaGenerica<T>();

		this.recursionInOrden(arbol, m, lista);

		return lista;

	}

	private void recursionInOrden(ArbolGeneral<T> arbol, Integer m, ListaGenerica<T> lista) {

		if (!arbol.esVacio()) {

			ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();

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

	// ------------------------------------------------------------------------------------------------------------//

	public ListaGenerica<T> numerosImparesMayorQuePostOrden(ArbolGeneral<T> arbol, Integer m) {

		ListaGenerica<T> lista = new ListaEnlazadaGenerica<T>();

		this.recursionPostOrden(arbol, m, lista);

		return lista;

	}

	private void recursionPostOrden(ArbolGeneral<T> arbol, Integer m, ListaGenerica<T> lista) {

		if (!arbol.esVacio()) {

			ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();

			hijos.comenzar();

			while (!hijos.fin()) {
				this.recursionPostOrden(hijos.proximo(), m, lista);
			}

			if (arbol.getDato() % 2 == 1) {
				lista.agregarFinal(arbol.getDato());
			}

		}

	}

	// ------------------------------------------------------------------------------------------------------------//

	public ListaGenerica<T> numerosImparesMayorQuePorNiveles(ArbolGeneral<T> arbol, Integer m) {

		ListaGenerica<T> listaImpares = new ListaEnlazadaGenerica<T>();

		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		cola.encolar(arbol);
		cola.encolar(null);
		int nivel = 1;
		System.out.println("Nivel " + nivel);

		while (!cola.esVacia()) {
			ArbolGeneral<T> subArbol = cola.desencolar();

			// Si el SUBARBOL no es Null, imprimimos dato y recorremos hijos
			if (subArbol != null) {
				if (subArbol.getDato() % 2 == 1) {
					listaImpares.agregarFinal(subArbol.getDato());
				}

				// Si tiene hijos, los encolamos
				if (subArbol.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos = subArbol.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}

			} else { // Si el SUBARBOL es Null, encolamos otro Null si quedan elementos en la COLA y
						// subimos de Nivel

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
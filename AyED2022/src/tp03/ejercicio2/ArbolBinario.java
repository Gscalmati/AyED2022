package tp03.ejercicio2;

import tp02.ejercicio2.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoDerecho()
	 * @return
	 */

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas() {
		int cantHojas = 0;
		
		if (!this.esVacio()) {
			if (this.esHoja()) {
				return 1;
			} else {
				if (this.tieneHijoIzquierdo()) {
					cantHojas = cantHojas + (this.getHijoIzquierdo().contarHojas());
				}
				if (this.tieneHijoDerecho()) {
					cantHojas = cantHojas + (this.getHijoDerecho().contarHojas());
				}
			}
				
		}
		return cantHojas;
	}
	

    public ArbolBinario<T> espejo() {
    	ArbolBinario<T> espejado = new ArbolBinario<T>();
    	espejado.setDato(this.getDato());
    	
    	if (this.tieneHijoIzquierdo()) {
    		espejado.agregarHijoDerecho(this.getHijoIzquierdo());
    	}
    	if (this.tieneHijoDerecho()) {
    		espejado.agregarHijoIzquierdo(this.getHijoDerecho());
    	}
		return espejado;
	}


	public void entreNiveles(int n, int m){
		
				//Usando un COLA, Encolo Arbol entero
				ColaGenerica <ArbolBinario <T>> cola = new ColaGenerica <ArbolBinario <T>>();
				cola.encolar(this);
				// Encolamos un NULL para CAMBIO DE NIVEL
				cola.encolar(null);
				
				int nivel = 1;
				
				
				//	MIENTRAS HAYA COSAS EN LA COLA
				while (!cola.esVacia()) {
					//Saco de la cola en var SUBARBOL, proceso
					
						ArbolBinario<T> subArbol = cola.desencolar();
					
					// Reviso si es NULL o OBJETO, si es OBJETO, proceso
					if (subArbol != null) {
					
						if ((n <= nivel) && (nivel <= m)) {
							System.out.println(subArbol.getDato());
						}
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
						}
					}
				}
				//	FIN MIENTRAS
			}
	
	
	//-----------------------------------------------------------------------------------------------------------
		// BUSCAR EL CAMINO MAS EXTENSO
		public ListaEnlazadaGenerica <T> caminoMasLargo () {
			
			ListaEnlazadaGenerica <T> actual = new ListaEnlazadaGenerica <T> ();
			ListaEnlazadaGenerica <T> max = new ListaEnlazadaGenerica <T> ();
			Integer cantA = 0;
			Integer [] cantM = {0}; 
			this.recursion(actual, max, this, cantA, cantM);
			
			return max;
		}
		
		private void recursion (ListaEnlazadaGenerica <T> actual, ListaEnlazadaGenerica <T> maximo, ArbolBinario <T> arbol, Integer cantParActual, Integer [] cantParMax) {
			if (!arbol.esVacio()) {
				actual.agregarFinal(arbol.getDato());
				if (!arbol.esHoja()) {
					if (arbol.tieneHijoIzquierdo()) {
						this.recursion(actual, maximo, arbol.getHijoIzquierdo(), cantParActual, cantParMax);
					}
					if (arbol.tieneHijoDerecho()) {
						this.recursion(actual, maximo, arbol.getHijoDerecho(), cantParActual, cantParMax);
					}
				} else {
					if (actual.tamanio() > maximo.tamanio()) {
						this.copiarListas(maximo, actual);
					} else {
						if (actual.tamanio() == maximo.tamanio()) {
							if (cantParActual > cantParMax[0]) {
								this.copiarListas(maximo, actual);
								cantParMax[0] = cantParActual;
								//O Hago una clase "Resultado con 2 var. instancias: la lista, y el contador de pares"
								
							}
							
						}
					}
				}
				
				actual.eliminarEn(actual.tamanio());
				//No es necesario decrementar cantParActual ya que muere al final de la ejecucion
			}
		}

		private void copiarListas(ListaEnlazadaGenerica<T> maximo, ListaEnlazadaGenerica<T> actual) {
			maximo.comenzar();
			while (!maximo.fin()){
				maximo.elemento(1);
				maximo.proximo();
			}
			actual.comenzar();
			while (!actual.fin()) {
				maximo.agregarFinal(actual.proximo());
			}
		}


	

}

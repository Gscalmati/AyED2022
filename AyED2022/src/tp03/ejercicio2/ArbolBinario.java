package tp03.ejercicio2;

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
				ColaGenerica <ArbolBinario <Integer>> cola = new ColaGenerica <ArbolBinario <Integer>>();
				cola.encolar(ab);
				// Encolamos un NULL para CAMBIO DE NIVEL
				cola.encolar(null);
				
				
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
						}
					}
				}
				//	FIN MIENTRAS
			}


	

}

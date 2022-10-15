package tp02.ejercicio2;

public class ColaGenerica <T> {
	
	private ListaGenerica <T> datos;
	
	public ColaGenerica () {
		
		this.datos = new ListaEnlazadaGenerica <T>();
	}
	
	public void encolar (T datoT) {
		
		this.datos.agregarFinal(datoT);
		
	}
	
	public T desencolar () {
		
		T nodo = null;
		
		if (!this.datos.esVacia()) {
			
			nodo = this.datos.elemento(1);
			
			this.datos.eliminarEn(1);
			
		}
		
		return nodo;
		
		
	}
	
	public T tope () {
		
		T nodo = null;
		
		if (!this.datos.esVacia()) {
			
			nodo = this.datos.elemento(this.datos.tamanio());
		}
		
		return nodo;
	}
	
	public boolean esVacia() {
		return (this.datos.esVacia());
	}
	
	

}

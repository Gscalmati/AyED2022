package tp02.ejercicio2;

public class PilaGenerica <T>{
	
	private ListaGenerica <T> datos;
	
public PilaGenerica () {
		
		this.datos = new ListaEnlazadaGenerica <T>();
	}
	
	public void apilar (T datoT) {
		
		this.datos.agregarInicio(datoT);
		
	}
	
	public T desapilar () {
		
		T nodo = null;
		
		if (!this.datos.esVacia()) {
			
			nodo = this.datos.elemento(1);
			
			this.datos.eliminar(nodo);
			
		}
		
		return nodo;
		
		
	}
	
	public T tope () {
		
		T nodo = null;
		
		if (!this.datos.esVacia()) {
			
			nodo = this.datos.elemento(1);
		}
		
		return nodo;
	}
	
	public boolean esVacia() {
		return (this.datos.esVacia());
	}
	
	

}


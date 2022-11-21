package tp06.ejercicio6;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ResultadoOslo {

	ListaGenerica <String> camino;
	int tiempo;
	
	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public ResultadoOslo () {
		this.camino = new ListaEnlazadaGenerica<String>();
		this.tiempo = 0;
	}

	public ListaGenerica<String> getCamino() {
		return camino;
	}

	public void setCamino(ListaGenerica<String> camino) {
		this.camino = camino;
	}
	
	
	
	
}

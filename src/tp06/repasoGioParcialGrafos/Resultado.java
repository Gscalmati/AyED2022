package tp06.repasoGioParcialGrafos;

import tp02.ejercicio2.*;

public class Resultado {

	private ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
	private Integer distancia = Integer.MAX_VALUE;
	
	public Resultado () {}

	public ListaGenerica<String> getCamino() {
		return camino;
	}

	public void setCamino(ListaGenerica<String> camino) {
		this.camino = camino;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	};
	
}

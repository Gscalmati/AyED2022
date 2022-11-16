package tp06.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class Resultado {
	
	private Integer cantVert = 0;
	private ListaEnlazadaGenerica<String> mejorCamino;
	
	public Integer getCantVert() {
		return cantVert;
	}
	public void setCantVert(Integer cantVert) {
		this.cantVert = cantVert;
	}
	public ListaEnlazadaGenerica<String> getMejorCamino() {
		return mejorCamino;
	}
	public void setMejorCamino(ListaEnlazadaGenerica<String> mejorCamino) {
		this.mejorCamino = mejorCamino;
	}
	

	

}

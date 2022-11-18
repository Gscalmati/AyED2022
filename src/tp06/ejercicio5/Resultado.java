package tp06.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class Resultado {
	
	private double cantKms = Double.MAX_VALUE;
	private ListaGenerica<String> mejorCamino;
	
	public Resultado () {
		this.mejorCamino = new ListaEnlazadaGenerica<String> ();
	}
	
	public Double getCantKms() {
		return cantKms;
	}
	public void setCantKms(Double cantVert) {
		this.cantKms = cantVert;
	}
	public ListaGenerica<String> getMejorCamino() {
		return mejorCamino;
	}
	public void setMejorCamino(ListaGenerica<String> mejorCamino) {
		this.mejorCamino = mejorCamino;
	}
	

	

}

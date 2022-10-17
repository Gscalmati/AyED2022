package parcial1510;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class Resultado {

	private ListaGenerica<Integer> mejorCamino;
	
	public Resultado (){
		this.mejorCamino = new ListaEnlazadaGenerica <Integer> ();
	}

	public ListaGenerica<Integer> getMejorCamino() {
		return mejorCamino;
	}

	public void setMejorCamino(ListaGenerica<Integer> mejorCamino) {
		this.mejorCamino = mejorCamino;
	}
	
	
}

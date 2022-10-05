package tp04.clase5Oct;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class Resultado {
	
	private float resultado;
	private ListaEnlazadaGenerica<Float> mejorCamino;
	private float promedioMaximo;
	
	public float getResultado() {
		return resultado;
	}
	public void setResultado(float resultado) {
		this.resultado = resultado;
	}
	public ListaEnlazadaGenerica<Float> getMejorCamino() {
		return mejorCamino;
	}
	public void setMejorCamino(ListaEnlazadaGenerica<Float> listaGenerica) {
		this.mejorCamino = listaGenerica;
	}
	public float getPromedioMaximo() {
		return promedioMaximo;
	}
	public void setPromedioMaximo(float promedioMaximo) {
		this.promedioMaximo = promedioMaximo;
	}
	
	

}

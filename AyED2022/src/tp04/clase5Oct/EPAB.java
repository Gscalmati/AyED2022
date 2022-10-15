package tp04.clase5Oct;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class EPAB {

	
	
		public ListaGenerica<Float> mejorCaminoEntreTodos (ArbolGeneral <Float> ag) {
			Resultado resultado = new Resultado ();
			ListaEnlazadaGenerica <Float> actual = new ListaEnlazadaGenerica<Float>();
			this.recursion(resultado, ag, actual, 0.0);
			
			return resultado.getMejorCamino();
		}
		
		public void recursion (Resultado resultado, 
				ArbolGeneral<Float> ag, 
				ListaEnlazadaGenerica <Float> actual, 
				double suma) {
			
			if (!ag.esVacio()) {
				suma += ag.getDato();
				actual.agregarFinal(ag.getDato());
				
				if (ag.tieneHijos()) {
					ListaGenerica <ArbolGeneral<Float>> hijos = ag.getHijos();
					hijos.comenzar();
					this.recursion(resultado, hijos.proximo(), actual, suma);
				}
			}
			
			if (ag.esHoja()) {
				Float promedio = (float) (suma / actual.tamanio());
				if (promedio > resultado.getPromedioMaximo()) {
					resultado.setPromedioMaximo(promedio);
					resultado.setMejorCamino((ListaEnlazadaGenerica<Float>) actual.clonar());
				}
			}
			
			actual.eliminarEn(actual.tamanio());
		}
		
		//----------------------------------------------------------------------------------------------//
		
		public ListaGenerica<Float> primerCaminoMejorDelPromedio (ArbolGeneral <Float> ag) {
			Resultado resultado = new Resultado ();
			ListaEnlazadaGenerica <Float> actual = new ListaEnlazadaGenerica<Float>();
			this.recursionPromedio(resultado, ag, actual, 0.0, 7);
			
			return resultado.getMejorCamino();
		}
		
		public boolean recursionPromedio (Resultado resultado, 
				ArbolGeneral<Float> ag, ListaEnlazadaGenerica <Float> actual, 
				double suma, double promedioMin) {
			
			boolean encontrado = false;
			
			if (!ag.esVacio()) {
				suma += ag.getDato();
				actual.agregarFinal(ag.getDato());
				
				if (ag.tieneHijos() && !encontrado) {
					ListaGenerica <ArbolGeneral<Float>> hijos = ag.getHijos();
					hijos.comenzar();
					encontrado = this.recursionPromedio(resultado, hijos.proximo(), actual, suma, promedioMin);
				}
			}
			
			if (ag.esHoja()) {
				Float promedio = (float) (suma / actual.tamanio());
				if (promedio >= promedioMin) {
					//resultado.setPromedioMaximo(promedio);
					resultado.setMejorCamino((ListaEnlazadaGenerica<Float>) actual.clonar());
				}
			}
			
			actual.eliminarEn(actual.tamanio());
			return encontrado;
		}
}

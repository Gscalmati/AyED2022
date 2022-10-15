package tp04.ejercicio7;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RedAguaPotable {
	
	private ArbolGeneral<String> red;
	
	
	
	public ArbolGeneral<String> getRed() {
		return red;
	}

	public void setRed(ArbolGeneral<String> red) {
		this.red = red;
	}

	public double minimoCaudal (double caudalTotal) {
		double caudalMinimo = 0;
		
		caudalMinimo = this.recorroArbol (this.red, caudalTotal);
		
		return caudalMinimo;
	}

	private double recorroArbol(ArbolGeneral<String> subArbol, double caudalTotal) {
		// TODO Auto-generated method stub
		double caudalMin = 9999999;
		double caudalDiv;
		double caudalAux = 0;
		if (!subArbol.esVacio()) {
			//System.out.println ("Caudal Total:" + subArbol.getDato() + " " + caudalTotal);
			if (subArbol.esHoja()) {
				caudalMin = caudalTotal;
			} else {
					caudalDiv = (caudalTotal / subArbol.getHijos().tamanio());
					//System.out.println ("Caudal Div:" + caudalDiv);
					ListaGenerica<ArbolGeneral<String>> hijos = subArbol.getHijos();
					
					while (!hijos.fin()) {
						caudalAux = this.recorroArbol(hijos.proximo(), caudalDiv);
						//System.out.println ("FIN RECURSION");
						if (caudalAux < caudalMin) {
							caudalMin = caudalAux;
						}
								
					}
			}
			
			
		}
		//System.out.println ("Caudal Min:" + subArbol.getDato() + " " + caudalMin);
		//System.out.println ("-------------------------------------------------");
		return caudalMin;	
	}

}

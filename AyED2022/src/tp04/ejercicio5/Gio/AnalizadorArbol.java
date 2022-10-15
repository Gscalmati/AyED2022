package tp04.ejercicio5.Gio;

import tp02.ejercicio2.ColaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class AnalizadorArbol {

	
	public int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa> arbol) {
		
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>> ();
		
		cola.encolar(arbol);
		cola.encolar(null);
		
		//int nivel = 0;
		//int nivelMax;
		
		int promedioMax = 0;
		int promedioActual = 0;
		int cantNodos = 0;
		
		while (!cola.esVacia()){
			ArbolGeneral<AreaEmpresa> subArbol = cola.desencolar();
			
			if (subArbol != null) {
				
				System.out.println(subArbol.getDato().getRetardo());
				
				promedioActual += subArbol.getDato().getRetardo();
				cantNodos ++;
				
				ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = subArbol.getHijos();
				
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			} else {
				promedioActual = promedioActual / cantNodos;
				if (promedioActual > promedioMax) {
					promedioMax = promedioActual;
					//nivelMax = nivel;
				}
				
				//nivel++;
				cantNodos = 0;
				promedioActual = 0;
				
				if (!cola.esVacia()) {
					cola.encolar(null);
				}
			}
		}
		return promedioMax;
	}
	
}

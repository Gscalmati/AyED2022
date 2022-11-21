package tp06.ejercicio6;

import tp02.ejercicio2.*;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class VisitaOslo {
	
	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo,
			ListaGenerica<String> lugaresRestringidos) {
		
		ResultadoOslo resul = new ResultadoOslo ();
		
		
		Vertice <String> vertice = buscarCiudad(lugares, "Ayuntamiento");
		
		if (vertice != null) {
			ListaGenerica<String> temporal = new ListaEnlazadaGenerica <String> ();
			boolean [] visitados = new boolean [lugares.listaDeVertices().tamanio()];
			int tiempoAct = 0;
			this.recorridoRecursivo (resul, lugares, visitados, vertice, destino, maxTiempo, lugaresRestringidos, temporal, tiempoAct);
		}
		
		System.out.println("-------------------");
		System.out.println(resul.getTiempo());
		System.out.println("-------------------");
		return resul.getCamino();
		
	}

	private void recorridoRecursivo(ResultadoOslo resul, 
			Grafo<String> lugares, 
			boolean [] visitados,
			Vertice<String> vertice, 
			String destino,
			int maxTiempo, 
			ListaGenerica<String> lugaresRestringidos,
			ListaGenerica<String> temporal,
			int tiempoAct) {
		
		
		visitados[vertice.getPosicion()-1] = true;
		temporal.agregarFinal(vertice.dato());
		
		if (!vertice.dato().equals(destino)) {
			
			ListaGenerica<Arista<String>> aristas = lugares.listaDeAdyacentes(vertice);
			aristas.comenzar();
			
			while (!aristas.fin()) {
				Arista<String> arista = aristas.proximo();
				Vertice<String> vDestino = arista.verticeDestino();
				//Que forma es mejor???
				int tiempoNuevo = tiempoAct + arista.peso();
				if ((/*tiempoAct + arista.peso()*/ tiempoNuevo <= maxTiempo) && !visitados[vDestino.getPosicion()-1] && (!lugarRestringido(vDestino, lugaresRestringidos))) {
					//int tiempoNuevo = tiempoAct + arista.peso();
					System.out.println(tiempoNuevo);
					this.recorridoRecursivo(resul, lugares, visitados, vDestino, destino, maxTiempo, lugaresRestringidos, temporal, tiempoNuevo);
				}
			}
			
			
		} else {
			resul.setTiempo(tiempoAct);
			resul.setCamino(temporal.clonar());
			
		}
		
		temporal.eliminarEn(temporal.tamanio());
		
	}

	private boolean lugarRestringido(Vertice<String> vDestino, ListaGenerica<String> lugaresRestringidos) {
		boolean esRestringido = false;
		lugaresRestringidos.comenzar();
		
		while (!lugaresRestringidos.fin()) {
			if(vDestino.dato().equals(lugaresRestringidos.proximo())) {
				esRestringido = true;
				break;
			}
		}
		return esRestringido;
	}

	private Vertice<String> buscarCiudad(Grafo<String> lugares, String destino) {
		Vertice<String> vActual = null;
		ListaGenerica<Vertice<String>> vertices = lugares.listaDeVertices();
		
		vertices.comenzar();
		while (!vertices.fin()) {
			vActual = vertices.proximo();
			if (vActual.dato().equals(destino)) {
				break;
			}
		}
		
		return vActual;
	}

}

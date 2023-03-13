package tp06.repasoGioParcialGrafos;

import tp02.ejercicio2.*;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {
	
	public ListaGenerica<String> encontrarCaminoMenosDistancia (Grafo<String> grafo, String origen, String destino, ListaGenerica<String> exentos) {
		ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
		vertices.comenzar();
		
		Resultado resul = new Resultado();
		
		Vertice<String> aux = null;
		
		while (!vertices.fin()) {
			aux = vertices.proximo();
			if (aux.dato().equals(origen)) {
				break;
			}
		}
		
		if (aux != null) {
			ListaGenerica<String> temporal = new ListaEnlazadaGenerica<String>();
			boolean [] visitados = new boolean [vertices.tamanio()];
			Integer peso = 0;
			camino_private(grafo, destino, aux, visitados, temporal, peso, exentos, resul);
		}
	
		
		return resul.getCamino();
	}

	private void camino_private(Grafo<String> grafo, String destino, Vertice<String> vertice, boolean[] visitados,
			ListaGenerica<String> temporal, Integer peso, ListaGenerica<String> exentos, Resultado resul) {
		
		
		visitados[vertice.getPosicion()-1] = true;
		temporal.agregarFinal(vertice.dato());
		
		if (!vertice.dato().equals(destino)) {
			
			ListaGenerica<Arista<String>> aristas = grafo.listaDeAdyacentes(vertice);
			aristas.comenzar();
			while(!aristas.fin()) {
				Arista<String> arista = aristas.proximo();
				Vertice<String> vDestino = arista.verticeDestino();
				peso = peso + arista.peso();
				
				if (!visitados[vDestino.getPosicion()-1] && destinoHabilitado(vDestino,exentos)) {
					this.camino_private(grafo, destino, vDestino, visitados, temporal, peso, exentos, resul);
				}
			}
			
		} else {
			if (peso < resul.getDistancia()) {
				System.out.println("CAMBIO CAMINO, PESO ACTUAL " + resul.getDistancia() + ", PESO NUEVO " + peso);
				resul.setCamino(temporal.clonar());
				resul.setDistancia(peso);
			}
		}
		
		visitados[vertice.getPosicion()-1] = false;
		temporal.eliminarEn(temporal.tamanio());
	}
	
	

	private boolean destinoHabilitado(Vertice<String> vDestino, ListaGenerica<String> exentos) {
		boolean respuesta = true;
			if (exentos != null) {
		exentos.comenzar();
		while (!exentos.fin()) {
			if (exentos.proximo().equals(vDestino.dato())){
				respuesta = false;
				break;
			}
		}
	}
		return respuesta;
	}

}

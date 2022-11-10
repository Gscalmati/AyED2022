package tp06.clase911;

import tp02.ejercicio2.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class EP <T>{

	public <T> void dfs (Grafo <T> grafo, T dato) {
		
		// Buscar el vértice que tiene el dato
		Vertice <T> vertice = null;
		ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
		
		//Iniciamos el arreglo de booleanos, de visitados, EN FALSE
		boolean [] visitados = new boolean [grafo.listaDeVertices().tamanio()];
		
		vertices.comenzar();
		while (!vertices.fin()) {
			vertice = vertices.proximo();
			if (vertice.dato().equals(dato)) {
				break;
			}
		}
		if (vertice != null) {
			this.dfs_private(grafo, vertice, visitados);
		}
	}

	private void dfs_private(Grafo<T> grafo, Vertice<T> vertice, boolean [] visitados) {
		// Marcamos que visitamos el vertice
		visitados[vertice.getPosicion()] = true;
		
		// Procesar el dato
		System.out.println(vertice.dato());
		// Llamo recursivamente
		ListaGenerica<Arista<T>> aristas = grafo.listaDeAdyacentes(vertice);
		// Itero la lista de aristas, para llamar recursivamente
		aristas.comenzar();
		while (!aristas.fin()) {
			Arista<T> arista = aristas.proximo();
			Vertice<T> vDestino = arista.verticeDestino();
			// Si el vertice destino NO ESTA VISITADO, lo invoco recursivamente
			if (visitados[vDestino.getPosicion()] == false) {
				this.dfs_private(grafo, vDestino, visitados);
			}
			
		}	
		
		// Desmarcamos que visitamos el vertice
				visitados[vertice.getPosicion()] = false;
	}
	
	//------------------------------------------------------------------//
	
	public void bfs (Grafo <T> grafo, T dato) {
		
		//busco vertice llamo iterativente a BFS_private
		// Buscar el vértice que tiene el dato
		Vertice <T> vertice = null;
		ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
				
		//Iniciamos el arreglo de booleanos, de visitados, EN FALSE
		boolean [] visitados = new boolean [grafo.listaDeVertices().tamanio()];
				
		vertices.comenzar();
		while (!vertices.fin()) {
			vertice = vertices.proximo();
			if (vertice.dato().equals(dato)) {
				break;
			}
		}
		if (vertice != null) {
			this.bfs_private(grafo, vertice, visitados);
		}
		
		
	}
	
	
	public void bfs_private (Grafo<T> grafo, Vertice<T> vertice, boolean[] visitados) {
		
		// Marco vertice como VISITADO
		visitados[vertice.getPosicion()] = true;
		// Agarro el vertice, lo encolo
		ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>> ();
		cola.encolar(vertice);
		// Encolo null
		cola.encolar(null);
		// Mientras la cola este con cosas
		while (!cola.esVacia()) {
			//Desencolo
			Vertice<T> aux = cola.desencolar();
			//Si es vertice
			if (aux != null) {
				//Proceso
				System.out.println(aux.dato());
				//Agarro hijos, itero
				ListaGenerica<Arista<T>> aristas = grafo.listaDeAdyacentes(vertice);
				// Itero la lista de aristas, para encolar
				aristas.comenzar();
				while (!aristas.fin()) {
					Arista<T> arista = aristas.proximo();
					Vertice<T> vDestino = arista.verticeDestino();
					// Si el vertice destino NO ESTA VISITADO, lo MARCO, y lo encolo
					if (visitados[vDestino.getPosicion()] == false) {
						visitados[vertice.getPosicion()] = true;
						cola.encolar(vDestino);
					}
				}
			} else {
				//Agrego null
				if (!cola.esVacia()) {
					cola.encolar(null);
				} 
			}
		} 
			
			
			
		// Faltaria desmarcar, como? Lo vemos la proxima clase		
		
		
		
	}
	
	
}

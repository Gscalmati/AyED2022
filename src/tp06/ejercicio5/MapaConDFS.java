package tp06.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;

public class MapaConDFS {
	private Grafo<String> mapaCiudades;
	
	public MapaConDFS () {
		this.mapaCiudades = new GrafoImplListAdy<String> ();
	}
	
	public ListaGenerica<String> devolverCamino (String ciudad1, String ciudad2) {
		Resultado resul = new Resultado ();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String> ();
		ListaGenerica<String> temporal = new ListaEnlazadaGenerica<String> ();
		boolean [] visitados = new boolean [this.mapaCiudades.listaDeVertices().tamanio()+1];
		System.out.println(this.mapaCiudades.listaDeVertices().tamanio());
		
		ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
	
		vertices.comenzar();
		Vertice <String> vertice = null;
		while (!vertices.fin()) {
			vertice = vertices.proximo();

			if (vertice.dato().equals(ciudad1)) {
				break;
			}
		}

		if (vertice != null) {
			
			
			this.dfs_private_primerCaminoPosible(this.mapaCiudades, vertice, visitados, ciudad2, camino, temporal);
		}
		
		return camino;
	}
	
	public void dfs_private_primerCaminoPosible (Grafo<String> grafo, 
			Vertice<String> vertice, 
			boolean [] visitados, 
			String datoB,
			ListaGenerica<String> camino, 
			ListaGenerica<String> temporal) {
	
	visitados[vertice.getPosicion()] = true;
	temporal.agregarFinal(vertice.dato());


	if (vertice.dato().equals(datoB)) {
		// Limpio la lista camino
		camino.comenzar();
		while (!camino.fin()) {
			camino.eliminarEn(camino.tamanio());
			camino.proximo();
		}
		// Asigno los valores de temporal a camino
		temporal.comenzar();
		while (!temporal.fin()) {
			camino.agregarFinal(temporal.proximo());
		}
		
		
	} else {
		//Llamamos recursivamente
		ListaGenerica<Arista<String>> aristas = grafo.listaDeAdyacentes(vertice);
		aristas.comenzar();
		while (!aristas.fin()) {
			Arista <String> arista = aristas.proximo();
			Vertice <String> verticeD = arista.verticeDestino();
			
			if (visitados[verticeD.getPosicion()] == false) {

				this.dfs_private_primerCaminoPosible (grafo, verticeD, visitados, datoB, camino, temporal);
			}
		}
		
	}
	// El desmarque lo hacemos para encontrar MULTIPLES CAMINOS, si es para encontrar 1 camino solo, No seria necesario
			//visitados[vertice.getPosicion()] = false;
		temporal.eliminarEn(temporal.tamanio());
}

	public void setMapaCiudades(Grafo<String> grafo) {
		// TODO Auto-generated method stub
		this.mapaCiudades = grafo;
		
	}
}

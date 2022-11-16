package tp06.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;

public class Mapa {
	private Grafo<String> mapaCiudades;
	
	public Mapa () {
		this.mapaCiudades = new GrafoImplListAdy<String> ();
	}
	
	public ListaGenerica<String> devolverCamino (String ciudad1, String ciudad2) {
		Resultado resul = new Resultado ();
		
		
		
		// Sacar lista de vertices para encontrar la C1
		ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
		// Recorrer buscando si C1 existe
		vertices.comenzar();
		Vertice <String> vertice = null;
		while (!vertices.fin()) {
			vertice = vertices.proximo();
			// Si encuentro el V con esa Ciudad, salgo del while
			if (vertice.dato().equals(ciudad1)) {
				break;
			}
		}
		// Si encontré algo en el while, llamo a CaminoRecursion que me hace el camino
		if (vertice != null) {
			// Lo que suma la cantidad de Vertices visitados
			Integer sumaVert = 0;
			// Iniciamos actual
			ListaGenerica<String> actual = new ListaEnlazadaGenerica<String> ();
			
			//Iniciamos el arreglo de booleanos, de visitados, EN FALSE
			boolean [] visitados = new boolean [this.mapaCiudades.listaDeVertices().tamanio()];
			
			this.caminoRecursion(resul, vertice, actual, ciudad2, sumaVert, visitados);
		}
		
		return resul.getMejorCamino();
	}
	
	//HAY QUE TESTEAR
	private void caminoRecursion(Resultado resultado, 
			Vertice<String> vertice, 
			ListaGenerica<String> actual, 
			String ciudad2,
			Integer sumaVert, boolean [] visitados) {
		
			if (vertice != null) {
				
				if (!vertice.dato().equals(ciudad2)) {
					visitados [vertice.getPosicion()] = true;
					sumaVert++;
					actual.agregarFinal(vertice.dato());
					
					ListaGenerica<Arista<String>> aristas = mapaCiudades.listaDeAdyacentes(vertice);
					aristas.comenzar();
					while (!aristas.fin()) {
						Arista<String> arista = aristas.proximo();
						Vertice<String> vDestino = arista.verticeDestino();
						if (visitados[vDestino.getPosicion()] == false) {
							this.caminoRecursion(resultado, vDestino, actual, ciudad2, sumaVert, visitados);
						}
					}
				} else {
					if (sumaVert < resultado.getCantVert()) {
						resultado.setCantVert(sumaVert);
						resultado.setMejorCamino((ListaEnlazadaGenerica<String>) actual.clonar());
					}
				}
		
				actual.eliminarEn(actual.tamanio());
			}
	}
}

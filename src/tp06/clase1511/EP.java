package tp06.clase1511;

import java.time.temporal.Temporal;

import tp02.ejercicio2.ListaGenerica;

public class EP {
	
	
		
	
		public void dfs_private_primerCaminoPosible (Grafo<T> grafo, 
				Vetice<T> vertice, 
				boolean [] visitados, 
				T datoB,
				ListaGenerica<T> camino, 
				ListaGenerica<T> temporal) {

		visitados[vertice.getPosicion()] = true;
		temporal.agregarFinal(vertice.dato());
	
	
		if (vertice.dato().equals(datoB))) {
			
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
			ListaEnlazadaGenerica<Arista<T>> aristas = grafo.listaDeAdyacentes(vertice);
			aristas.comenzar();
			while (!aristas.fin()) {
				Arista <T> arista = aristas.proximo();
				Vertice <T> verticeD = arista.verticeDestino();
				if (!visitados[verticeD]) {
					this.dfs_private_primerCaminoPosible (grado, verticeD, visitados, datoB, camino, temporal);
				}
			
			}
			
			// El desmarque lo hacemos para encontrar MULTIPLES CAMINOS, si es para encontrar 1 camino solo, No seria necesario
			//visitados[vertice.getPosicion()] = false;
			temporal.eliminarEn(temporal.tamanio());
		}
		
}
		
		
		
		public void dfs_private_pasandoPorAlgunNodo (Grafo<T> grafo, 
				Vetice<T> vertice, 
				boolean [] visitados,
				T datoB,
				ListaGenerica<T> camino, 
				ListaGenerica<T> temporal,
				T datoParaPasar,
				boolean encontrado) {

		visitados[vertice.getPosicion()] = true;
		temporal.agregarFinal(vertice.dato());
	
		// Proceso Dato
		if (vertice.dato().equals(datoParaPasar))
			encontrado = true;
		if (vertice.dato().equals(datoB)) && (encontrado == true)) {
			
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
			ListaEnlazadaGenerica<Arista<T>> aristas = grafo.listaDeAdyacentes(vertice);
			aristas.comenzar();
			while (!aristas.fin()) {
				Arista <T> arista = aristas.proximo();
				Vertice <T> verticeD = arista.verticeDestino();
				if (!visitados[vericeD]) {
					this.dfs_private_pasandoPorAlgunNodo (grado, verticeD, visitados, datoB, camino, temporal, datoParaPasar, encontrado);
				}
			
			}
			
			// El desmarque lo hacemos para encontrar MULTIPLES CAMINOS, si es para encontrar 1 camino solo, No seria necesario
			//visitados[vertice.getPosicion()] = false;
			temporal.eliminarEn(temporal.tamanio());
		}
		}
		
		
		public void dfs_private_SinPasarPorOtro (Grafo<T> grafo, 
				Vetice<T> vertice, 
				boolean [] visitados,
				T datoB,
				ListaGenerica<T> camino, 
				ListaGenerica<T> temporal,
				T datoParaPasar,
				boolean encontrado,
				T sinPasarPor) {

		visitados[vertice.getPosicion()] = true;
		temporal.agregarFinal(vertice.dato());
	
		// Proceso Dato
		if (vertice.dato().equals(datoParaPasar))
			encontrado = true;
		if (vertice.dato().equals(datoB)) && (encontrado == true)) {
			
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
			ListaEnlazadaGenerica<Arista<T>> aristas = grafo.listaDeAdyacentes(vertice);
			aristas.comenzar();
			while (!aristas.fin()) {
				Arista <T> arista = aristas.proximo();
				Vertice <T> verticeD = arista.verticeDestino();
				if (!visitados[verticeD] && !verticeD.dato().equals(sinPasarPor)) {
					this.dfs_private_SinPasarPorOtro (grado, verticeD, visitados, datoB, camino, temporal, datoParaPasar, encontrado, sinPasarPor);
				}
			
			}
			
			// El desmarque lo hacemos para encontrar MULTIPLES CAMINOS, si es para encontrar 1 camino solo, No seria necesario
			//visitados[vertice.getPosicion()] = false;
			temporal.eliminarEn(temporal.tamanio());
		}
		}
		
		public boolean dfs_private_PrimerCaminoYCorte (Grafo<T> grafo, 
				Vetice<T> vertice, 
				boolean [] visitados,
				T datoB,
				ListaGenerica<T> camino, 
				ListaGenerica<T> temporal,
				T datoParaPasar,
				boolean datoEncontrado,
				T sinPasarPor) {

		boolean encontreCaminoValido = false;
		visitados[vertice.getPosicion()] = true;
		temporal.agregarFinal(vertice.dato());
	
		// Proceso Dato
		if (vertice.dato().equals(datoParaPasar))
			datoEncontrado = true;
		if ((vertice.dato().equals(datoB)) && (datoEncontrado == true)) {
			
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
			
			encontreCaminoValido = true;
			
		} else {
			
			//Llamamos recursivamente
			ListaEnlazadaGenerica<Arista<T>> aristas = grafo.listaDeAdyacentes(vertice);
			aristas.comenzar();
			while (!aristas.fin() && !encontreCaminoValido) {
				Arista <T> arista = aristas.proximo();
				Vertice <T> verticeD = arista.verticeDestino();
				if (!visitados[verticeD] && !verticeD.dato().equals(sinPasarPor)) {
					encontreCaminoValido = this.dfs_private_PrimerCaminoYCorte (grafo, verticeD, visitados, 
							datoB, camino, temporal, 
							datoParaPasar, datoEncontrado, sinPasarPor);
				}
			
			}
			
			// El desmarque lo hacemos para encontrar MULTIPLES CAMINOS, si es para encontrar 1 camino solo, No seria necesario
			//visitados[vertice.getPosicion()] = false;
			temporal.eliminarEn(temporal.tamanio());
			
			return encontreCaminoValido;
		}
		}
		
		
		public void dfs_private_MejorCaminoMasVertices (Grafo<T> grafo, 
				Vetice<T> vertice, 
				boolean [] visitados,
				T datoB,
				ListaGenerica<T> camino, 
				ListaGenerica<T> temporal,
				T datoParaPasar,
				boolean datoEncontrado,
				T sinPasarPor) {

		visitados[vertice.getPosicion()] = true;
		temporal.agregarFinal(vertice.dato());
	
		// Proceso Dato
		if (vertice.dato().equals(datoParaPasar))
			datoEncontrado = true;
		if ((vertice.dato().equals(datoB)) && (datoEncontrado == true) && (temporal.tamanio() > camino.tamanio())) {
			
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
			ListaEnlazadaGenerica<Arista<T>> aristas = grafo.listaDeAdyacentes(vertice);
			aristas.comenzar();
			while (!aristas.fin()) {
				Arista <T> arista = aristas.proximo();
				Vertice <T> verticeD = arista.verticeDestino();
				if (!visitados[verticeD] && !verticeD.dato().equals(sinPasarPor)) {
					this.dfs_private_MejorCaminoMasVertices (grafo, verticeD, visitados, 
							datoB, camino, temporal, 
							datoParaPasar, datoEncontrado, sinPasarPor);
				}
			
			}
			
			// El desmarque lo hacemos para encontrar MULTIPLES CAMINOS, si es para encontrar 1 camino solo, No seria necesario
			visitados[vertice.getPosicion()] = false;
			temporal.eliminarEn(temporal.tamanio());
			
		}
		}
		
		
		
		
		
}

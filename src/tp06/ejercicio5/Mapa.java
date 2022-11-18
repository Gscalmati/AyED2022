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
	
	public void setMapaCiudades(Grafo<String> grafo) {
		// TODO Auto-generated method stub
		this.mapaCiudades = grafo;
		
	}
	
	public Vertice<String> buscarCiudad (String ciudad) {
		
		// Sacar lista de vertices para encontrar la C1
			ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
			vertices.comenzar();
			Vertice <String> vertice = null;
			while (!vertices.fin()) {
				vertice = vertices.proximo();
				// Si encuentro el V con esa Ciudad, salgo del while
				if (vertice.dato().equals(ciudad)) {
					break;
				}
			}
			return vertice;
	}
	
	//------------------------------------------------------------------------------------------//
	//INCISO A
	
	public ListaGenerica<String> devolverCamino (String ciudad1, String ciudad2) {
		Resultado resul = new Resultado ();
		
		Vertice<String> vertice = buscarCiudad(ciudad1);
		// Si encontré algo en el while, llamo a CaminoRecursion que me hace el camino
		if (vertice != null) {
			// Iniciamos camino y temporal
			ListaGenerica<String> camino = new ListaEnlazadaGenerica<String> ();
			ListaGenerica<String> temporal = new ListaEnlazadaGenerica<String> ();
			
			//Iniciamos el arreglo de booleanos, de visitados, EN FALSE, si usamos el GetPosicion(), aca es tamanio()+1, sino es GetPosicion()-1, con tamanio();
			boolean [] visitados = new boolean [this.mapaCiudades.listaDeVertices().tamanio()];
			
			this.caminoRecursion(resul, vertice, camino, temporal, ciudad2, visitados);
		}
		
		return resul.getMejorCamino();
	}
	
	private void caminoRecursion(Resultado resultado, 
			Vertice<String> vertice, 
			ListaGenerica<String> camino, 
			ListaGenerica<String> temporal, 
			String ciudad2,
			boolean [] visitados) {
		
			
			visitados [vertice.getPosicion()-1] = true; //Esto es porque usamos un boolean del tamanio de la lista de vertices, de 0 a CantNodos-1
			temporal.agregarFinal(vertice.dato());
			
				
			if (!vertice.dato().equals(ciudad2)) {
					
				ListaGenerica<Arista<String>> aristas = this.mapaCiudades.listaDeAdyacentes(vertice);
				aristas.comenzar();
				while (!aristas.fin()) {
					Arista<String> arista = aristas.proximo();
					Vertice<String> vDestino = arista.verticeDestino();
					
					
					if (!visitados[vDestino.getPosicion()-1]) {
						this.caminoRecursion(resultado, vDestino, camino, temporal, ciudad2, visitados);
					}
				}
			} else {
					resultado.setMejorCamino(temporal.clonar());
				}
			temporal.eliminarEn(temporal.tamanio());
	}
	
	//------------------------------------------------------------------------------------------//
		//INCISO B
	
	public ListaGenerica<String> devolverCaminoExceptuando (String ciudadOrig, String ciudadDestino, ListaGenerica<String> ciudades) {
		Resultado resul = new Resultado ();
		
		Vertice<String> vertice = buscarCiudad(ciudadOrig);
		if (vertice != null) {
			ListaGenerica<String> camino = new ListaEnlazadaGenerica<String> ();
			ListaGenerica<String> temporal = new ListaEnlazadaGenerica<String> ();
			
			//Iniciamos el arreglo de booleanos, de visitados, EN FALSE, si usamos el GetPosicion(), aca es tamanio()+1, sino es GetPosicion()-1, con tamanio();
			boolean [] visitados = new boolean [this.mapaCiudades.listaDeVertices().tamanio()];
			
			this.caminoRecursionExceptuando(resul, vertice, temporal, ciudadDestino, visitados, ciudades);
		}
		
		return resul.getMejorCamino();
	}
	
	private void caminoRecursionExceptuando(Resultado resultado, 
			Vertice<String> vertice, 
			ListaGenerica<String> temporal, 
			String ciudad2,
			boolean [] visitados,
			ListaGenerica<String> excepciones) {
		
			
			visitados [vertice.getPosicion()-1] = true; //Esto es porque usamos un boolean del tamanio de la lista de vertices, de 0 a CantNodos-1
			temporal.agregarFinal(vertice.dato());
			
				
			if (!vertice.dato().equals(ciudad2)) {
					
				ListaGenerica<Arista<String>> aristas = this.mapaCiudades.listaDeAdyacentes(vertice);
				aristas.comenzar();
				while (!aristas.fin()) {
					Arista<String> arista = aristas.proximo();
					Vertice<String> vDestino = arista.verticeDestino();
					
					
					
					
					if (!visitados[vDestino.getPosicion()-1] && !ciudadExenta(vDestino.dato() , excepciones)) {
						this.caminoRecursionExceptuando(resultado, vDestino, temporal, ciudad2, visitados, excepciones);
					}
				}
			} else {
					resultado.setMejorCamino(temporal.clonar());
				}
			temporal.eliminarEn(temporal.tamanio());
	}
	
	private boolean ciudadExenta (String ciudadActual, ListaGenerica<String> ciudadesExcepcion) {
		
		boolean esExcepcion = false;
		
		ciudadesExcepcion.comenzar();
		
		while (!ciudadesExcepcion.fin()) {
			if (ciudadesExcepcion.proximo().equals(ciudadActual))
				esExcepcion = true;
		}
		
		return esExcepcion;
	}
	
	//------------------------------------------------------------------------------------------//
			//INCISO C

	public ListaGenerica<String> devolverCaminoMasCorto (String ciudadOrig, String ciudadDestino) {
		Resultado resul = new Resultado ();
		
		Vertice<String> vertice = buscarCiudad(ciudadOrig);
		if (vertice != null) {
			ListaGenerica<String> camino = new ListaEnlazadaGenerica<String> ();
			ListaGenerica<String> temporal = new ListaEnlazadaGenerica<String> ();
			double kms = 0;
			
			//Iniciamos el arreglo de booleanos, de visitados, EN FALSE, si usamos el GetPosicion(), aca es tamanio()+1, sino es GetPosicion()-1, con tamanio();
			boolean [] visitados = new boolean [this.mapaCiudades.listaDeVertices().tamanio()];
			
			this.caminoRecursionMasCorto(resul, vertice, temporal, ciudadDestino, visitados, kms);
		}
		
		return resul.getMejorCamino();
	}
	
	private void caminoRecursionMasCorto(Resultado resultado, 
			Vertice<String> vertice, 
			ListaGenerica<String> temporal, 
			String ciudad2,
			boolean [] visitados,
			double kms) {
		
			
			visitados [vertice.getPosicion()-1] = true; //Esto es porque usamos un boolean del tamanio de la lista de vertices, de 0 a CantNodos-1
			temporal.agregarFinal(vertice.dato());
			
				
			if (!vertice.dato().equals(ciudad2)) {
					
				ListaGenerica<Arista<String>> aristas = this.mapaCiudades.listaDeAdyacentes(vertice);
				aristas.comenzar();
				while (!aristas.fin()) {
					Arista<String> arista = aristas.proximo();
					Vertice<String> vDestino = arista.verticeDestino();
					
					kms = kms + arista.peso();
					
					if (!visitados[vDestino.getPosicion()-1]) {
						this.caminoRecursionMasCorto(resultado, vDestino, temporal, ciudad2, visitados, kms);
					}
				}
			} else {
					System.out.println("Kms totales " + kms + " temporal hasta aca tiene estos nodos " + temporal.tamanio());
					if (kms <= resultado.getCantKms()) {
						resultado.setCantKms(kms);
						resultado.setMejorCamino(temporal.clonar());						
					}
				}
			temporal.eliminarEn(temporal.tamanio());
			visitados [vertice.getPosicion()-1] = false;
	}
	
	//------------------------------------------------------------------------------------------//
	//INCISO D
	
	public ListaGenerica<String> caminoSinCargarCombustible (String ciudadOrig, String ciudadDestino, int tanqueAuto) {
		Resultado resul = new Resultado ();
		double tanque = tanqueAuto;
		
		Vertice<String> vertice = buscarCiudad(ciudadOrig);
		if (vertice != null) {
			ListaGenerica<String> camino = new ListaEnlazadaGenerica<String> ();
			ListaGenerica<String> temporal = new ListaEnlazadaGenerica<String> ();
			double kms = 0;
			
			//Iniciamos el arreglo de booleanos, de visitados, EN FALSE, si usamos el GetPosicion(), aca es tamanio()+1, sino es GetPosicion()-1, con tamanio();
			boolean [] visitados = new boolean [this.mapaCiudades.listaDeVertices().tamanio()];
			
			this.caminoRecursionSinCombustible(resul, vertice, temporal, ciudadDestino, visitados, tanque);
		}
		
		return resul.getMejorCamino();
	}
	
	public void caminoRecursionSinCombustible (Resultado resul, 
			Vertice <String> vertice, 
			ListaGenerica<String> temporal, 
			String destino, 
			boolean [] visitados, 
			double tanque) {
		
		visitados[vertice.getPosicion()-1] = true;
		temporal.agregarFinal(vertice.dato());
		
		if (!vertice.dato().equals(destino)) {
			
			ListaGenerica<Arista<String>> aristas = this.mapaCiudades.listaDeAdyacentes(vertice);
			aristas.comenzar();
			
			while (!aristas.fin()) {
				Arista<String> arista = aristas.proximo();
				Vertice<String> vDestino = arista.verticeDestino();
				
				double consumoViaje = tanque - calcularLitrosPorViaje(arista.peso());
				
				if ((!visitados[vDestino.getPosicion()-1]) && (consumoViaje > 0)) {
					tanque = consumoViaje;
					System.out.println("TANQUE " + tanque);
					this.caminoRecursionSinCombustible(resul, vDestino, temporal, destino, visitados, tanque);
				}
			}
			
		} else {
			
			resul.setMejorCamino(temporal.clonar());
		}
		
		temporal.eliminarEn(temporal.tamanio());
		visitados[vertice.getPosicion()-1] = false;
		
		
		
	}

	private double calcularLitrosPorViaje(double kmsViaje) {
		
		double kmsLitro = 12;
		return kmsViaje/kmsLitro;
	}
	
	//------------------------------------------------------------------------------------------//
		//INCISO E
	
}
